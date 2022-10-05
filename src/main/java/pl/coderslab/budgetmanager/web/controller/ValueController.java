package pl.coderslab.budgetmanager.web.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.budgetmanager.model.dao.CategoryDao;
import pl.coderslab.budgetmanager.model.dao.OwnerDao;
import pl.coderslab.budgetmanager.model.dao.ValueDao;
import pl.coderslab.budgetmanager.model.data.Owner;
import pl.coderslab.budgetmanager.model.data.Value;
import pl.coderslab.budgetmanager.model.repository.ValueRepository;

import java.util.List;

@RestController
@RequestMapping("/values")
public class ValueController {

    private final ValueRepository valueRepository;

    private final ValueDao valueDao;

    private final OwnerDao ownerDao;

    private final CategoryDao categoryDao;

    public ValueController(ValueRepository valueRepository, ValueDao valueDao, OwnerDao ownerDao, CategoryDao categoryDao) {
        this.valueRepository = valueRepository;
        this.valueDao = valueDao;
        this.ownerDao = ownerDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping
    public List<Value> findAllValuesWithOwners() {
        return valueDao.findAllWithOwners();
    }

//    @PostMapping
//    public Value createValue(@RequestBody ValueWithDetails valueWithDetails) {
//    }

}
