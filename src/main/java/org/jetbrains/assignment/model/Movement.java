package org.jetbrains.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movement {
    private Direction direction;
    private Integer steps;
}
