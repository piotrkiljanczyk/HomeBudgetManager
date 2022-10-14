package pl.coderslab.budgetmanager.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.budgetmanager.model.dao.OwnerDao;
import pl.coderslab.budgetmanager.model.data.Owner;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerDao ownerDao;

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        ownerDao.save(owner);
        return owner;
    }

    @GetMapping("/{id}")
    public Owner getOwner (@PathVariable Long id) {
        return ownerDao.findById(id);
    }

    @PutMapping("/{id}")
    public Owner updateOwner (@PathVariable Long id, @RequestBody Owner owner) {
        Owner dbOwner = ownerDao.findById(id);
        dbOwner.setFirstName(owner.getFirstName());
        dbOwner.setLastName(owner.getLastName());
        return ownerDao.update(dbOwner);
    }

    @DeleteMapping("/{id}")
    public Owner deleteOwner (@PathVariable Long id) {
        Owner dbOwner = ownerDao.findById(id);
        ownerDao.delete(dbOwner);
        return dbOwner;
    }
}
