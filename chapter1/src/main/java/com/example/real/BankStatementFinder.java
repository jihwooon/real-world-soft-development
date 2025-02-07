package com.example.real;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementFinder {

    public List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions,
        final Month month) {
        return selectTransactions(bankTransactions,
            bankTransaction -> bankTransaction.date().getMonth() == month);
    }

    public List<BankTransaction> selectAmountGreaterThanEqual(final List<BankTransaction> bankTransactions,
        final int amount) {
        return selectTransactions(bankTransactions,
            bankTransaction -> bankTransaction.amount() >= amount);
    }

    public List<BankTransaction> selectTransactions(List<BankTransaction> bankTransactions,
        BankTransactionFinder finder) {
        ArrayList<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (finder.isTrue(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
