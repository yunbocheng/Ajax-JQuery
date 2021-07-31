package com.yunbocheng.dao;

import com.yunbocheng.entity.Province;
import com.yunbocheng.entity.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义这个QueryDao类 在其中定义查询的方法
 * 以及绑定数据库
 * 这个类的主要作用就是连接数据库，从数据库中取出数据将其存到
 * Province对象的这个List<Province>集合中，为Servlet服务做准备。
 * city对象的这个List<City>集合中，为Servlet服务做准备。
 */
public class QueryDao {

    // 连接数据库，以下是连接数据库时所要用到的变量
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sql;
    private String url="jdbc:mysql://localhost:3306/area";
    private String name = "root";
    private String password = "567cybtfboys";

    // 定义一个查询所有的省份信息的方法
    // 查询到的省份信息有多个，且查询到的每一个都是一个 Province 对象
    // 所以将这个结果放入到一个 Province对象的List集合中
    public List<Province> queryProvinceList(){

        /*创建一个 Province 对象，用来接收数据 */
        /*
         * 这个时候在 while的外边就行声明p对象，因为如果在 while中声明
         * 此时在 while的外边就拿不到这个 Province 对象，获取不到这个对象
         * 从数据库中取出的 信息
         * */
        Province p  = null;
        /**
         * 在 while 循环体的外边声明一个ArrayList集合，
         * 其中的元素都是 Province对象。这些Province对象就是
         * 数据库中 Province 表中所有的 省份信息。
         * 此时这个 provinces 集合中存在所有的省份信息
         */
        List<Province> provinces = new ArrayList<>();

        /*连接数据库*/
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,name,password);
            sql = "select id,name,jiancheng,shenghui from province order by id";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setJiancheng(rs.getString("jiancheng"));
                p.setShenghui(rs.getString("shenghui"));
                /*将这些从数据库中取出的 province 对象存储到这个list集合中*/
                provinces.add(p);
            }
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
        return provinces;
    }

    // 查询一个省份下边的所有城市
    // 这个方法中的参数就是用户在省份下拉列表中选中的那个省份所对应的 id值。为Integer类型
    public List<city> queryCityList(Integer provinceid){

        /*创建一个 Province 对象，用来接收数据 */
        /*
         * 这个时候在 while的外边就行声明p对象，因为如果在 while中声明
         * 此时在 while的外边就拿不到这个 Province 对象，获取不到这个对象
         * 从数据库中取出的 信息
         * */
        city city  = null;
        /**
         * 在 while 循环体的外边声明一个ArrayList集合，
         * 其中的元素都是 Province对象。这些Province对象就是
         * 数据库中 Province 表中所有的 省份信息。
         * 此时这个 provinces 集合中存在所有的省份信息
         */
        List<city> cities = new ArrayList<>();
        /*连接数据库*/
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,name,password);
            sql = "select id,name from city where provinceid = ? ";
            pst = conn.prepareStatement(sql);
            // 设置省份的参数值
            pst.setInt(1,provinceid);
            rs = pst.executeQuery();
            while (rs.next()){
                city = new city();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                cities.add(city);
            }
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
        return cities;
    }
}
