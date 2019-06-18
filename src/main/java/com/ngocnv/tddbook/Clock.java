package com.ngocnv.tddbook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

  public static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public String todayAsString() {
    LocalDate today = getNow();
    return today.format(DD_MM_YYYY);
  }

  protected LocalDate getNow() {
    return LocalDate.now();
  }
}
