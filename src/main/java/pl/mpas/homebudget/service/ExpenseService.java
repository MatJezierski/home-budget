package pl.mpas.homebudget.service;

import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.domain.ExpenseCategory;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<Expense> readAllExpenses();
    void saveExpense(Expense theExpense);
    Optional<Expense> findExpenseById(Long id);
    List<Expense> findExpenseByAmount(double amount);
    void deleteExpenseById(Long id);
}
