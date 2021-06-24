package com.example.restrauntInfo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restraunt")
public class Restraunt implements Serializable {
    private static final long serialVersionUID = 432414053432649039L;

    @Id
    private int restrauntId;

    private String name;

    private String city;

    private String tel;

    public int getRestrauntId() {
        return restrauntId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getTel() {
        return tel;
    }

    public void setRestrauntId(int restrauntId) {
        this.restrauntId = restrauntId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
