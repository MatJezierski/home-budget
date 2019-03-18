package pl.mpas.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mpas.homebudget.domain.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository <Expense, Long> {

}
