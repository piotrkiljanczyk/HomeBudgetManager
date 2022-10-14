package pl.coderslab.budgetmanager.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.budgetmanager.model.dao.ValueDao;
import pl.coderslab.budgetmanager.model.data.Value;

import java.util.List;

@RestController
@RequestMapping("/values")
@RequiredArgsConstructor

public class ValueController {

//    private final ValueRepository valueRepository;

    private final ValueDao valueDao;
//    private final OwnerDao ownerDao;
//
//    private final CategoryDao categoryDao;

//    public ValueController(ValueRepository valueRepository, ValueDao valueDao, OwnerDao ownerDao, CategoryDao categoryDao) {
//        this.valueRepository = valueRepository;
//        this.valueDao = valueDao;
//        this.ownerDao = ownerDao;
//        this.categoryDao = categoryDao;
//    }

    @GetMapping
    public List<Value> findAllValuesWithOwners() {
        return valueDao.findAllWithOwners();
    }

//    @PostMapping
//    public Value createValue(@RequestBody ValueWithDetails valueWithDetails) {
//    }

}
