package cn.aynuedu.orders.dao;

import cn.aynuedu.orders.pojo.Order;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:35
 */
public class OrderDao extends BaseDao {
    /**
     * 插入订单
     */
    public void addOrderDao(Order order) {
        String sql = "insert into myshop.order values(?,?, ?, ?, ?, ?)";
        Object[] parameters = {order.getId(), order.getUid(), order.getMoney(), order.getStatus(), order.getTime(), order.getAid()};
        try {
            super.update(sql, parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询当前用户Uid所对应的所有订单信息
     * @param uid 当前用户Id号
     * @return
     */
    public List<Order> findAllOrder(int uid) {
        List<Order> list = null;
        String sql = "select * from myshop.order where uid = "+uid+"";
        try {
            list = super.queryBeanList(sql, Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
