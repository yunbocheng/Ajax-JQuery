package com.yunbocheng.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 以下的数据会在idea服务器进行输出，不会传递给浏览器，只是在idea的服务端进行显示
        System.out.println("配置成功");
        // 接收参数信息
        String name = req.getParameter("name");
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        // 转换参数进行计算
        Float valueOf = Float.valueOf(weight);
        Float aFloat = Float.valueOf(height);
        float bmi = valueOf / (aFloat*aFloat);
        String str = "";
        if(bmi <= 18.5){
            str = "过轻";
        }else if(bmi > 18.5 && bmi <=23.9){
            str = "正常";
        }else if(bmi > 24 && bmi<= 27){
            str = "过重";
        }else {
            str = "肥胖";
        }
        System.out.println("您的检测结果： " + str);
        String result = "您的姓名为：" + name + "您的检测结果为 ： " + bmi + ",属于" + str;
        // 响应ajax需要的数据，使用HttpServletResponse输出数据
        // 首先设置一下输出数据的格式
        resp.setContentType("text/html;charset=utf-8");
        // 获取一个输出流对象 out
        PrintWriter out = resp.getWriter();
        /*
        * alert(xmlHttp.responseText);
        * responseText：代表从服务端返回的数据，
        * 此时输出的result结果会传递给responseText
        * 此时 responseText = result 通过异步对象xmlHttp.responseText输出到浏览器。
        */
        out.print(result);
        // 刷新通道
        out.flush();
        // 释放通道
        out.close();

    }
}
