package com.ngocnv.tddbook.marsrover;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MarsRoverTest {

  public static final int OBSTACLE = 999;
  private MarsRover marsRover;
  private Grid grid;
  private int[][] map;

  @Before
  public void setUp() {
    map = new int[10][10];
    grid = new Grid(map);
    marsRover = new MarsRover(grid);
  }

  @Test
  public void moveStraightOneStepWithoutObstacle_currentDirectionIsNorth() {
    setCurrentPoint(0, 0, Direction.NORTH);
    assertThat(marsRover.execute("M"), is("0:1:N"));
  }

  @Test
  public void moveStraightOneStepWithoutObstacle_currentDirectionIsSouth() {
    setCurrentPoint(1, 1, Direction.SOUTH);
    assertThat(marsRover.execute("M"), is("1:0:S"));
  }

  @Test
  public void moveStraightOneStepWithoutObstacle_currentDirectionIsEast() {
    setCurrentPoint(1, 1, Direction.EAST);
    assertThat(marsRover.execute("M"), is("2:1:E"));
  }

  @Test
  public void moveStraightOneStepWithoutObstacle_currentDirectionIsWest() {
    setCurrentPoint(1, 1, Direction.WEST);
    assertThat(marsRover.execute("M"), is("0:1:W"));
  }

  @Test
  public void turnLeftOneStepWithoutObstacle_currentDirectionIsNorth() {
    setCurrentPoint(1, 1, Direction.NORTH);
    assertThat(marsRover.execute("L"), is("1:1:W"));
  }

  @Test
  public void turnLeftOneStepWithoutObstacle_currentDirectionIsSouth() {
    setCurrentPoint(1, 1, Direction.SOUTH);
    assertThat(marsRover.execute("L"), is("1:1:E"));
  }

  @Test
  public void turnLeftOneStepWithoutObstacle_currentDirectionIsEast() {
    setCurrentPoint(1, 1, Direction.WEST);
    assertThat(marsRover.execute("L"), is("1:1:S"));
  }

  @Test
  public void turnLeftOneStepWithoutObstacle_currentDirectionIsWest() {
    setCurrentPoint(1, 1, Direction.EAST);
    assertThat(marsRover.execute("L"), is("1:1:N"));
  }

  @Test
  public void turnRightOneStepWithoutObstacle_currentDirectionIsNorth() {
    setCurrentPoint(1, 1, Direction.NORTH);
    assertThat(marsRover.execute("R"), is("1:1:E"));
  }

  @Test
  public void turnRightOneStepWithoutObstacle_currentDirectionIsSouth() {
    setCurrentPoint(1, 1, Direction.SOUTH);
    assertThat(marsRover.execute("R"), is("1:1:W"));
  }

  @Test
  public void turnRightOneStepWithoutObstacle_currentDirectionIsEast() {
    setCurrentPoint(1, 1, Direction.EAST);
    assertThat(marsRover.execute("R"), is("1:1:S"));
  }

  @Test
  public void turnRightOneStepWithoutObstacle_currentDirectionIsWest() {
    setCurrentPoint(1, 1, Direction.WEST);
    assertThat(marsRover.execute("R"), is("1:1:N"));
  }


  @Test
  public void moveStraightOneStepWithObstacle_currentDirectionIsNorth() {
    setCurrentPoint(0, 0, Direction.NORTH);
    setObstable(0, 1);
    assertThat(marsRover.execute("M"), is("O:0:0:N"));
  }

  @Test
  public void moveMultiStepsWithoutObstacle_currentDirectionIsNorth() {
    setCurrentPoint(0, 0, Direction.NORTH);
    assertThat(marsRover.execute("MMRMMLM"), is("2:3:N"));
  }

  @Test
  public void moveMultiStepsWithObstacle_currentDirectionIsNorth2() {
    setCurrentPoint(0, 0, Direction.NORTH);
    //setObstable(0, 1);
    assertThat(marsRover.execute("MMMMMMMMMM"), is("0:0:N"));
  }

  @Test
  public void moveMultiStepsWithObstacle_currentDirectionIsNorth3() {
    setCurrentPoint(0, 0, Direction.NORTH);
    //setObstable(0, 1);
    assertThat(marsRover.execute("RMMLM"), is("2:1:N"));
  }


  @Test
  public void moveMultiStepsWithObstacle_currentDirectionIsNorth() {
    setCurrentPoint(0, 0, Direction.NORTH);
    setObstable(0, 3);
    assertThat(marsRover.execute("MMMM"), is("O:0:2:N"));
  }

  private void setObstable(int x, int y) {
    map[x][y] = OBSTACLE;
  }

  private void setCurrentPoint(int x, int y, Direction direction) {
    marsRover = new MarsRoverTestable(grid);
    ((MarsRoverTestable) marsRover).setCurrentPoint(new Point(x, y, direction));
  }

  class MarsRoverTestable extends MarsRover {
    public MarsRoverTestable(Grid grid) {
      super(grid);
    }

    public void setCurrentPoint(Point currentPoint) {
      this.currentPoint = currentPoint;
    }
  }
}
