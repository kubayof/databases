package com.naofi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Class representing entry of 'technologies' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "technologies")
public class Technology {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<Project> projects;
    @ManyToMany
    private List<Programmer> programmers;
}
