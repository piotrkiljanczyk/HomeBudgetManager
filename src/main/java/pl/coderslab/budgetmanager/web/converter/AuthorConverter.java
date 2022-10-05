package pl.coderslab.budgetmanager.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.budgetmanager.model.dao.OwnerDao;
import pl.coderslab.budgetmanager.model.data.Owner;

public class AuthorConverter implements Converter<String, Owner> {

    private OwnerDao ownerDao;

    @Override
    public Owner convert(String source) {
        return ownerDao.findById(Long.parseLong(source));
    }

    @Autowired
    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }
}
