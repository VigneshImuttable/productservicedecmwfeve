package com.project.productservicedecmwfeve.inheritanceExamples.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="1")
public class Instructor extends User {

    private String favouriteStudent;
}
