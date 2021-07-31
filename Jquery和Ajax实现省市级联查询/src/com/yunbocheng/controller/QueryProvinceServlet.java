package com.yunbocheng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunbocheng.dao.QueryDao;
import com.yunbocheng.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在这里定义一个json格式的变量，json变量的数据类型是字符串String
        // json是一个 json格式的字符串。
        // 这里定义json的时候，初始化一个类似json格式的初始值。
        // 如果定义为 null 也没有问题。
        String json = "{}";
        // 调用dao，获取所有的省份信息，市是一个List集合
        QueryDao dao = new QueryDao();
        // 调用这个类中的queryProvinceList()方式获取数据库中的所有省份信息
        List<Province> provinces = dao.queryProvinceList();
        // 把这个 provinces 集合中的信息转换为 json格式的数据，输出给ajax请求
        // 首先判断 provinces 这个集合有没有从数据库中获取到数据
        // 如果获取到了将这些数据转换为 json 格式的数据，如果没有不进行转换
        // provinces 是一个集合对象，只要里边有数据就不可能为 null
        if (provinces != null){
            // 此时说明 provinces 这个集合中存在数据，将数据转换为json格式的数据
            // 调用jackson工具库，实现 List格式数据 --> json格式数据的转换。
            ObjectMapper om = new ObjectMapper();
            // writeValueAsString：把参数的Java对象转化为json格式的字符串
            // 此时的java对象就是这个 provinces 集合。
            json = om.writeValueAsString(provinces);
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
