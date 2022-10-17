package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mpas.homebudget.dao.ExpenseCategoryRepository;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.service.ExpenseCategoryService;

import java.util.*;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseCategoryServiceImpl.class);

    private final ExpenseCategoryRepository dataRepository;

    @Autowired
    public ExpenseCategoryServiceImpl (ExpenseCategoryRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public List<ExpenseCategory> readAllExpenseCategories() {

        logger.info("readAllCategories()");

        List<ExpenseCategory> categoriesResult = (List<ExpenseCategory>) dataRepository.findAll();
        Collections.sort(categoriesResult, Comparator.comparing(ExpenseCategory::getCategoryName));
        logger.info("Sorted Expense Categories read from dao: {}", categoriesResult);

        return categoriesResult;
    }

    @Override
    public boolean saveCategory(ExpenseCategory expenseCategory) {
        ExpenseCategory savedCategory = dataRepository.save(expenseCategory);
        return null != savedCategory.getId();
    }

    @Override
    public Optional<ExpenseCategory> findCategoryById(Long id) {
        return dataRepository.findById(id);
    }

    @Override
    public void deleteCategoryById(Long id) {
        dataRepository.deleteById(id);
    }
}
