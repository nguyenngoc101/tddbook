package com.ngocnv.tddbook.marsrover;

public class NothingCommand implements ICommand {

  private MarsRover marsRover;

  public NothingCommand(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  @Override
  public Point execute() {
    return marsRover.currentPoint;
  }
}
