/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.hippogriff.hamzah.mp.entities.MpNickname;

/**
 *
 * @author said
 */
@Stateless
public class MpNicknameBean {

    @Inject
    private DataAccessObject dao;

    public void create(MpNickname obj) {
        dao.create(obj);
    }

    public List<MpNickname> findAll() {
        return dao.findAll("MpNickname.findAll", MpNickname.class);
    }

    public MpNickname find(Long id) {
        return dao.find(id, MpNickname.class);
    }

    public void update(MpNickname obj) {
        dao.update(obj);
    }

    public void delete(MpNickname obj) {
        dao.delete(obj);
    }
}

