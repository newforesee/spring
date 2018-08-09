package com.newforesee.girl.daomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by newforesee on 2018/8/8.
 */
@Entity
public class Notes {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer userid;

    private Integer status;

    @Column
    private String context;


    public Notes() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getContext() {
        return context;
    }


    public void setContext(String context) {
        this.context = context;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
