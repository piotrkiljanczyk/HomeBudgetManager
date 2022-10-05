package pl.coderslab.budgetmanager.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.budgetmanager.model.data.Category;
import pl.coderslab.budgetmanager.model.data.Owner;
import pl.coderslab.budgetmanager.model.data.Value;
import pl.coderslab.budgetmanager.model.data.ValueDetails;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ValueRepository extends JpaRepository<Value, Long> {

    List<Value> findByType(String type);

    List<Value> findAllByDateAfter(Date date);

    List<Value> findAllByDateBefore(Date date);

    List<Value> findAllByDateBetween(Date date);

    List<Value> findAllByOwner(String owner);

    @Query("SELECT a FROM ValueDetails a WHERE a.firstName LIKE ?1%")
    List<ValueDetails> findAllWithFirstNamePrefix(String prefix);

    @Query("SELECT a FROM ValueDetails a WHERE a.lastName LIKE ?1%")
    List<ValueDetails> findAllWithLastNamePrefix(String prefix);

    List<Value> findAllByCategory(Category category);
}
