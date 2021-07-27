package com.yunbocheng.dao;

import com.yunbocheng.entity.Province;

import java.sql.*;
import java.util.Collection;

/**
 * 这个类要连接数据库根据省份id获取省份名称。
 */
// 使用最传统dbc连接数据库
public class ProvinceDao {

    // 根据id获取名称
    public String queryProvinceNameById(Integer proviceId){
        // 访问数据库，连接对象
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";

        String url = "jdbc:mysql://localhost:3306/area";
        String username = "root";
        String password = "567cybtfboys";

        // 得到的最终结果
        String result= "";

        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            // 创建PreparedStatement对象
            sql = "select name from province where id=?";
            pst = conn.prepareStatement(sql);
            // 设置参数值 1代表第一个占位符，proviceId代表传递的省份编号
            pst.setInt(1,proviceId);
            // 执行sql
            rs = pst.executeQuery();
            // 遍历 rs 当你的rs中有多余一条记录时。可以使用while这样的循环方式
            // 下边的这个name是我们最终得到的结果，参数中的name是表中的name数据
            // 例如：当查询的 Id=1时，此时参数中的 name值是 河北
            // 将这个河北取出来交给最终的结果 name
            while (rs.next()){
                result = rs.getString("name");
            }
            /*
            按照以下这种方式写也可以的，因为此时查询的是 id对应的城市名，
            因为此时id是主键，整个表文件中只存在一个，只会有一条查询结果，
            所以使用if也可以的。多条的时候建议使用 while(rs.next());
                if(rs.next()){
                result = rs.getString("name");
                }
            */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    // 根据id获取一个完整的 Province 对象
    public Province queryProvinceById(Integer proviceId){
        // 访问数据库，连接对象
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "";

        String url = "jdbc:mysql://localhost:3306/area";
        String username = "root";
        String password = "567cybtfboys";

        // 返回的一个完整的Province对象
        Province province = null;

        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            // 创建PreparedStatement对象
            sql = "select id,name,jiancheng,shenghui from province where id=?";
            pst = conn.prepareStatement(sql);
            // 设置参数值 1代表第一个占位符，proviceId代表传递的省份编号
            pst.setInt(1,proviceId);
            // 执行sql
            rs = pst.executeQuery();
            // 遍历 rs 当你的rs中有多余一条记录时。可以使用while这样的循环方式
            // 下边的这个name是我们最终得到的结果，参数中的name是表中的name数据
            // 例如：当查询的 Id=1时，此时参数中的 name值是 河北
            // 将这个河北取出来交给最终的结果 name
            while (rs.next()){
                province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJiancheng(rs.getString("jiancheng"));
                province.setShenghui(rs.getString("shenghui"));
            }
            /*
            按照以下这种方式写也可以的，因为此时查询的是 id对应的城市名，
            因为此时id是主键，整个表文件中只存在一个，只会有一条查询结果，
            所以使用if也可以的。多条的时候建议使用 while(rs.next());
                if(rs.next()){
                result = rs.getString("name");
                }
            */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return province;
    }
}
