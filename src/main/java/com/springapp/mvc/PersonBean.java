package com.springapp.mvc;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import sun.management.resources.agent;

/**
 * Created by hp21 on 2014.01.19..
 */
@ManagedBean
public class PersonBean {

    private int age;
    private String name;
    private Date dob;

    public PersonBean() {
        age = 17;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String rename() {
        setAge(getAge() + 2);
        setName("MR " + getName());
        return "hello";
    }

    @Override
    public String toString() {
        return "JsfBean{" + "age=" + age + ", name='" + name + '\'' + ", dob=" + dob + '}';
    }
}
