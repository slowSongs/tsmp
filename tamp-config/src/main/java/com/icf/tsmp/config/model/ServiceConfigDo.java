package com.icf.tsmp.config.model;

import com.icf.tsmp.config.repository.ServiceConfigMapper;

import java.util.List;

/**
 * @auhther Arvin
 * @date 2020/7/2 17:59
 * @description:
 */
public class ServiceConfigDo  {
    private Long id;
    private String jydm;
    private String xtbh;
    private String fwmc;
    private String fwlm;
    private String fwffm;
    private String sfky;
    private String fwxy;

    private List<ParamConfigDo> params;

    public String getFwxy() {
        return fwxy;
    }

    public void setFwxy(String fwxy) {
        this.fwxy = fwxy;
    }

    private String fwms;

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

    public String getXtbh() {
        return xtbh;
    }

    public void setXtbh(String xtbh) {
        this.xtbh = xtbh;
    }

    public String getFwmc() {
        return fwmc;
    }

    public void setFwmc(String fwmc) {
        this.fwmc = fwmc;
    }

    public String getFwlm() {
        return fwlm;
    }

    public void setFwlm(String fwlm) {
        this.fwlm = fwlm;
    }

    public String getFwffm() {
        return fwffm;
    }

    public void setFwffm(String fwffm) {
        this.fwffm = fwffm;
    }

    public String getSfky() {
        return sfky;
    }

    public void setSfky(String sfky) {
        this.sfky = sfky;
    }

    public String getFwms() {
        return fwms;
    }

    public void setFwms(String fwms) {
        this.fwms = fwms;
    }

    public List<ParamConfigDo> getParams() {
        return params;
    }

    public void setParams(List<ParamConfigDo> params) {
        this.params = params;
    }
}
