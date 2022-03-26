package com.example.demo.domain;

public class TeacherInfo {
    private String no;
    private String name;
    private String dept;
    private String major;
    private String positionalTitle;

    public TeacherInfo(String no, String name, String dept, String major, String positionalTitle) {
        this.no = no;
        this.name = name;
        this.dept = dept;
        this.major = major;
        this.positionalTitle = positionalTitle;
    }

    public TeacherInfo() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPositionalTitle() {
        return positionalTitle;
    }

    public void setPositionalTitle(String positionalTitle) {
        this.positionalTitle = positionalTitle;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", major='" + major + '\'' +
                ", position='" + positionalTitle + '\'' +
                '}';
    }
}
