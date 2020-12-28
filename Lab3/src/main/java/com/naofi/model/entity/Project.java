package com.naofi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Class representing entry of 'projects' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "projects")
public class Project {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "manager")
    private Manager manager;
    @ManyToMany
    private List<Technology> technologies;
}
