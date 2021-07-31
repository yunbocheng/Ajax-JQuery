package com.yunbocheng.entity;

public class city {
    /*城市主键*/
    private Integer id;
    /*城市名称*/
    private  String name;
    /*城市所属的省份*/
    private Integer province;

    public city() {
    }

    public city(Integer id, String name, Integer province) {
        this.id = id;
        this.name = name;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "city{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province=" + province +
                '}';
    }
}
