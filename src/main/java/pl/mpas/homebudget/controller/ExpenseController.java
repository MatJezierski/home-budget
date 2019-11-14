package pl.mpas.homebudget.controller;

import org.springframework.ui.Model;

public interface ExpenseController {

    String allExpenses(Model expenses);

    String addExpense(Model expense);

    String showChart (Model chart);

}
