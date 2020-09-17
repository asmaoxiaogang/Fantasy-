package cn.aynuedu.cart.dao;

import cn.aynuedu.pojo.Goods;
import cn.aynuedu.pojo.Shoppingcart;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/14 11:46
 */
public class CartDao extends BaseDao {
    public void addCart(Shoppingcart shoppingcart) {
        String sql ="insert into myshop.shoppingcart values(?, ?, ?, ?)";
        Object[] parameters = {shoppingcart.getId(), shoppingcart.getPid(), shoppingcart.getNum(), shoppingcart.getPrice()};

        try {
            super.update(sql, parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Shoppingcart> findAllCart(){
        List<Shoppingcart> list = null;
        String sql = "select * from myshop.shoppingcart";
        try {
           list = super.queryBeanList(sql, Shoppingcart.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * 查询当前登录用户对应的购物车数据
     * @param id 用户号
     * @return
     */
    public List<Shoppingcart> findIdCart(int id) {
        List<Shoppingcart> list = null;
        String sql = "select * from myshop.shoppingcart where id = "+id+"";
        try {
            list = super.queryBeanList(sql, Shoppingcart.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Goods> goodsMsgFilter(int goodsid) {
        List<Goods> list = null;

        String sql = "select goods.id,goods.price from myshop.goods where id = "+goodsid+" ";
        try {
            list = super.queryBeanList(sql, Goods.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    //清空购物车方法
    public void clearCart(int userId) {
        String sql = "delete from myshop.shoppingcart where id="+userId+"";
        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

/**
 * 根据pid删除shoppingCart表中的数据
 * 即删除指定数据
 */

        public void clearCartPid(int pid, int userId) {
            String sql = "delete from myshop.shoppingcart where pid="+pid+" and id="+userId+"";
            try {
                super.update(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    /**
     * 主要根据id和pid将用户输入数据进合并，合并的是id和pid中数量num
     *
     */
    public void combineNum(int num, int pid) {
        String sql = "update myshop.shoppingCart set num = "+num+" where pid="+pid+"";
        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void modifyNum(int num, int pId) {
        String sql = "update myshop.shoppingCart set num = "+num+" where pid="+pId+"";
        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
