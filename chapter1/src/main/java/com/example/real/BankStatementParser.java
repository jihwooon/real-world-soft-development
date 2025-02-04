package com.example.real;

import java.util.List;

public interface BankStatementParser {

    BankTransaction paresFromCSV(String line);

    List<BankTransaction> parserLinesFromCSV(List<String> lines);
}
