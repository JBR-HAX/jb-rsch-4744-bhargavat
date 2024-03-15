package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movement {
    private Direction direction;
    private Integer steps;
}
