package com.wesdell.college_system.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "faculties")
public class Faculty {

    @Id
    @SequenceGenerator(name = "faculty_sequence", sequenceName = "faculty_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_sequence")
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank
    private String dean;

    private String description;
    private String location;

    @JsonManagedReference
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

}
