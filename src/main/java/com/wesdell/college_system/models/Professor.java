package com.wesdell.college_system.models;

import com.wesdell.college_system.interfaces.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "professors")
public class Professor {

    @Id
    @SequenceGenerator(name = "professor_sequence", sequenceName = "professor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_sequence")
    private Long id;

    @NotBlank(message = "Professor name is required")
    @Size(min = 3, max = 100, message = "Professor name must be between 3 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Professor lastname is required")
    @Size(min = 3, max = 100, message = "Professor lastname must be between 3 and 100 characters")
    @Column(nullable = false)
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String institutionalEmail;

    @NotNull(message = "Birthday is required")
    @Past(message = "Invalid birthday")
    private LocalDate birthday;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Course> courses = new HashSet<>();

}
