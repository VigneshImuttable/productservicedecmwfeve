package com.project.productservicedecmwfeve.inheritanceExamples.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_mentor")
public class Mentor extends User {
    private double averageRating;
}
