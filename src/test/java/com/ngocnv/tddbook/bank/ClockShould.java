package com.ngocnv.tddbook.bank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClockShould {

  private Clock clock;

  @Before
  public void setUp() {
    clock = new TestableClock();
  }

  @Test
  public void return_today_date_in_dd_MM_yyyy_format() {
    String date = clock.todayAsString();
    assertThat(date, is("24/04/2015"));
  }

  class TestableClock extends Clock {

    @Override
    protected LocalDate getNow() {
      return LocalDate.of(2015, 4, 24);
    }
  }
}
