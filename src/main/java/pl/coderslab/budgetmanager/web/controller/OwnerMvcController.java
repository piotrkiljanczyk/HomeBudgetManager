package pl.coderslab.budgetmanager.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.budgetmanager.model.dao.OwnerDao;
import pl.coderslab.budgetmanager.model.dao.ValueDao;
import pl.coderslab.budgetmanager.model.data.Owner;

import javax.validation.Valid;

@Controller
@Validated
@RequiredArgsConstructor
public class OwnerMvcController {

    private final OwnerDao ownerDao;

    private final ValueDao valueDao;

    @GetMapping("/delete-owner")
    public String showDeleteOwner (Long id, Model model) {
        model.addAttribute("owner", ownerDao.findById(id));
        model.addAttribute("ownerHasValue", valueDao.checkOwnerHasValue(ownerDao.findById(id)));
        return "owners/delete";
    }

    @PostMapping("/delete-owner")
    public String processDeleteOwner (Long id) {
        ownerDao.deleteById(id);
        return "redirect:/list-owners";
    }

    @GetMapping("/edit-owner")
    public String showEditOwner (Long id, Model model) {
        model.addAttribute("owner", ownerDao.findById(id));
        return "owners/edit";
    }

    @PostMapping("/edit-owner")
    public String processEditOwner(Long id, @Valid Owner owner, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "owners/edit";
        }
        Owner dbOwner = ownerDao.findById(id);
        dbOwner.setFirstName(owner.getFirstName());
        dbOwner.setLastName(owner.getLastName());
        ownerDao.update(dbOwner);
        return "redirect:/list-owners";
    }

    @GetMapping("/list-owners")
    public String showListOwners(Model model) {
        model.addAttribute("owners", ownerDao.findAll());
        return "owners/list";
    }

    @GetMapping("/add-owner")
    public String showAddOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/add";
    }

    @PostMapping("/add-owner")
    public String processAddOwner(@Valid Owner owner, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "owners/add";
        }
        ownerDao.save(owner);
        return "redirect:/list-owners";
    }

}
