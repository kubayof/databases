package com.naofi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Class representing entry of 'programmers' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "programmers")
public class Programmer {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "manager")
    private Manager manager;
    @ManyToMany
    private List<Technology> technologies;
}
