package com.icf.tsmp.common.model;

/**
 * @auhther Arvin
 * @date 2020/7/2 10:51
 * @description:
 */
public class BaseMsg extends CommonBean {
    @NotNull(filedName = "jylsh")
    private String jylsh;

    @NotNull(filedName = "jyxtbh")
    private String jyxtbh;
    @NotNull(filedName = "jysjc")
    private long jysjc;
    @NotNull(filedName = "jydm")
    private String jydm;
    private String dpbh;
    private String jgbh;
    private String ygbh;
    private String zdbh;
    private String qdbh;
    private String hzqdbh;

    public String getJylsh() {
        return jylsh;
    }

    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }

    public String getJyxtbh() {
        return jyxtbh;
    }

    public void setJyxtbh(String jyxtbh) {
        this.jyxtbh = jyxtbh;
    }

    public long getJysjc() {
        return jysjc;
    }

    public void setJysjc(long jysjc) {
        this.jysjc = jysjc;
    }

    public String getJydm() {
        return jydm;
    }

    public void setJydm(String jydm) {
        this.jydm = jydm;
    }

    public String getDpbh() {
        return dpbh;
    }

    public void setDpbh(String dpbh) {
        this.dpbh = dpbh;
    }

    public String getJgbh() {
        return jgbh;
    }

    public void setJgbh(String jgbh) {
        this.jgbh = jgbh;
    }

    public String getYgbh() {
        return ygbh;
    }

    public void setYgbh(String ygbh) {
        this.ygbh = ygbh;
    }

    public String getZdbh() {
        return zdbh;
    }

    public void setZdbh(String zdbh) {
        this.zdbh = zdbh;
    }

    public String getQdbh() {
        return qdbh;
    }

    public void setQdbh(String qdbh) {
        this.qdbh = qdbh;
    }

    public String getHzqdbh() {
        return hzqdbh;
    }

    public void setHzqdbh(String hzqdbh) {
        this.hzqdbh = hzqdbh;
    }
}
