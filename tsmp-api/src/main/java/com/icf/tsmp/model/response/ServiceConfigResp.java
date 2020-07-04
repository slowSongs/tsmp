package com.icf.tsmp.model.response;

import com.icf.tsmp.common.model.CommonBean;

import java.util.List;

/**
 * @auhther Arvin
 * @date 2020/7/2 16:01
 * @description:
 */
public class ServiceConfigResp extends CommonBean {
    private String tranCode;
    private String appId;
    private String serverName;
    private String className;
    private String methodName;
    private String potocol;
    private String desc;

    private List<ParamConfigResp> paramConfigList;

    public List<ParamConfigResp> getParamConfigList() {
        return paramConfigList;
    }

    public void setParamConfigList(List<ParamConfigResp> paramConfigList) {
        this.paramConfigList = paramConfigList;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getPotocol() {
        return potocol;
    }

    public void setPotocol(String potocol) {
        this.potocol = potocol;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
