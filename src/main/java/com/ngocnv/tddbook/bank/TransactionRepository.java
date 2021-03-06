package com.ngocnv.tddbook.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {

  private Clock clock;
  private List<Transaction> transactions = new ArrayList();

  public TransactionRepository(Clock clock) {
    this.clock = clock;
  }

  public void addDeposit(int amount) {
    Transaction depositTransaction = new Transaction(clock.todayAsString(), amount);
    transactions.add(depositTransaction);
  }

  public void addWithdraw(int amount) {
    Transaction withdrawTransaction = new Transaction(clock.todayAsString(), -amount);
    transactions.add(withdrawTransaction);
  }

  public List<Transaction> allTransactions() {
    return Collections.unmodifiableList(transactions);
  }
}
