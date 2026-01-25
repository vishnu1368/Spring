package com.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    public int sid;
    public String sname;
    public String favCourse;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFavCourse() {
        return favCourse;
    }

    public void setFavCourse(String favCourse) {
        this.favCourse = favCourse;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", favCourse='" + favCourse + '\'' +
                '}';
    }

}
