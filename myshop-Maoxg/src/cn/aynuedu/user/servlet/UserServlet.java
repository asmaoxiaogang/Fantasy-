package cn.aynuedu.user.servlet;

import cn.aynuedu.user.dao.UserDao;
import cn.aynuedu.user.pojo.User;
import org.apache.commons.beanutils.BeanUtils;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:40
 */
@WebServlet("/user.action")
public class UserServlet extends BaseServlet {
    private UserDao userDao = new UserDao();

    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = "0";
        status = request.getParameter("status");
        //用户选择不去自动登录就不去创建session存储用户数据
        if ("0".equals(status)){
            //创建一个session用来首次登录的用户数据
            HttpSession session = request.getSession(false);

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //后续完善的话，需要从前端获取到一个数据来辨别是否需要自动登录，不需要，就把session中的数据清空
            System.err.println(request.getParameter("status"));
            //session不存在，为新用户登录
            MsgVerify(request, response, username, password, session, status);
        }else {//用户选择自动登录，创建session保存用户数据
            HttpSession session = request.getSession(true);

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //后续完善的话，需要从前端获取到一个数据来辨别是否需要自动登录，不需要，就把session中的数据清空
            System.err.println(request.getParameter("status"));
            //session不存在，为新用户登录
            MsgVerify(request, response, username, password, session, status);
        }

    }

    public void autoUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        System.out.println("this come on");
        //username和password要从数据库中拿数据，比对session的数据和数据库是否一致
//        System.out.println(session.getAttribute("username") );
//        System.out.println(session.getAttribute("password") );
        if (session != null) {
            System.out.println("for");
            List<User> allUser = userDao.findAllUser();

            for (User user : allUser) {
                System.out.print("session");
                System.out.println(session.getAttribute("username"));
                System.out.print("session");
                System.out.println(session.getAttribute("password"));
                System.out.println(user.getUsername());
                System.out.println(user.getPassword());
                //判定session是否存在数据，存在数据，且与数据库中username，password进行比较，成功直接登录
                if (user.getUsername().equals(session.getAttribute("username"))
                        && user.getPassword().equals(session.getAttribute("password"))) {
                    //但这里需要验证session中数据是否存在，如果数据库中数据不存在了，即使session中有数据仍然不允许登录
                    response.sendRedirect("goods.action?method=listGoods");
                    //满足session和数据库验证直接请求转发到main.jsp页面
                   // request.getRequestDispatcher("jsp/main.jsp").forward(request, response);
                    break;
                }
            }
        }else {
            System.out.println("登录页面幻影");
            //session 中没有数据就请求转发到登录页面
            request.getRequestDispatcher("loginmy.jsp").forward(request, response);
        }



    }

    private void MsgVerify(HttpServletRequest request, HttpServletResponse response, String username, String password, HttpSession session, String status) throws ServletException, IOException {
        //根据输入的数据去查询数据库得到返回值
        User user = userDao.loginUser(username,password);
        long userId = user.getId();
        //如果user存在数据不为空，数据库比对成功，判定用户名密码正确
        if (null != user){
            //如果session不存在的话，就去创建新的session！！！
            //严格来讲的话还要有一级验证，获取用户是否需要自动登录选项，如果status不是初始值0那么就保存session
            if (!"0".equals(status)) {
                // if (session == null && !"0".equals(status)){
                //添加数据到预先创建的session中
                session.setMaxInactiveInterval(60 * 60);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("userId", userId);

                //60 * 60为一小时 * 24 是一天 * 15 是十五天
                session.setMaxInactiveInterval(60 * 60 * 24 * 15);
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                //设置cookie的有效时间为15天
                cookie.setMaxAge(60 * 60 * 24 * 15);
                response.addCookie(cookie);
                //新用户登录的话session中没有数据，就把新数据保存到session中！！！
                request.setAttribute("user", user);
                //保存用户信息map中传输到前端
                Map<String, String> map =new HashMap<>();
                map.put("username", username);
                try {
                    //传输数据到前端
                    BeanUtils.populate(user, map);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("goods.action?method=listGoods");
                //请求转发
               // request.getRequestDispatcher("jsp/main.jsp").forward(request, response);
            } else if ("0".equals(status)) {
                //如果保存用户是否选择自动保存的选项为0那么就认为不保存用户信息，不自定登录。
                //这里loginUser中status对是否创建session数据进行了限制
                //销毁session session.invalidate();
                response.sendRedirect("goods.action?method=listGoods");
               // request.getRequestDispatcher("jsp/main.jsp").forward(request, response);

            }


        } else {
            //  session.invalidate();
            //请求转发
            request.getRequestDispatcher("loginmy.jsp").forward(request, response);
        }
    }

    public void userLoginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //如果为false不创建新的session
        HttpSession session = request.getSession(false);
        if (session != null) {
            //销毁session
            session.invalidate();
        }
        response.sendRedirect("loginmy.jsp");
    }
    public void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> userMap = request.getParameterMap();

        User user = new User();

        try {
            BeanUtils.populate(user, userMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        userDao.addUser(user);

        // 重定向到indexServlet
        response.sendRedirect("user.action?method=listUser");
    }

    public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> allUser = userDao.findAllUser();
        request.setAttribute("allUser", allUser);

        //请求转发
        request.getRequestDispatcher("/jsp/user/listUser.jsp").forward(request, response);
    }




}
