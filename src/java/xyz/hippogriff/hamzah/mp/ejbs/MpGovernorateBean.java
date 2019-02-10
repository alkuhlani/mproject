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
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;

/**
 *
 * @author said
 */
@Stateless
public class MpGovernorateBean {

    @Inject
    private DataAccessObject dao;

    public void create(MpGovernorate obj) {
        dao.create(obj);
    }

    public List<MpGovernorate> findAll() {
        return dao.findAll("MpGovernorate.findAll", MpGovernorate.class);
    }
    public List<MpGovernorate> findByCountryId(Long id) {
        return dao.find("MpGovernorate.findByCountryId", MpGovernorate.class,"id",id);
    }

    public MpGovernorate find(Long id) {
        return dao.find(id, MpGovernorate.class);
    }

    public void update(MpGovernorate obj) {
        dao.update(obj);
    }

    public void delete(MpGovernorate obj) {
        dao.delete(obj);
    }
}
