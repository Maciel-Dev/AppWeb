package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mentorings")
@Getter
@Setter
public class Mentoring extends Publication {
    private String grade;
    private Integer duration;

    public Mentoring(String title, String description, String grade, Integer duration) {
        super(title, description);
        this.grade = grade;
        this.duration = duration;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
