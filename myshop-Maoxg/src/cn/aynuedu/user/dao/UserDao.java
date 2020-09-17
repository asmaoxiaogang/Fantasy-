package cn.aynuedu.user.dao;

import cn.aynuedu.pojo.Goods;
import cn.aynuedu.user.pojo.User;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/12 10:03
 */
public class UserDao extends BaseDao {
    public User loginUser(String username, String password) {
        String sql = "select * from myshop.user where username = '"+username+"' && password = '"+password+"' ";
        User user = null;
        try {
           user = super.queryBean(sql, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user){
        String sql = "insert into myshop.user(username, password, email, gender, flag, role, code) values (?, ?, ?, ?, ?, ?, ?)";
        Object[] parameters = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getFlag(), user.getRole(), user.getCode()};

        try {
            super.update(sql, parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAllUser() {
        List<User> list = null;

        try {
            list = super.queryBeanList("select * from myshop.user", User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Goods> findAllGoods() {
        List<Goods> goodsList = null;
        try {
            goodsList = super.queryBeanList("select * from myshop.goods", Goods.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  goodsList;

    }
 }
