package com.icf.tsmp.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @auhther Arvin
 * @date 2020/7/2 10:16
 * @description:
 */
public class AppException  extends Exception{
    protected String errorcode = null;
    private String message = null;
    private Throwable ex = null;
    private String random = null;
    private String siteNo = null;
    private String appName = null;
    private String serverNo = null;

    public AppException(String errorcode, String defaultMsg) {
        this(errorcode, defaultMsg, null);
    }

    public AppException(String errorcode, String defaultMsg, Throwable ex) {
        this.errorcode = errorcode;
        this.message = defaultMsg;
        this.ex = ex;
        this.random = generateCode();
    }

    public String getErrorcode() {
        return errorcode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String buildException(Throwable e) {
        java.io.StringWriter errormsg = new java.io.StringWriter();
        java.io.PrintWriter errorprint = new PrintWriter(errormsg);
        e.printStackTrace(errorprint);
        String errStack = errormsg.toString();
        errorprint.close();
        try {
            errormsg.close();
        } catch (IOException e1) {
            
        }
        return errStack;
    }
    
    public static String generateExceptionCode(String name) {
        return name + "(" + System.currentTimeMillis() + ")";
    }

    public static String generateCode() {
        String[] beforeShuffle = new String[]{"1", "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        return afterShuffle.substring(5, 9);
    }
}
