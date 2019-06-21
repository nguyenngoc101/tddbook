package com.ngocnv.tddbook.marsrover;

public class Grid {

  public static final int OBSTACLE = 999;
  int[][] map;
  int size;

  public Grid(int[][] map) {
    this.map = map;
    size = map.length;
  }

  public boolean isObstacle(Point point) {
    return map[point.x][point.y] == OBSTACLE;
  }

  public boolean outOfGrid(Point head) {
    return head.x < 0 || head.x >= 10 || head.y < 0 || head.y >=10;
  }
}
