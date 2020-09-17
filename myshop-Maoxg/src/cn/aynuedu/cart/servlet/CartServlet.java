package cn.aynuedu.cart.servlet;

import cn.aynuedu.cart.dao.CartDao;
import cn.aynuedu.pojo.Shoppingcart;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/14 11:44
 */
@WebServlet("/cart.action")
public class CartServlet extends BaseServlet {
    private CartDao cartDao = new CartDao();

    /**
     * 添加购物车模块
     * 该模块负责对数据的判定和插入操作。
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */

    public void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("come here add");
        //不去创建一个session，使用当前页面的额session，取出预先加载到session中的userId值根据这个值可以很多是
        HttpSession aFalse = request.getSession(false);
        Object userId1 = aFalse.getAttribute("userId");
        System.out.println("userID" + userId1);
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        int pid = Integer.parseInt(request.getParameter("pid"));
        System.out.println(pid);
        int num = Integer.parseInt(request.getParameter("num"));
        System.out.println(num);
        System.out.println(Integer.parseInt(request.getParameter("price")));
        int price = Integer.parseInt(request.getParameter("price"));


        //test  编码集
        // String goodsName1 = new String(request.getParameter("goodsName").getBytes("ISO-8859-1"), "UTF-8");
        //System.out.println("goodsName1" + goodsName1);
        //test 编码集

        //把商品号更改为商品名称
        String goodsName = request.getParameter("goodsName");
        HttpSession session1 = request.getSession(true);
        session1.setAttribute("goosName", goodsName);
        request.setAttribute("goodsName", goodsName);
        //把商品号更改为商品名称

        //根据用户id和pid进行数据的合并，过滤掉重复数据，如果重复将数量num进行更新

        HttpSession session = request.getSession(false);
        Object userId = session.getAttribute("userId");
        int uId = Integer.parseInt(String.valueOf(userId));
        List<Shoppingcart> idCart1 = cartDao.findIdCart(uId);
        int sign = 0;

        for (Shoppingcart shoppingcart : idCart1) {
            if (shoppingcart.getPid() == pid) {
                num += shoppingcart.getNum();
                sign = 1;
                cartDao.combineNum(num, pid);
                //查找展示当前用户所对应的购物车库数据
                List<Shoppingcart> idCart = cartDao.findIdCart(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("list", idCart);
                request.getRequestDispatcher("jsp/cart/showCart.jsp").forward(request, response);
                break;
                  //这里使用break一旦找到一条符合要求的数据，
                  // 就直接结束不找了，因为数据库中
                  //数据默认不重复
            }
        }

        if (sign == 0){
            //将数据放入到购物车类
            Shoppingcart shoppingcart = new Shoppingcart(id, pid, num, price);

            //将购物车类需要的数据添加到数据库
            cartDao.addCart(shoppingcart);

            //查找展示当前用户所对应的购物车库数据
            List<Shoppingcart> idCart = cartDao.findIdCart(Integer.parseInt(request.getParameter("id")));


            //测试用
            System.out.println(idCart.isEmpty());

            request.setAttribute("list", idCart);
            request.getRequestDispatcher("jsp/cart/showCart.jsp").forward(request, response);
        }


    }

    public void listCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shoppingcart> list = cartDao.findAllCart();
        request.setAttribute("list", list);

        request.getRequestDispatcher("jsp/cart/showCart.jsp").forward(request, response);
    }

    /**
     * 但是注意这里并没有将数据展示交给该页面进行展示，因为是重定向到该方法进行数据处理，但是该方法需要一个参数id去确认展示哪些数据，
     * 当前重定向数据传递我还没有掌握，所以这个方法并没有卵用
     * 将该方法整合到前台数据添加了，上面的addCart既是添加有是查询，不妥。
     *  推倒重来，这里并不是没有用处，mian.jsp页面中也有一个查看购物车，哪里可以传输数据(用户Id)到后台,只展示当天登录用户的购物车
     * 对用户购物车进行限制，规定在用户登录的时候就将用户号从数据库中取出来，保存到session中，在main.jsp页面
     * 将数据获取到(${sessionScope.userID})，使用input标签的hidden属性，name="id"使用get请求将用户id通过浏览器url传到后台中，
     * 后台request.getparameter("id")获取到
     * @param request 请求
     * @param response 响应
     * @throws ServletException sql异常
     * @throws IOException  io输出异常
     */
    public void listCartLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come here limit");
        HttpSession session = request.getSession(false);
        Object userId = session.getAttribute("userId");
        int uId = Integer.parseInt(String.valueOf(userId));
       // System.out.println("ordinary" + request.getParameter("id"));
       // System.out.println("integer " + Integer.parseInt(request.getParameter("id")));
//        List<Shoppingcart> idCart = cartDao.findIdCart(Integer.parseInt(request.getParameter("id")));
        List<Shoppingcart> idCart = cartDao.findIdCart(uId);


        System.out.println(idCart.isEmpty());
        request.setAttribute("list", idCart);
        request.getRequestDispatcher("jsp/cart/showCart.jsp").forward(request, response);
    }

    /**
     * 删除所有购物车中的内容
     */
    public void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come here delete");

        System.out.println("id " + request.getParameter("id"));
        cartDao.clearCart(Integer.parseInt(request.getParameter("id")));

        request.getRequestDispatcher("jsp/cart/showCart.jsp").forward(request, response);

    }

    /**
     * 根据商品pid删除指定的数据，对应的具体模块为删除购物车中的一条数据
     */
    public void deletePidCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("come on deletePidCart");
        System.out.println("pid" + request.getParameter("pid"));
        HttpSession session = request.getSession(false);
        Object userId = session.getAttribute("userId");
        int uId = Integer.parseInt(String.valueOf(userId));
        System.out.println("userId" + userId);
        int pid = Integer.parseInt(request.getParameter("pid"));
        cartDao.clearCartPid(pid, uId);

        response.sendRedirect("cart.action?method=listCartLimit");

    }


    //修改购物车中商品数量

    public void modifyCartNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come on midifyCartNum");
        String num = request.getParameter("num");
        System.out.println("num1:" + Integer.parseInt(request.getParameter("num")));
        System.out.println("num2:" + num);
        //把商品号更改为商品名称
        Object goodsName1 = request.getSession(false).getAttribute("goodsName");
      //  String goodsName = request.getParameter("goodsName");
        System.out.println("goodsName1" + goodsName1);
        //把商品号更改为商品名称
        int uId = Integer.parseInt(request.getParameter("id"));
        System.out.println(uId);

        cartDao.combineNum(Integer.parseInt(request.getParameter("num")), uId);

        List<Shoppingcart> idCart = cartDao.findIdCart(Integer.parseInt(request.getParameter("userId")));
        request.setAttribute("list", idCart);
        request.getRequestDispatcher("jsp/cart/showCart.jsp").forward(request, response);
    }


}
