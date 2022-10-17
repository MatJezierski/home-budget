package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mpas.homebudget.dao.CategoryRepository;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.service.CategoryService;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository dataRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public List<ExpenseCategory> readAllExpenseCategories() {

        logger.info("readAllCategories: ");

        List<ExpenseCategory> categoriesResult = (List<ExpenseCategory>) dataRepository.findAll();
        Collections.sort(categoriesResult, Comparator.comparing(ExpenseCategory::getCategoryName));
        logger.info("Sorted categories read from dao: {}", categoriesResult);

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
