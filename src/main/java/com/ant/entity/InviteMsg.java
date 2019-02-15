package com.ant.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Ant
 * @Date: 2019/02/15 10:07
 * @Description:
 */
public class InviteMsg implements Serializable {
    private int invite_id;
    private String from;
    private String from_name;
    private String owner;
    private String owner_name;
    private int book_id;
    private String book_name;
    private int status;
    private Date createtime;

    public int getInvite_id() {
        return invite_id;
    }

    public void setInvite_id(int invite_id) {
        this.invite_id = invite_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getCreatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(createtime);
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
