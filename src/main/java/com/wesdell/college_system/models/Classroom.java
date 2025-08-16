package com.wesdell.college_system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "classrooms")
public class Classroom {

    @Id
    @SequenceGenerator(name = "classroom_sequence", sequenceName = "classroom_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classroom_sequence")
    private Long id;

    @NotBlank(message = "Room number is required")
    @Size(min = 3, max = 10, message = "Room number must be between 3 and 10 characters")
    @Column(nullable = false)
    private String roomNumber;

    @NotBlank(message = "Classroom location is required")
    @Size(min = 3, max = 100, message = "Classroom location must be between 3 and 100 characters")
    @Column(nullable = false)
    private String location;

    @Min(value = 0, message = "Capacity must be at least 0")
    @Max(value = 40, message = "Capacity cannot exceed 40")
    private int capacity;

    @ManyToMany(mappedBy = "classrooms")
    private Set<Course> courses = new HashSet<>();

}
