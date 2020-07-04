package com.icf.tsmp.common.model;

/**
 * @auhther Arvin
 * @date 2020/7/2 15:24
 * @description:
 */
public class BaseResult extends CommonBean {
    //返回码
    protected String fhm = "0000000";
    //返回描述信息
    protected String fhmsxx;

    public BaseResult(String fhm, String fhmsxx) {
        this.fhm = fhm;
        this.fhmsxx = fhmsxx;
    }

    public BaseResult() {
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
}
