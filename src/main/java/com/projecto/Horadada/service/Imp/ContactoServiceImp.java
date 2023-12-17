package com.projecto.Horadada.service.Imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.Horadada.Dao.ContactoDao;
import com.projecto.Horadada.Entity.ContactoEntity;
import com.projecto.Horadada.service.ContactoService;

@Service("contactoServiceImp")
public class ContactoServiceImp implements ContactoService {

    @Autowired
    @Qualifier("contactoDao")
    private ContactoDao contactoDao;

    @Override
    public List<ContactoEntity> findByAll() {
        List<ContactoEntity> con = (List<ContactoEntity>) contactoDao.findAll();
        return con;
    }

    @Override
    public int findbyidcliente(int id) {
        int con = contactoDao.getclienteIdCliente(id);
        return con;
    }

    @Override
    public ContactoEntity save(ContactoEntity contacto) {
        try {
            ContactoEntity cont = contactoDao.save(contacto);
            return cont;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(int id) {
        contactoDao.deleteById(id);
    }

    @Override
    public ContactoEntity findByidcontacto(int id) {
        ContactoEntity contacto = contactoDao.findByidContacto(id);
        return contacto;
    }

    @Override
    public Page<ContactoEntity> findAll(Pageable pageRequest) {
        // TODO Auto-generated method stub
        return contactoDao.findAll(pageRequest);
    }

}
