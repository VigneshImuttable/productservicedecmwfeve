package com.project.productservicedecmwfeve.inheritanceExamples.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="2")
public class Mentor extends User {
    private double averageRating;
}
