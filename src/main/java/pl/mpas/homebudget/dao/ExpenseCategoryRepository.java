package pl.mpas.homebudget.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mpas.homebudget.domain.ExpenseCategory;

@Repository
public interface ExpenseCategoryRepository extends CrudRepository <ExpenseCategory, Long> {

    // DAO = Data Access Object

    // @Repository ze Spring-data  tworzy dynamicznie klasę (bo ta adnotacja jest nad interfejsem),
    // która obsługuje bazę danych wykonując zapytania, które generuje na podstawie nazw metod tego interfejsu.
    // Powoduje też, że wyjątki związane z bazą danych są zamieniane na Springowe DataAccessExceptions.

}
