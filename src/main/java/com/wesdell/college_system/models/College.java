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
@Table(name = "colleges")
public class College {

    @Id
    @SequenceGenerator(name = "college_sequence", sequenceName = "college_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "college_sequence")
    private Long id;

    @NotBlank(message = "College name is required")
    @Size(min = 3, max = 100, message = "College name must be between 3 and 100 characters")
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank(message = "College description is required")
    @Size(min = 3, max = 100, message = "College description must be between 3 and 100 characters")
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Faculty> faculties = new HashSet<>();
}
