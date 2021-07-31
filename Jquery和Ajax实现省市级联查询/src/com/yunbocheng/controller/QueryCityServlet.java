package com.yunbocheng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunbocheng.dao.QueryDao;
import com.yunbocheng.entity.city;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryCityServlet extends HttpServlet {

    // 定义一个json，代表这个方法的结果
    String json = "{}";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 此时查询的是根据用户在第一个列表中选中的省份的id来查询其对应的市区名称
        // 所以此时会有请求参的存在，这个参数就是省份的id值，先获取这个参数信息
        // 这个 proid 就是请求参数
        String strProvinceId = req.getParameter("proid");
        // 判断传递过来的这个参数是不是为空或者是不是空字符串
        if (strProvinceId != null && !"".equals(strProvinceId.trim())) {
            QueryDao dao = new QueryDao();
            List<city> cityList = dao.queryCityList(Integer.valueOf(strProvinceId));
            // 通过jackson将 cityList转为json格式的数据
            System.out.println(cityList.size());
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(cityList);
        }
        // 获取到 json格式的数据，要输出这个 json数据，响应ajax请求，
        // 返回从数据库中获取到的数据，返回给用户，展现在浏览器上
        // 首先设置一下ajax响应之后重新编写这个响应内容的格式
        // 此时是一个 json 格式的数据，所有需要设置为 json编译方式。
        resp.setContentType("application/json;charset=utf-8");
        // 获取一个输出流对象
        PrintWriter pw = resp.getWriter();
        // 将json格式的合格数据放入到输出流中响应给 ajax请求
        pw.println(json);
        // 清理通道
        pw.flush();
        // 关闭通道
        pw.close();
    }
}
