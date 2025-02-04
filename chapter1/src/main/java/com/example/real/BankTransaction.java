package com.example.real;

import java.time.LocalDate;
import java.util.Objects;

public record BankTransaction(LocalDate date, double amount, String description) {

    @Override
    public String toString() {
        return "BankTransaction{" +
            "date=" + date +
            ", amount=" + amount +
            ", description='" + description + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BankTransaction that)) {
            return false;
        }
        return Double.compare(amount, that.amount) == 0 && Objects.equals(date,
            that.date) && Objects.equals(description, that.description);
    }

}
