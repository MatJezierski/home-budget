package pl.mpas.homebudget.controller;

import org.springframework.ui.Model;

public interface ExpenseController {

    String showAllExpenses(Model expenses);

    String addExpense(Model newExpense);

    String showChart (Model newChart);

    String removeExpense (Model removedExpense);

}
