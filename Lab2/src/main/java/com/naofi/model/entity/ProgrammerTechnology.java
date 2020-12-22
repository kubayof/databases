package com.naofi.model.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProgrammerTechnology {
    private Integer programmerId;
    private Integer technologyId;
}
