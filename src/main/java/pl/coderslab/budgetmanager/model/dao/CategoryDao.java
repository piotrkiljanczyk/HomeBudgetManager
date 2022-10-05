package pl.coderslab.budgetmanager.model.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.budgetmanager.model.data.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager em;

    public List<Category> findAll() {
        return em.createQuery("SELECT c FROM Category c").getResultList();
    }

    public void save (Category entity) {
        em.persist(entity);
    }

    public Category update(Category entity) {
        return em.merge(entity);
    }

    public void delete(Category entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void deleteById(Long id) {
        em.remove(em.find(Category.class, id));
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }
}
