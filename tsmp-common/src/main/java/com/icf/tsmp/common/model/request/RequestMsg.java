package com.icf.tsmp.common.model.request;

import com.icf.tsmp.common.model.BaseMsg;
import com.icf.tsmp.common.model.CommonBean;

/**
 * @auhther Arvin
 * @date 2020/7/2 10:37
 * @description:
 */
public class RequestMsg<T> extends CommonBean {
    /**
     * 基础请求数据
     */
    private BaseMsg jcqqsj;

    /**
     * 业务请求数据
     */
    private T ywqqsj;

    public BaseMsg getJcqqsj() {
        return jcqqsj;
    }

    public void setJcqqsj(BaseMsg jcqqsj) {
        this.jcqqsj = jcqqsj;
    }

    public T getYwqqsj() {
        return ywqqsj;
    }

    public void setYwqqsj(T ywqqsj) {
        this.ywqqsj = ywqqsj;
    }
}
