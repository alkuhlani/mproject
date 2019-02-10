/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.hippogriff.hamzah.mp.entities.MpDirectorate;

/**
 *
 * @author said
 */
@Stateless
public class MpDirectorateBean {

    @Inject
    private DataAccessObject dao;

    public void create(MpDirectorate obj) {
        dao.create(obj);
    }

    public List<MpDirectorate> findAll() {
        return dao.findAll("MpDirectorate.findAll", MpDirectorate.class);
    }
    public List<MpDirectorate> findByGovId(long id) {
        return dao.find("MpDirectorate.findByGovId", MpDirectorate.class,"id",id);
    }

    public MpDirectorate find(Long id) {
        return dao.find(id, MpDirectorate.class);
    }

    public void update(MpDirectorate obj) {
        dao.update(obj);
    }

    public void delete(MpDirectorate obj) {
        dao.delete(obj);
    }
}
