package cn.aynuedu.address.servlet;

import cn.aynuedu.address.dao.AddressDao;
import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:40
 */

/**
 * 该处理器配合orderservlet使用，在用户点击结算后展示购买商品信息，并附上信息录入。
 */
@WebServlet("/address.action")
public class AddressServlet extends BaseServlet {
    private AddressDao addressDao = new AddressDao();


    /**
     * 添加新的地址信息到数据库中和registerAddress.jsp有关
     * @param request
     * @param response
     */
    public void addAddress(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("come on addAddress");
        int uid =  Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId")));

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String area = request.getParameter("area");
        String street = request.getParameter("street");
        String details = request.getParameter("details");

        String detail = province + city + area + street + details;

        //这里的level标志信息插入的顺序或是判断是否重复跟数据库查询有关，设计到数据的合并
        int level = 1;

    }
}
