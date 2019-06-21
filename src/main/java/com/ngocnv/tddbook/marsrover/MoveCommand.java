package com.ngocnv.tddbook.marsrover;

public class MoveCommand implements ICommand {

  private MarsRover marsRover;

  public MoveCommand(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  @Override
  public Point execute() {
    marsRover.moveStraight();
    return marsRover.currentPoint;
  }
}
