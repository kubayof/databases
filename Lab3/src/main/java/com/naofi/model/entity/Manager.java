package com.naofi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Class representing entry of 'managers' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "managers")
public class Manager {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private List<Programmer> programmers;
    @OneToOne(mappedBy = "manager")
    @ToString.Exclude
    @JsonIgnore
    private Project project;
}
