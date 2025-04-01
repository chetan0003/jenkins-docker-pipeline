package com.jpa.entities;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetail {

    @Id
    private Long id;
    @Column(name = "course_name")
    private String courseName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    @Column(name = "course_credit")
    private String courseCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    private StudentDetail studentDetail;
}
