package com.icf.tsmp.client.exception;

/**
 * @auhther Arvin
 * @date 2020/7/2 19:49
 * @description:
 */
public enum  BizCode {
    SUCCESS("000000","执行成功"),
    RPC_INVOKE_ERR("082200","RPC远程调用失败"),
    SERVICE_CONFIG_NULL_ERR("082201","服务配置信息为空"),
    PARAM_ERROR("082100","参数错误"),
    SYSTEM_ERR("082999", "系统错误");

    BizCode(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    private final String errorCode;
    private final String errorDesc;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public static String getMessage(String errorCode) {
        if (null == errorCode) {
            return null;
        }
        for (BizCode bizErrorCode : BizCode.values()) {
            if (errorCode.equals(bizErrorCode.getErrorCode())) {
                return bizErrorCode.getErrorDesc();
            }

        }
        return null;
    }
}
