package com.icf.tsmp.config.exception;

/**
 * @auhther Arvin
 * @date 2020/7/2 17:43
 * @description:
 */
public enum  TsmpCode {

    SUCCESS("000000", "执行成功"),
    SYSTEM_ERR("081999", "系统错误");

    TsmpCode(String errorCode, String errorDesc) {
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
        for (TsmpCode bizErrorCode : TsmpCode.values()) {
            if (errorCode.equals(bizErrorCode.getErrorCode())) {
                return bizErrorCode.getErrorDesc();
            }
        }
        return null;
    }
}
