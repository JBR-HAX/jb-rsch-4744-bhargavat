package org.jetbrains.assignment.controller;

import org.jetbrains.assignment.Application;
import org.jetbrains.assignment.model.Coordinate;
import org.jetbrains.assignment.model.Direction;
import org.jetbrains.assignment.model.Movement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.openMocks;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
class LocationControllerTest {

    private LocationController controller;
    @BeforeEach
    public void setUp() throws Exception {
        openMocks(this);
        controller = new LocationController();
    }

    @Test
    void getLocations() {
        List<Movement> coordinates = Arrays.asList(
        new Movement(Direction.EAST, 1),
        new Movement(Direction.NORTH, 3),
        new Movement(Direction.EAST, 3));

        List<Coordinate> expectedResult = Arrays.asList(
                new Coordinate(0,0),
                new Coordinate(1,0),
                new Coordinate(1,3),
                new Coordinate(4,3)
        );

        assertThat(controller.getLocations(coordinates)).isEqualTo(expectedResult);
    }

    @Test
    void getMoves() {
    }
}