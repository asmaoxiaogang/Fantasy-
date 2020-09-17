package cn.aynuedu.orders.servlet;

import cn.aynuedu.orders.dao.OrderDao;
import cn.aynuedu.orders.pojo.Order;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:40
 */

/**
 * 改处理器处理从showCart.jsp页面来的数据，即从购物车到订单页面的跳转
 */
@WebServlet("/order.action")
public class OrderServlet extends BaseServlet {
    private OrderDao orderDao = new OrderDao();

    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come on addOrder");
        int uid = Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId")));
        System.out.println("当前用户id" + uid);
        int num = Integer.parseInt(request.getParameter("num"));
        System.out.println("数量" + num);
        int price = Integer.parseInt(request.getParameter("price"));
        System.out.println("价格" + price);
        int money = num * price;
        System.out.println("总额" + money);

        //状态描述为0(未支付状态)
        int status = 0;

        //获取当前时间去插入到数据中
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置日期格式
        Timestamp time = Timestamp.valueOf(df.format(new Date()));
        // new Date()为获取当前系统时间
        System.out.println("当前时间" + time);

        //先给一个默认值，前提是数据库address中有这条数据
        int aid = 1;

        Order order = new Order();
        order.setUid(uid);
        order.setMoney(money);
        order.setStatus(status);
        order.setTime(time);
        order.setAid(aid);

        orderDao.addOrderDao(order);
        response.sendRedirect("order.action?method=listOrder");

        /**
        * 第一版的设想推翻掉，理由先把订单处理了，再去选择地址信息的处理
        *这里规定先去选择地址信息，如果没有去填写新的地址信息后再进行商品的购买，订单的生成
        *  先获取到地址信息，在到插入订单数据库中，因为order表中需要拿到address表中的orderId
         // request.getRequestDispatcher("jsp/address/inputAddress.jsp").forward(request, response);
        */
    }

    public void listOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come on listOrder");
        List<Order> list = orderDao.findAllOrder(Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId"))));
        System.out.println("list:" + list.isEmpty());
        request.setAttribute("list", list);
        request.getRequestDispatcher("jsp/order/showOrder.jsp").forward(request, response);
    }


}
