package com.naofi.model.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProjectTechnology {
    private Integer projectId;
    private Integer technologyId;
}
