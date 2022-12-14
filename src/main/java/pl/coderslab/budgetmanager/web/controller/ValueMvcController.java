package pl.coderslab.budgetmanager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.budgetmanager.model.dao.CategoryDao;
import pl.coderslab.budgetmanager.model.dao.OwnerDao;
import pl.coderslab.budgetmanager.model.dao.ValueDao;
import pl.coderslab.budgetmanager.model.data.Category;
import pl.coderslab.budgetmanager.model.data.Owner;
import pl.coderslab.budgetmanager.model.data.Type;
import pl.coderslab.budgetmanager.model.data.Value;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@Validated
public class ValueMvcController {

    private final ValueDao valueDao;

    private final OwnerDao ownerDao;

    private final CategoryDao categoryDao;

    public ValueMvcController(ValueDao valueDao, OwnerDao ownerDao, CategoryDao categoryDao) {
        this.valueDao = valueDao;
        this.ownerDao = ownerDao;
        this.categoryDao = categoryDao;
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return Arrays.asList(Category.values());
    }
    @ModelAttribute("types")
    public List<Type> types() {
        return Arrays.asList(Type.values());
    }

    @ModelAttribute("owners")
    public List<Owner> owners() {
        return ownerDao.findAll();
    }

    @GetMapping("/add-value")
    public String showAddValueForm(Model model) {
        model.addAttribute("value", new Value());
        return "values/add";
    }

    @PostMapping("/add-value")
    public String processAddValueForm(@Valid Value value, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "values/add";
        }
        valueDao.save(value);
        return "redirect:/list-values";
    }

    @GetMapping("/list-values")
    public String showListValues(Model model) {
        model.addAttribute("values", valueDao.findAllWithDetails());
        return "values/list";
    }

    @GetMapping("/delete-value")
    public String showDeleteValue(Long id, Model model) {
        model.addAttribute("value", valueDao.findWithOwnersById(id));
        return "values/delete";
    }

    @PostMapping("/delete-value")
    public String processDeleteValue(Long id) {
        valueDao.deleteById(id);
        return "redirect:/list-values";
    }

    @GetMapping("/edit-value")
    public String showEditValue (Long id, Model model) {
        model.addAttribute("value", valueDao.findWithOwnersById(id));
        return "values/edit";
    }

    @PostMapping("/edit-value")
    public String processEditValue(Long id, @Valid Value value, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "values/edit";
        }
        Value dbValue = valueDao.findWithOwnersById(id);
        dbValue.setValue(value.getValue());
        dbValue.setOwners(value.getOwners());
        dbValue.setDate(value.getDate());
        dbValue.setCategory(value.getCategory());
        dbValue.setType(value.getType());
        valueDao.update(dbValue);
        return "redirect:/list-values";
    }

}
