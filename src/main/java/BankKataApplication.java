import com.ngocnv.tddbook.bank.Account;
import com.ngocnv.tddbook.bank.Clock;
import com.ngocnv.tddbook.bank.Console;
import com.ngocnv.tddbook.bank.StatementPrinter;
import com.ngocnv.tddbook.bank.TransactionRepository;

public class BankKataApplication {

  public static void main(String[] args) {
    Clock clock = new Clock();
    TransactionRepository transactionRepository = new TransactionRepository(clock);
    Console console = new Console();
    StatementPrinter statementPrinter = new StatementPrinter(console);
    Account account = new Account(transactionRepository, statementPrinter);
    account.deposit(1000);
    account.deposit(100);
    account.withdraw(600);
    account.printStatement();
  }

}
