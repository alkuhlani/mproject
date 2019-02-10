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

/**
 *
 * @author said
 */
@Stateless
public class MpGeneralMajorBean {

    @Inject
    private DataAccessObject dao;

    public void create(MpGeneralMajor obj) {
        dao.create(obj);
    }

    public List<MpGeneralMajor> findAll() {
        return dao.findAll("MpGeneralMajor.findAll", MpGeneralMajor.class);
    }

    public MpGeneralMajor find(Long id) {
        return dao.find(id, MpGeneralMajor.class);
    }

    public void update(MpGeneralMajor obj) {
        dao.update(obj);
    }

    public void delete(MpGeneralMajor obj) {
        dao.delete(obj);
    }
}
