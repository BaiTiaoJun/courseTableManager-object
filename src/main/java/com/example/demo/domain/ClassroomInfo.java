package com.example.demo.domain;

public class ClassroomInfo {
    private String classroomNo;
    private String isMulClassroom;
    private String capacity;
    private String status;

    public ClassroomInfo(String classroomNo, String isMulClassroom, String capacity, String status) {
        this.classroomNo = classroomNo;
        this.isMulClassroom = isMulClassroom;
        this.capacity = capacity;
        this.status = status;
    }

    public ClassroomInfo() {
    }

    public String getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(String classroomNo) {
        this.classroomNo = classroomNo;
    }

    public String getIsMulClassroom() {
        return isMulClassroom;
    }

    public void setIsMulClassroom(String isMulClassroom) {
        this.isMulClassroom = isMulClassroom;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassBaseInfo{" +
                "classNo='" + classroomNo + '\'' +
                ", isMulClassroom=" + isMulClassroom +
                ", capacity='" + capacity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
