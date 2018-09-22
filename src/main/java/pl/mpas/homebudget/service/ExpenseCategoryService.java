package pl.mpas.homebudget.service;

import pl.mpas.homebudget.domain.ExpenseCategory;

import java.util.List;
import java.util.Optional;

public interface ExpenseCategoryService {

    List<ExpenseCategory> readAllExpenseCategories();

    boolean saveCategory(ExpenseCategory expenseCategory);

    Optional<ExpenseCategory> findCategoryById(Long id);

    void deleteCategoryById(Long id);

}
