package pl.coderslab.budgetmanager.model.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.budgetmanager.model.data.ValueDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ValueDetailsDao {

    @PersistenceContext
    private EntityManager em;

    public void save(ValueDetails entity) {
        em.persist(entity);
    }

    public ValueDetails update(ValueDetails entity) {
        return em.merge(entity);
    }

    public void delete(ValueDetails entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void deleteById(Long id) {
        em.remove(em.find(ValueDetails.class, id));
    }

    public ValueDetails findById(Long id) {
        return em.find(ValueDetails.class, id);
    }
}
