import com.ngocnv.tddbook.Account;
import com.ngocnv.tddbook.Clock;
import com.ngocnv.tddbook.Console;
import com.ngocnv.tddbook.StatementPrinter;
import com.ngocnv.tddbook.TransactionRepository;

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
