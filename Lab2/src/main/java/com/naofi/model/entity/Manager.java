package com.naofi.model.entity;

import lombok.*;

/**
 * Class representing entry of 'managers' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Manager {
    @EqualsAndHashCode.Include
    private Integer id;
    private String firstName;
    private String lastName;
}
