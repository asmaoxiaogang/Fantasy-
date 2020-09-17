package cn.aynuedu.goods.servlet;

import cn.aynuedu.goods.dao.GoodsDao;
import cn.aynuedu.pojo.Goods;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/13 16:47
 */
@WebServlet("/goods.action")
public class GoodsServlet extends BaseServlet {
    private GoodsDao goodsDao = new GoodsDao();
    public void listGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> goodsList = goodsDao.findAllGoods();
        request.setAttribute("goodsList", goodsList);

        request.getRequestDispatcher("jsp/main.jsp").forward(request, response);
    }

}
