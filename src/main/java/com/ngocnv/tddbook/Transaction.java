package com.ngocnv.tddbook;

import java.util.Objects;

public class Transaction {

  private String date;
  private int amount;

  public Transaction(String date, int amount) {
    this.date = date;
    this.amount = amount;
  }

  public Transaction() {
  }

  public String getDate() {
    return date;
  }

  public int getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Transaction that = (Transaction) o;

    if (amount != that.amount) {
      return false;
    }
    return date != null ? date.equals(that.date) : that.date == null;
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, amount);
  }
}
