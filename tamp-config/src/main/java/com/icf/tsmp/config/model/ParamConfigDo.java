package com.icf.tsmp.config.model;

/**
 * @auhther Arvin
 * @date 2020/7/2 17:56
 * @description:
 */
public class ParamConfigDo {
    //自增主键
    private Long id;
    //交易代码
    private String jydm;
    //参数名称
    private String csmc;
    //参数类型
    private String cslx;
//扩展属性
    private String kzsx;
    //参数编号
    private String csbh;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJydm() {
        return jydm;
    }

    public void setJydm(String jydm) {
        this.jydm = jydm;
    }

    public String getCsmc() {
        return csmc;
    }

    public void setCsmc(String csmc) {
        this.csmc = csmc;
    }

    public String getCslx() {
        return cslx;
    }

    public void setCslx(String cslx) {
        this.cslx = cslx;
    }

    public String getKzsx() {
        return kzsx;
    }

    public void setKzsx(String kzsx) {
        this.kzsx = kzsx;
    }

    public String getCsbh() {
        return csbh;
    }

    public void setCsbh(String csbh) {
        this.csbh = csbh;
    }


}
