/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.hippogriff.hamzah.mp.entities.MpMajor;
import xyz.hippogriff.hamzah.mp.entities.MpMedicalService;

/**
 *
 * @author said
 */
@Stateless
public class MpMedicalServiceBean {

    @Inject
    private DataAccessObject dao;

    public void create(MpMedicalService obj) {
        dao.create(obj);
    }

    public List<MpMedicalService> findAll() {
        return dao.findAll("MpMedicalService.findAll", MpMedicalService.class);
    }

    public MpMedicalService find(Long id) {
        return dao.find(id, MpMedicalService.class);
    }

    public void update(MpMedicalService obj) {
        dao.update(obj);
    }

    public void delete(MpMedicalService obj) {
        dao.delete(obj);
    }
}

