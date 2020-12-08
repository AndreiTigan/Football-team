package com.example.demo.entityDao;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "LESSONS")
public class Lesson {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "lesson_sequence_generator")
    @SequenceGenerator(name = "lesson_sequence_generator", sequenceName = "LESSONS_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "DURATION")
    private double duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    @OneToOne(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @ManyToMany
    @JoinColumn(
            name = "LESSONS_ASSOCIATION",
            joinColumns = @JoinColumn(name = "LESSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "LESSON_CONTENT_ID"))
    private List<Lesson_Content> lessonContents;

    public Lesson(Long id, String name, String content, double duration) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.duration = duration;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
