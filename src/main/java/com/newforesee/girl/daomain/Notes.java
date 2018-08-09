package com.newforesee.girl.daomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by newforesee on 2018/8/8.
 */
@Entity
public class Notes {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "所属用户id必填")
    private Integer userid;

    @Column(columnDefinition = "INT default 0")
    private Integer status;

    @NotNull(message = "标题不能为空")
    private String title;

    @Column(columnDefinition = "TEXT")
    @NotNull(message = "请填写内容")
    private String context;


    public Notes() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", userid=" + userid +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
