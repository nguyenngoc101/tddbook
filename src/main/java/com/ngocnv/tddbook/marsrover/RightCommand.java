package com.ngocnv.tddbook.marsrover;

public class RightCommand implements ICommand {

  private MarsRover marsRover;

  public RightCommand(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  @Override
  public Point execute() {
    marsRover.turnRight();
    return marsRover.currentPoint;
  }
}
