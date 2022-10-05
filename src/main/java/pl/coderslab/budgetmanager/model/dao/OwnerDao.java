package pl.coderslab.budgetmanager.model.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.budgetmanager.model.data.Owner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OwnerDao {

    @PersistenceContext
    private EntityManager em;

    public List<Owner> findAll() {
        return em.createQuery("SELECT a FROM Owner a").getResultList();
    }

    public void save(Owner entity) {
        em.persist(entity);
    }

    public Owner update(Owner entity) {
        return em.merge(entity);
    }

    public void delete(Owner entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void deleteById(Long id) {
        em.remove(em.find(Owner.class, id));
    }

    public Owner findById(Long id) {
        return em.find(Owner.class, id);
    }
}