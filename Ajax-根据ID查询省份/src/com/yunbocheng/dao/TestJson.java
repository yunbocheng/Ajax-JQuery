package com.yunbocheng.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunbocheng.entity.Province;

/**
 * 以下代码是展示一下 jackson的用法，与本项目无关
 */
public class TestJson {
    public static void main(String[] args) throws JsonProcessingException {
        // 使用jackson 把Java对象转换为json格式的字符串
        Province province  = new Province();
        province.setId(1);
        province.setName("河北");
        province.setJiancheng("冀");
        province.setShenghui("石家庄市");

        // 使用jackson转换为json
        ObjectMapper om = new ObjectMapper();
        // writeValueAsString：把参数的Java对象转化为json格式的字符串
        String value = om.writeValueAsString(province);
        System.out.println("转换的json==" + value);
        // 转换的json=={"id":1,"name":"河北","jiancheng":"冀","shenghui":"石家庄市"}
    }
}
