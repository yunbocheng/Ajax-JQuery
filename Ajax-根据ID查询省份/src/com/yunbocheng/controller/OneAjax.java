package com.yunbocheng.controller;

import com.yunbocheng.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.SignStyle;

public class OneAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取用户输入的参数信息也就是 查询省份的id
        String resultid = req.getParameter("proid");
        System.out.println("用户查询的省份id ：" + resultid);
        // 定义一个最终查询到的省份的名称，当用户输入的是空的时候输出
        String resultName = "输入的查询数据不能为空";
        // 访问dao，查询数据库，resultid有数值才可以查询，先判断是否有数值
        // 并且查询的数据不是一个空字符串，如过是空字符串，在进行Integer.valueOf()
        // 包装转换的时候会报错，原因：无法将空字符串包装为Integer。
        if(resultid != null && !"".equals(resultid.trim())){
            // 判断数据库中有无此数据，如果小于10，说明这个id在数据库中存在
            if(Integer.valueOf(resultid) < 10 && Integer.valueOf(resultid) > 0) {
                // 创建一个dao对象，调用他的方法进行查询
                ProvinceDao dao = new ProvinceDao();
                // 因为在 ProvinceDao类的queryProvinceNameById方法
                // 在定义的时候传递的是一个Integer类型的数值，所以此时要
                // 进行强制转换一下，将String类型转换为Integer类型。
                resultName = dao.queryProvinceNameById(Integer.valueOf(resultid));
            }else {
                resultName = "对不起，您查询的数据不存在！！";
            }
        }
        // 使用XMLHttpSRequest输出数据
        // 获取一个输出流对象
        // 设置一下响应的编码格式，此时是文本以及Http代码
        resp.setContentType("text/http;charset = utf-8");
        PrintWriter out = resp.getWriter();
        // 使用输出流对象输出数据
        out.print(resultName);
        // 清理通道(缓存)
        out.flush();
        // 关闭通道
        out.close();
    }
}
