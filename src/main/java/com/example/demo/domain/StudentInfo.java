package com.example.demo.domain;

public class StudentInfo {
    private String no;
    private String name;
    private String sex;
    private String birthdate;
    private String dept;
    private String sclass;
    private String address;
    private String contact;

    public StudentInfo(String no, String name, String sex, String birthdate, String dept, String sclass, String address, String contact) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.birthdate = birthdate;
        this.dept = dept;
        this.sclass = sclass;
        this.address = address;
        this.contact = contact;
    }

    public StudentInfo() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthdate='" + birthdate + '\'' +
                ", dept='" + dept + '\'' +
                ", sclass='" + sclass + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
