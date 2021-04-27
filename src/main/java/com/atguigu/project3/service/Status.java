package com.atguigu.project3.service;

/**
 * Status class
 * 枚举类的普通写法 员工状态
 * @author jiazhikai
 * @date 2021/4/26
 */
public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME=name;    }
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
