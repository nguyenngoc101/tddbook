package com.ngocnv.tddbook.marsrover;

public class LeftCommand implements ICommand {

  private MarsRover marsRover;

  public LeftCommand(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  @Override
  public Point execute() {
    marsRover.turnLeft();
    return marsRover.currentPoint;
  }
}
