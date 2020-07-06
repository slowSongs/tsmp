package com.icf.tsmp.common.check;

/**
 * @auhther Arvin
 * @date 2020/7/6 10:58
 * @description: 初始化
 */
public abstract class InspectionChecker {
    //选择器
    public abstract boolean check(Object value);

    public abstract String[] supports();
}
