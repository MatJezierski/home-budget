package pl.mpas.homebudget.service;

import pl.mpas.homebudget.domain.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> readallExpenses();
}
