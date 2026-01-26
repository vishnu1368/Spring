package com.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table("Table_nm") -> If you have different table in postgres DB, then you can specify it here
public class Student {
    @Id
    //@Column("Column_nm") -> If you have different column name in postgres DB that maps to this field, then you can specify it here
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
