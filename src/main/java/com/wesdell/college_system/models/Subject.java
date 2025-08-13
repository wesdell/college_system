package com.wesdell.college_system.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "subjects")
public class Subject {

    @Id
    @SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    private Long id;

    @NotBlank
    private String description;

    @NotBlank
    private String name;

    @NotNull
    @Max(6)
    private int credits;

    @NotNull
    @Column(unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    @JsonBackReference
    private Faculty faculty;
}
