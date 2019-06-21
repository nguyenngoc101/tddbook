package com.ngocnv.tddbook.bank;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

  @Mock private TransactionRepository transactionRepository;
  private Account account;
  @Mock
  private StatementPrinter statementPrinter;

  @Before
  public void setUp() {
    account = new Account(transactionRepository, statementPrinter);
  }

  @Test
  public void store_a_deposit_transaction() {
    account.deposit(100);

    verify(transactionRepository).addDeposit(100);
  }

  @Test
  public void store_a_withdraw_transaction() {
    account.withdraw(100);

    verify(transactionRepository).addWithdraw(100);
  }

  @Test
  public void print_a_statement() {
    List<Transaction> transactions = Arrays.asList(new Transaction());
    given(transactionRepository.allTransactions()).willReturn(transactions);

    account.printStatement();
    verify(statementPrinter).print(transactions);
  }
}
