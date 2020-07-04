package com.icf.tsmp.model.response;

import com.icf.tsmp.common.model.CommonBean;

/**
 * @auhther Arvin
 * @date 2020/7/2 15:58
 * @description:
 */
public class ParamConfigResp extends CommonBean {
    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 参数类型
     */
    private String paramType;
    /**
     * 复合类型json配置参数
     */
    private String complexConfig;
    /**
     * 参数编号
     */
    private String paramNo;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getComplexConfig() {
        return complexConfig;
    }

    public void setComplexConfig(String complexConfig) {
        this.complexConfig = complexConfig;
    }

    public String getParamNo() {
        return paramNo;
    }

    public void setParamNo(String paramNo) {
        this.paramNo = paramNo;
    }
}
