package com.ngocnv.tddbook.marsrover;

public class CommandFactory {

  public ICommand create(char com, MarsRover marsRover) {
      switch (com) {
        case 'M':
          return new MoveCommand(marsRover);
        case 'L':
          return new LeftCommand(marsRover);
        case 'R':
          return new RightCommand(marsRover);
        default:
          return new NothingCommand(marsRover);
      }
  }
}
