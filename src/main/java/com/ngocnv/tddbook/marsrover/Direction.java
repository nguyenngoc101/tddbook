package com.ngocnv.tddbook.marsrover;

public enum Direction {
  NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

  private String name;

  Direction(String direction) {
    this.name = direction;
  }

  public String getName() {
    return name;
  }
}
