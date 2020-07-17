package com.xsx.computermall.bean;

import org.springframework.context.annotation.Bean;

import java.util.Objects;

/**
 * @author xsx
 */
public class AdminInfo {
    private Integer aid;
    private String aname;
    private String pwd;
    private String tel;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
