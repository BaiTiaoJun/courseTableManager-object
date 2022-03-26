package com.example.demo.domain;

public class ClassBaseInfo {
    private String classNo;
    private String dept;
    private String classNum;
    private String enYear;
    private String instructor;

    public ClassBaseInfo(String classNo, String dept, String classNum, String enYear, String instructor) {
        this.classNo = classNo;
        this.dept = dept;
        this.classNum = classNum;
        this.enYear = enYear;
        this.instructor = instructor;
    }

    public ClassBaseInfo() {
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getEnYear() {
        return enYear;
    }

    public void setEnYear(String enYear) {
        this.enYear = enYear;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "ClassBaseInfo{" +
                "classNo='" + classNo + '\'' +
                ", dept='" + dept + '\'' +
                ", classNum='" + classNum + '\'' +
                ", enYear='" + enYear + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}