/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.hippogriff.hamzah.mp.entities.MpGeneralMajor;
import xyz.hippogriff.hamzah.mp.entities.MpMajor;

/**
 *
 * @author said
 */
@Stateless
public class MpMajorBean {


    @Inject
    private DataAccessObject dao;

    public void create(MpMajor obj) {
        dao.create(obj);
    }

    public List<MpMajor> findAll() {
        return dao.findAll("MpMajor.findAll", MpMajor.class);
    }
    public List<MpMajor> findByGenMajId(Long id) {
        return dao.find("MpMajor.findByGenMajId", MpMajor.class,"id",id);
    }

    public MpMajor find(Long id) {
        return dao.find(id, MpMajor.class);
    }

    public void update(MpMajor obj) {
        dao.update(obj);
    }

    public void delete(MpMajor obj) {
        dao.delete(obj);
    }
}

