package cn.aynuedu.goods.dao;

import cn.aynuedu.pojo.Goods;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/13 16:45
 */

public class GoodsDao extends BaseDao {
    public List<Goods> findAllGoods() {
        List<Goods> goodsList = null;

        try {
            goodsList = super.queryBeanList("select * from myshop.goods", Goods.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goodsList;
    }
}
