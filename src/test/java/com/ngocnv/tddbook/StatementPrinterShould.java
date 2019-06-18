package com.ngocnv.tddbook;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

  private static final List<Transaction> NO_TRANSACTIONS = EMPTY_LIST;
  private StatementPrinter statementPrinter;

  @Mock private Console console;

  @Before
  public void setUp() {
    statementPrinter = new StatementPrinter(console);
  }

  @Test
  public void always_printer_header() {
    statementPrinter.print(NO_TRANSACTIONS);
    verify(console).printLine("DATE | AMOUNT | BALANCE");
  }

  @Test
  public void print_transactions_in_reverse_chronological_order() {
    List<Transaction> transactions = transactionContaining(
        deposit("01/04/2014", 1000),
        withdraw("02/04/2014", 100),
        deposit("10/04/2014", 500)
    );

    statementPrinter.print(transactions);

    InOrder inOrder = Mockito.inOrder(console);

    inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
    inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
    inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
    inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
  }

  private List<Transaction> transactionContaining(Transaction ...transactions) {
    return asList(transactions);
  }

  private Transaction withdraw(String date, int amount) {
    return new Transaction(date, -amount);
  }

  private Transaction deposit(String date, int amount) {
    return new Transaction(date, amount);
  }
}
