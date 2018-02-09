package com.example.icourse.entity.bean;


import javax.persistence.*;

@Entity
@Table(name = "remark_info")
public class Remark {

    @Id
    @GeneratedValue
    private Integer remarkId;

    private String Content;

    private Integer examDifficulty;

    private Integer courseLoad;

    private Integer practicability;

    private Integer enjoyment;

    private Integer teacherScore;


    @ManyToOne (cascade = CascadeType.ALL)
    private User  userInfo;

    @ManyToOne (cascade = CascadeType.ALL)
    private Course courseInfo;


    public Remark(){

    }


    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
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

    public Integer getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(Integer teacherScore) {
        this.teacherScore = teacherScore;
    }

   public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public Course getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(Course courseInfo) {
        this.courseInfo = courseInfo;
    }
}
