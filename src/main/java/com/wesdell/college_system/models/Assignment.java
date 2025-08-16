package com.wesdell.college_system.models;

import com.wesdell.college_system.interfaces.AssignmentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "assignments")
public class Assignment {

    @Id
    @SequenceGenerator(name = "assignment_sequence", sequenceName = "assignment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignment_sequence")
    private Long id;

    @NotBlank(message = "Assignment description is required")
    @Size(min = 3, max = 100, message = "Assignment description must be between 3 and 100 characters")
    @Column(nullable = false)
    private String description;

    @Min(value = 5, message = "Weight must be at least 5")
    @Max(value = 35, message = "Weight cannot exceed 35")
    private int weight;

    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private AssignmentType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grades = new HashSet<>();

}
