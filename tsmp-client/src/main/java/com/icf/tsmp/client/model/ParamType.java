package com.icf.tsmp.client.model;

/**
 * @auhther Arvin
 * @date 2020/7/2 19:46
 * @description:
 */
public enum  ParamType {
    META(1, "基础元素"),

    OBJECT(2, "对象元素"),
    ;

    private final int type;

    private final String desc;

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    ParamType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
