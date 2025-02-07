package com.example.real;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.amount();
        }

        return total;
    }

    public List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions,
        final Month month) {
        ArrayList<BankTransaction> bankTransactionInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.date().getMonth() == month) {
                bankTransactionInMonth.add(bankTransaction);
            }
        }

        return bankTransactionInMonth;
    }

    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.amount() >= amount);
    }

    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        return findTransactions(bankTransaction -> bankTransaction.date().getMonth() == month);
    }

    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month,
        final int amount) {
        return findTransactions(bankTransaction ->
            bankTransaction.amount() >= amount && bankTransaction.date().getMonth() == month
        );
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }

        return result;
    }
}
