package com.ngocnv.tddbook.bank;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

  private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
  private final Console console;

  private DecimalFormat decimalFormater = new DecimalFormat("#.00");

  public StatementPrinter(Console console) {
    this.console = console;
  }

  public void print(List<Transaction> transactions) {
    printStatementHeader();
    printStatementLines(transactions);
  }

  private void printStatementHeader() {
    console.printLine(STATEMENT_HEADER);
  }

  private void printStatementLines(List<Transaction> transactions) {
    AtomicInteger runningBalance = new AtomicInteger(0);
    transactions.stream()
        .map(transaction -> statementLine(transaction, runningBalance))
        .collect(Collectors.toCollection(LinkedList::new))
        .descendingIterator()
        .forEachRemaining(console::printLine);
  }

  private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
    return transaction.getDate()
        + " | "
        + decimalFormater.format(transaction.getAmount())
        + " | "
        + decimalFormater.format(runningBalance.addAndGet(transaction.getAmount()));
  }

}
