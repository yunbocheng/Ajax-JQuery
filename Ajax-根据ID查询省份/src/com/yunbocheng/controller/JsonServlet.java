package com.yunbocheng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunbocheng.dao.ProvinceDao;
import com.yunbocheng.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        // 默认值，表示json格式的数据 {}
        // 获取请求参数，省份的id
            String strProid= req.getParameter("proid");
        // 判断proid有值时，调用dao查询数据，并求数据不为空的
        if (strProid != null && strProid.trim().length() > 0) {
            // 调用判断该数据据在数据库中
                ProvinceDao dao = new ProvinceDao();
                Province p = dao.queryProvinceById(Integer.valueOf(strProid));
                // 需要使用jackson 把 Province对象 p 转换为 json
                ObjectMapper om = new ObjectMapper();
                // 此时的json是一个字符串，他的格式就是json格式
                json = om.writeValueAsString(p);
        }
        // 把获获取的数据，通过网络传递给ajax异步对象，响应结果数据
        // 指定服务器端（servlet）返回浏览器的是json格式的数据
        // 设置此时的响应体编辑格式  此时的数据是 json 格式，而不是文本以及html格式
        // application/json作为请求头，用来告诉服务端消息主体是序列化的JSON字符串
        resp.setContentType("application/json;charset=utf-8");
        // 创建一个通道对象用来传输结果
        PrintWriter out = resp.getWriter();
        // 传递数据，会将这个数据传递给ajax中的 responseText 属性
        out.println(json);
        // 刷新通道
        out.flush();
        // 释放通道
        out.close();
    }
}

