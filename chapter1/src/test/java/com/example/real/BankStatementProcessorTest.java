package com.example.real;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankStatementProcessorTest {

    private BankStatementProcessor bankStatementProcessor;
    private List<BankTransaction> bankTransactions;

    @BeforeEach
    void setUp() {
        bankTransactions = Arrays.asList(new BankTransaction(
            LocalDate.of(2017, Month.JANUARY, 30), 5000, "Tesco"));
        bankStatementProcessor = new BankStatementProcessor(bankTransactions);
    }

    @Test
    @DisplayName("주어진 값이 작으면 List 값에 담겨져 반환하라")
    void should_return_transactions_greater_than_Equal_amount() {
        List<BankTransaction> result = bankStatementProcessor.findTransactionGreaterThanEqual(
            4000);

        assertThat(result.size()).isEqualTo(1);

        assertThat(result).isEqualTo(Arrays.asList(new BankTransaction(
            LocalDate.of(2017, Month.JANUARY, 30), 5000, "Tesco")));
    }

    @Test
    @DisplayName("주어진 값이 크면 빈 배열을 반환하라")
    void return_empty_list_if_no_transactions_greater_than_Equal_amount() {
        List<BankTransaction> result = bankStatementProcessor.findTransactionGreaterThanEqual(
            100000);

        assertThat(result.size()).isEqualTo(0);
        assertThat(result).isEqualTo(Arrays.asList());
    }

    @Test
    @DisplayName("특정 월이 주어지고 달 월이 일치하면 리스트를 반환하라")
    void should_return_transactions_equal_in_month() {
        List<BankTransaction> result = bankStatementProcessor.findTransactionsInMonth(
            Month.JANUARY);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result).isEqualTo(Arrays.asList(new BankTransaction(
            LocalDate.of(2017, Month.JANUARY, 30), 5000, "Tesco")));
    }

    @Test
    @DisplayName("특정 월이 주어지고 달 월이 불일치하면 빈 배열을 반환하라")
    void should_return_empty_list_if_no_equal_in_month() {
        List<BankTransaction> result = bankStatementProcessor.findTransactionsInMonth(
            Month.AUGUST);

        assertThat(result.size()).isEqualTo(0);
        assertThat(result).isEqualTo(Arrays.asList());
    }

    @Test
    @DisplayName("특정 월이 주어지고 값이 일치하거나 낮으면 리스트를 반환하라")
    void should_return_transactions_equal_in_month_and_greater_than_amount() {
        List<BankTransaction> result = bankStatementProcessor.findTransactionsInMonthAndGreater(
            Month.JANUARY, 4000);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result).isEqualTo(Arrays.asList(new BankTransaction(
            LocalDate.of(2017, Month.JANUARY, 30), 5000, "Tesco")));
    }

    @Test
    @DisplayName("특정 월이 주어지고 달 월이 불일치하고 값이 일치하지 않거나 크면 빈 배열을 반환하라")
    void should_return_empty_list_if_no_equal_in_month_and_greater_than_amount() {
        List<BankTransaction> result = bankStatementProcessor.findTransactionsInMonthAndGreater(
            Month.AUGUST, 10000);

        assertThat(result.size()).isEqualTo(0);
        assertThat(result).isEqualTo(Arrays.asList());
    }
}
