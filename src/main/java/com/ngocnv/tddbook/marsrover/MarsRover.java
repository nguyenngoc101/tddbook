package com.ngocnv.tddbook.marsrover;

import static com.ngocnv.tddbook.marsrover.Direction.NORTH;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {

  private Grid grid;
  protected Point currentPoint;
  private CommandFactory commanFactory;

  public MarsRover(Grid grid) {
    this.grid = grid;
    currentPoint = new Point(0, 0, NORTH);
    commanFactory = new CommandFactory();
  }

  public String execute(String command) {
    char[] commandChars = command.toCharArray();
    List<ICommand> commands = getCommands(commandChars);
    boolean hasObstacle = false;
    Point previousPoint = currentPoint;
    Point nextPoint;
    for (ICommand icommand: commands) {
      nextPoint = icommand.execute();
      if (nextPoint.equals(previousPoint)) {
        hasObstacle = true;
        break;
      } else {
        previousPoint = nextPoint;
      }
    }
    return hasObstacle ? "O:" + currentPoint.getCurrentPosition() : currentPoint.getCurrentPosition();
  }

  private List<ICommand> getCommands(char[] commandChars) {
    List<ICommand> commands = new ArrayList();
    for (char com : commandChars) {
      commands.add(commanFactory.create(com, this));
    }
    return commands;
  }

  public void turnRight() {
    currentPoint = currentPoint.turnRight();
  }

  public void turnLeft() {
    currentPoint = currentPoint.turnLeft();
  }

  public void moveStraight() {
    Point head = currentPoint.moveStraight();
    if (grid.outOfGrid(head)) {
      currentPoint = Point.START_POINT;
    } else if (!grid.isObstacle(head)) {
      currentPoint = head;
    }
  }
}
