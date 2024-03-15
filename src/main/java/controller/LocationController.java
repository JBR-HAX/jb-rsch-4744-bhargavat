package controller;

import model.Coordinate;
import model.Direction;
import model.Movement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Receives a list of movement operations in JSON format as an input
 * and outputs the coordinates recorded after each move as a JSON document.
 * Assume that the initial location for the robot is always at (0, 0).
 */
@RestController
public class LocationController {

    @PostMapping(path = "/locations")
    public List<Coordinate> getLocations(@RequestBody List<Movement> moves) {
        Coordinate currCoordinate = new Coordinate(0,0);
        List<Coordinate> result = new ArrayList<>();
        result.add(currCoordinate);
        for (Movement move: moves) {
            Coordinate next = null;
            int steps = move.getSteps();
            switch (move.getDirection()) {
                case EAST:
                    next = new Coordinate(currCoordinate.getX() + steps,
                            currCoordinate.getY());
                    break;
                case WEST:
                    next = new Coordinate(currCoordinate.getX() - steps,
                            currCoordinate.getY());
                    break;
                case NORTH:
                    next = new Coordinate(currCoordinate.getX(),
                            currCoordinate.getY() + steps);
                    break;
                case SOUTH:
                    next = new Coordinate(currCoordinate.getX(),
                            currCoordinate.getY() - steps);
                default:
                    break;
            }
            if (next != null) {
                currCoordinate = next;
                result.add(next);
            }
        }

        return result;
    }

    @PostMapping(path = "/moves")
    public List<Movement> getMoves(@RequestBody List<Coordinate> coordinates) {
        List<Movement> moves = new ArrayList<>();
        Coordinate currCoord = new Coordinate(0,0);
        for (Coordinate coord : coordinates) {
            Movement move = new Movement();
            Direction dir = null;
            int deltaX = currCoord.getX() + coord.getX();
            int deltaY = currCoord.getY() + coord.getY();

            if (deltaX > currCoord.getX()) {
                dir = Direction.EAST;
                move.setSteps(Math.abs(deltaX));
            } else if (deltaX < currCoord.getX()) {
                dir = Direction.WEST;
                move.setSteps(Math.abs(deltaX));
            } else if (deltaY > currCoord.getY()) {
                dir = Direction.NORTH;
                move.setSteps(Math.abs(deltaY));
            } else if (deltaY < currCoord.getY()) {
                dir = Direction.SOUTH;
                move.setSteps(Math.abs(deltaY));
            }
            move.setDirection(dir);

            moves.add(move);
        }

        return moves;
    }
}
