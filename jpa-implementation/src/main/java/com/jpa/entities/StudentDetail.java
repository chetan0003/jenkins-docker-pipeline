package com.jpa.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetail {
    @Id
    private Long id;
    private String name;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<CourseDetail> getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(Set<CourseDetail> courseDetail) {
        this.courseDetail = courseDetail;
    }

    @OneToMany(mappedBy = "studentDetail")
    private Set<CourseDetail> courseDetail;

}
