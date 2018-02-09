package com.example.icourse.entity.bean;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="course_info")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;

    private String courseName;


    private Integer examDifficulty;

    private Integer courseLoad;

    private Integer practicability;

    private Integer enjoyment;


    @ManyToOne (cascade = CascadeType.ALL)
    private Teacher teacherInfo;

    @OneToMany (mappedBy = "courseInfo")
    private Set<Remark> remarkSet;

    public Course(){

    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getExamDifficulty() {
        return examDifficulty;
    }

    public void setExamDifficulty(Integer examDifficulty) {
        this.examDifficulty = examDifficulty;
    }

    public Integer getCourseLoad() {
        return courseLoad;
    }

    public void setCourseLoad(Integer courseLoad) {
        this.courseLoad = courseLoad;
    }

    public Integer getPracticability() {
        return practicability;
    }

    public void setPracticability(Integer practicability) {
        this.practicability = practicability;
    }

    public Integer getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(Integer enjoyment) {
        this.enjoyment = enjoyment;
    }

    public Teacher getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(Teacher teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

   /* public Set<Remark> getRemarkSet() {
        return remarkSet;
    }

    public void setRemarkSet(Set<Remark> remarkSet) {
        this.remarkSet = remarkSet;
    }*/
}
