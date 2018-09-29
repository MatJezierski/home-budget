package pl.mpas.homebudget.controller;

import org.springframework.ui.Model;

public interface ExpenseController {

    String showAllExpenses(Model model);

    String addExpense(Model model);

}
