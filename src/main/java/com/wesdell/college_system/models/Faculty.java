package com.wesdell.college_system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @NotBlank(message = "Faculty name is required")
    @Size(min = 3, max = 100, message = "Faculty name must be between 3 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Faculty description is required")
    @Size(min = 3, max = 100, message = "Faculty description must be between 3 and 100 characters")
    @Column(nullable = false)
    private String description;

    @NotBlank(message = "Faculty location is required")
    @Size(min = 3, max = 100, message = "Faculty location must be between 3 and 100 characters")
    @Column(nullable = false)
    private String location;

    @NotBlank(message = "Dean name is required")
    @Size(min = 3, max = 100, message = "Dean name must be between 3 and 100 characters")
    @Column(nullable = false)
    private String dean;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Career> careers = new HashSet<>();

}
