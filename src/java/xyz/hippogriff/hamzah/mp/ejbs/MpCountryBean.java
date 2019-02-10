/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs;


import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.hippogriff.hamzah.mp.entities.MpCountry;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityPermission;

/**
 *
 * @author user
 */
@Stateless
public class MpCountryBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private DataAccessObject dao;

    public void create(MpCountry obj) {
        dao.create(obj);
    }

    public List<MpCountry> findAll() {
        return dao.findAll("MpCountry.findAll", MpCountry.class);
    }

    public List<MpCountry> findByPrimaryIdTable(Long primaryIdTable) {
        return dao.find("MpCountry.findAll", MpCountry.class, "id", primaryIdTable);
    }

    public MpCountry find(Long id) {
        return dao.find(id, MpCountry.class);
    }

    public void update(MpCountry obj) {
        dao.update(obj);
    }

    public void delete(MpCountry obj) {
        dao.delete(obj);
    }
}
