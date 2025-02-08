package com.example.real;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;

class BankStatementCSVParserTest {

    final BankStatementCSVParser statementCSVParser = new BankStatementCSVParser();

    @Test
    void shouldParseOneCorrectLine() {
        final String line = "30-01-2017,-50,Tesco";

        BankTransaction result = statementCSVParser.paresFromCSV(line);

        BankTransaction bankTransaction = new BankTransaction(
            LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        assertThat(bankTransaction.amount()).isEqualTo(result.amount());
        assertThat(bankTransaction.date()).isEqualTo(result.date());
    }
}
