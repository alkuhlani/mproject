/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.mbs.security;

import xyz.hippogriff.hamzah.mp.mbs.*;
import xyz.hippogriff.hamzah.mp.ejbs.security.SecurityPermissionBean;
import xyz.hippogriff.hamzah.mp.ejbs.security.SecurityUserBean;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityPermission;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "securityPermissionMB")
@ViewScoped
public class SecurityPermissionMB implements Serializable {

    /**
     * Creates a new instance of SecurityPermissionMB
     */
    public SecurityPermissionMB() {
    }
    private SecurityPermission item;
    private List<SecurityPermission> items;

    @Inject
    private SecurityPermissionBean bean;
    @Inject
    private SecurityUserBean sub;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new SecurityPermission();
        item.setCreateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
        item.setCreateTime(new Date());

    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
        item.setUpdateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
        item.setCreateTime(new Date());
    }

    public void create() {
        bean.create(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Saved"));
        //  return "items?faces-redirect=true";
    }

    public String update() {
        bean.update(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
        return "items?faces-redirect=true";

    }

    public String delete() {
        bean.delete(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Deleted"));
        return "items?faces-redirect=true";
    }

    public SecurityPermission getItem() {
        return item;
    }

    public void setItem(SecurityPermission item) {
        this.item = item;
    }

    public List<SecurityPermission> getItems() {
        return items;
    }

    public void setItems(List<SecurityPermission> items) {
        this.items = items;
    }

}
