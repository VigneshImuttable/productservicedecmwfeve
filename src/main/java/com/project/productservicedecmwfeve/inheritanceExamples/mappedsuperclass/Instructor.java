package com.project.productservicedecmwfeve.inheritanceExamples.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "ms_Instructor")
public class Instructor extends User {

    @Id
    private long id;
    private String favouriteStudent;
}
