package com.example.demo.domain;

public class CourseBaseInfo {
    private String courseNo;
    private String cname;
    private String term;
    private String period;
    private String credit;

    public CourseBaseInfo() {
    }

    public CourseBaseInfo(String courseNo, String cname, String term, String period, String credit) {
        this.courseNo = courseNo;
        this.cname = cname;
        this.term = term;
        this.period = period;
        this.credit = credit;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "CourseBaseInfo{" +
                "courseNo='" + courseNo + '\'' +
                ", cname='" + cname + '\'' +
                ", term='" + term + '\'' +
                ", period='" + period + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
