package com.ngocnv.tddbook.marsrover;


import static com.ngocnv.tddbook.marsrover.Direction.EAST;
import static com.ngocnv.tddbook.marsrover.Direction.NORTH;
import static com.ngocnv.tddbook.marsrover.Direction.SOUTH;
import static com.ngocnv.tddbook.marsrover.Direction.WEST;

public class Point {
  int x;
  int y;
  Direction direction;

  public static final Point START_POINT = new Point(0, 0, NORTH);

  public Point(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public String getCurrentPosition() {
    return x + ":" + y + ":" + direction.getName();
  }

  public Point moveStraight() {
    switch (direction) {
      case NORTH:
        return new Point(x, y + 1, NORTH);
      case SOUTH:
        return new Point(x, y - 1, SOUTH);
      case EAST:
        return new Point(x + 1, y, EAST);
      case WEST:
        return new Point(x - 1, y, WEST);
      default:
        return START_POINT;
    }
  }

  public Point turnLeft() {
    switch (direction) {
      case NORTH:
        return new Point(x, y, WEST);
      case SOUTH:
        return new Point(x, y, EAST);
      case EAST:
        return new Point(x, y, NORTH);
      case WEST:
        return new Point(x, y, SOUTH);
      default:
        return START_POINT;
    }
  }

  public Point turnRight() {
    switch (direction) {
      case NORTH:
        return new Point(x , y, EAST);
      case SOUTH:
        return new Point(x , y, WEST);
      case EAST:
        return new Point(x, y, SOUTH);
      case WEST:
        return new Point(x, y, NORTH);
      default:
        return START_POINT;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Point point = (Point) o;

    if (x != point.x) {
      return false;
    }
    if (y != point.y) {
      return false;
    }
    return direction == point.direction;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    result = 31 * result + (direction != null ? direction.hashCode() : 0);
    return result;
  }
}
