package com.naofi.model.entity;

import lombok.*;

/**
 * Class representing entry of 'projects' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Project {
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
    private Integer managerId;
}
