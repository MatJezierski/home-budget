package pl.mpas.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mpas.homebudget.domain.ExpenseCategory;

@Repository
public interface ExpenseCategoryRepository extends CrudRepository <ExpenseCategory, Long> {

    // DAO = Data Access Object

}
