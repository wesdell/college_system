package com.wesdell.college_system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "careers")
public class Career {

    @Id
    @SequenceGenerator(name = "career_sequence", sequenceName = "career_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "career_sequence")
    private Long id;

    @NotBlank(message = "Career name is required")
    @Size(min = 3, max = 100, message = "Career name must be between 3 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Career description is required")
    @Size(min = 3, max = 100, message = "Career description must be between 3 and 100 characters")
    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @OneToMany(mappedBy = "career", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subject> subjects;

}
