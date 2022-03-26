package com.example.demo.domain;

public class CourseTableInfo {
    private String id;
    private String courseNo;
    private String cclass;
    private String teacherNo;
    private String time;
    private String site;

    public CourseTableInfo(String id, String courseNo, String cclass, String teacherNo, String time, String site) {
        this.id = id;
        this.courseNo = courseNo;
        this.cclass = cclass;
        this.teacherNo = teacherNo;
        this.time = time;
        this.site = site;
    }

    public CourseTableInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCclass() {
        return cclass;
    }

    public void setCclass(String cclass) {
        this.cclass = cclass;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "CourseTableInfo{" +
                "id='" + id + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", cclass='" + cclass + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", time='" + time + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
