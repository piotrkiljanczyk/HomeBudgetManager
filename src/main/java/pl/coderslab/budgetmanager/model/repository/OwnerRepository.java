package pl.coderslab.budgetmanager.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.budgetmanager.model.data.Owner;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByFirstName(String first_name);

    List<Owner> findByLastName(String last_name);
}
