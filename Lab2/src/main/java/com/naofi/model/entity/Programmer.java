package com.naofi.model.entity;

import lombok.*;

/**
 * Class representing entry of 'programmers' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Programmer {
    @EqualsAndHashCode.Include
    private Integer id;
    private String firstName;
    private String lastName;
    private int managerId;
}
