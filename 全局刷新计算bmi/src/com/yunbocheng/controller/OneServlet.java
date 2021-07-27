package com.yunbocheng.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求对象参数信息
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
        String result = "您的检测结果为 ： " + bmi + ",属于" + str;
         // 使用请求对象，将共享输入写入进去
        req.setAttribute("key",result);
        // 向Tomcat申请调用 index_1.jsp ，读取共享数据并进行显示
        req.getRequestDispatcher("/index_1.jsp").forward(req,resp);
    }
}
