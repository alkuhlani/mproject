/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;
import xyz.hippogriff.hamzah.mp.entities.MpStreet;

/**
 *
 * @author said
 */
@Stateless
public class MpStreetBean {

    @Inject
    private DataAccessObject dao;

    public void create(MpStreet obj) {
        dao.create(obj);
    }

    public List<MpStreet> findAll() {
        return dao.findAll("MpStreet.findAll", MpStreet.class);
    }
    public List<MpStreet> findBydirId(Long id) {
        return dao.find("MpStreet.findBydirId", MpStreet.class,"id",id);
    }

    public MpStreet find(Long id) {
        return dao.find(id, MpStreet.class);
    }

    public void update(MpStreet obj) {
        dao.update(obj);
    }

    public void delete(MpStreet obj) {
        dao.delete(obj);
    }
}
