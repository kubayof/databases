package com.naofi.model.entity;

import lombok.*;

/**
 * Class representing entry of 'technologies' table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Technology {
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
}
