package com.eqa.eqastudyplanservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "study_plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "active=true")
@EntityListeners(AuditingEntityListener.class)
public class StudyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "section_number")
    private Integer sectionNumber;

    private String url;

    @Column(name = "no_of_days")
    private Integer noOfDays;

    private String semester;
    private Integer year;

    @Column(name = "college_id")
    private String collegeId;

    @Column(name = "campus_id")
    private String campusId;

    @Column(name = "department_id")
    private String departmentId;

    private boolean active;

    @Column(name = "clos_count")
    private int closCount;

    @Column(name = "student_count")
    private int studentCount;

    @Column(name = "conducted_survey_count")
    private int conductedSurveyCount;

    @CreatedDate
    private LocalDateTime creationDateTime;

    @LastModifiedDate
    private LocalDateTime updatedDateTime;

    private String createdBy;
    private String updatedBy;

}
