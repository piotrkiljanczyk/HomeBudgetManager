package pl.coderslab.budgetmanager.model.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.budgetmanager.model.data.Owner;
import pl.coderslab.budgetmanager.model.data.Value;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ValueDao {

    @PersistenceContext
    private EntityManager em;

    public boolean checkOwnerHasValue (Owner owner) {
        List<Value> values = em.createQuery("SELECT b FROM Value b WHERE :owner MEMBER OF b.owners", Value.class)
                .setParameter("owner", owner)
                .getResultList();
        return !values.isEmpty();
    }

    public List<Value> findAllWithOwners() {
        Query query = em.createQuery("SELECT DISTINCT b FROM Value b LEFT JOIN fetch b.owners");
        return query.getResultList();
    }

    public List<Value> findAllWithDetails() {
        return em.createQuery("SELECT distinct b FROM Value b LEFT JOIN fetch b.owners").getResultList();
    }

    public List<Value> findAllByType(List<String> type) {
        Query query = em.createQuery("SELECT b FROM Value b WHERE b.type = :type");
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<Value> findAllWithType() {
        Query query = em.createQuery("SELECT b FROM Value b LEFT JOIN fetch b.type");
        return query.getResultList();
    }

    public List<Value> findAllByDate(Value date) {
        Query query = em.createQuery("SELECT b FROM Value b WHERE b.date = :date");
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<Value> findAllWithDate() {
        Query query = em.createQuery("SELECT b FROM Value b LEFT JOIN fetch b.date");
        return query.getResultList();
    }

    public Value findWithOwnersById (Long id) {
        Value value = em.find(Value.class, id);
        Hibernate.initialize(value.getOwners());
        return value;
    }

    public void save (Value entity) {
        em.persist(entity);
    }

    public Value update (Value entity) {
        return em.merge(entity);
    }

    public void delete (Value entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void deleteById(Long id) {
        em.remove(em.find(Value.class, id));
    }

    public Value findById(Long id) {
        return em.find(Value.class, id);
    }
}
