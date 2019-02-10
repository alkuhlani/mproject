/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.hippogriff.hamzah.mp.entities.MpMedicalService;
import xyz.hippogriff.hamzah.mp.entities.MpService;

/**
 *
 * @author said
 */
@Stateless
public class MpServiceBean {

    @Inject
    private DataAccessObject dao;

    public void create(MpService obj) {
        dao.create(obj);
    }

    public List<MpService> findAll() {
        return dao.findAll("MpService.findAll", MpService.class);
    }

    public MpService find(Long id) {
        return dao.find(id, MpService.class);
    }

    public void update(MpService obj) {
        dao.update(obj);
    }

    public void delete(MpService obj) {
        dao.delete(obj);
    }
}

