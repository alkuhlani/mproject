/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs.security;

import xyz.hippogriff.hamzah.mp.ejbs.DataAccessObject;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Stateless
public class SecurityUserBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(SecurityUser obj) {
        dao.create(obj);
    }

    public List<SecurityUser> findAll() {
        return dao.findAll("SecurityUser.findAll", SecurityUser.class);
    }

    public List<SecurityUser> findByPrimaryIdTable(Long primaryIdTable) {
        return dao.find("SecurityUser.primaryIdTable", SecurityUser.class, "id", primaryIdTable);
    }

    public SecurityUser find(Long id) {
        return dao.find(id, SecurityUser.class);
    }

    public void update(SecurityUser obj) {
        dao.update(obj);
    }

    public void delete(SecurityUser obj) {
        dao.delete(obj);
    }
}
