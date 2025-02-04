/*
 * This source file was generated by the Gradle 'init' task
 */
package com.example.real;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class App {

    public String getGreeting() {
        return "The total for all transactions is ";
    }

    private static final String RESOURCE = "/Users/jihwooon/Workspaces/real-world-software-development/chapter1/src/main/resources/file.csv";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCE);
        final List<String> lines = Files.readAllLines(path);

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parserLinesFromCSV(
            lines);

        System.out.println(new App().getGreeting() + calculateTotalAmount(bankTransactions));
        System.out.println(
            new App().getGreeting() + selectInMonth(bankTransactions, Month.JANUARY));
    }

    private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.amount();
        }

        return total;
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions,
        final Month month) {
        ArrayList<BankTransaction> bankTransactionInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.date().getMonth() == month) {
                bankTransactionInMonth.add(bankTransaction);
            }
        }

        return bankTransactionInMonth;
    }
}
