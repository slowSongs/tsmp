package com.icf.tsmp.common.model.response;

import com.icf.tsmp.common.model.BaseMsg;
import com.icf.tsmp.common.model.CommonBean;

/**
 * @auhther Arvin
 * @date 2020/7/2 15:20
 * @description:
 */
public class ResponseMsg<T> extends CommonBean {

    /**
     * 基础响应数据
     */
    private BaseMsg jcxysj;

    /**
     * 返回码
     */
    private String fhm;

    /**
     * 返回描述信息
     */
    private String fhmsxx;
    /**
     * 业务响应数据
     */
    private T ywxysj;

    public BaseMsg getJcxysj() {
        return jcxysj;
    }

    public void setJcxysj(BaseMsg jcxysj) {
        this.jcxysj = jcxysj;
    }

    public String getFhm() {
        return fhm;
    }

    public void setFhm(String fhm) {
        this.fhm = fhm;
    }

    public String getFhmsxx() {
        return fhmsxx;
    }

    public void setFhmsxx(String fhmsxx) {
        this.fhmsxx = fhmsxx;
    }

    public T getYwxysj() {
        return ywxysj;
    }

    public void setYwxysj(T ywxysj) {
        this.ywxysj = ywxysj;
    }
}
