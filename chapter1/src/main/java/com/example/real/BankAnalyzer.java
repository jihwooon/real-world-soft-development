package com.example.real;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankAnalyzer {

    private static final String RESOURCE = "/Users/jihwooon/Workspaces/real-world-software-development/chapter1/src/main/resources/file.csv";

    private static String getGreeting() {
        return "The total for all transactions is ";
    }

    public static void analyze(BankStatementParser bankStatementCSVParser) throws IOException {
        final Path path = Paths.get(RESOURCE);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parserLinesFromCSV(
            lines);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(
            bankTransactions);

        collectSummary(bankStatementProcessor, bankTransactions);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor,
        List<BankTransaction> bankTransactions) {
        System.out.println(getGreeting() + bankStatementProcessor.calculateTotalAmount(
            bankTransactions));
        System.out.println(getGreeting() + bankStatementProcessor.selectInMonth(bankTransactions,
            Month.JANUARY));
    }
}
