/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.mbs.security;

import xyz.hippogriff.hamzah.mp.mbs.*;
import xyz.hippogriff.hamzah.mp.ejbs.security.SecurityGroupBean;
import xyz.hippogriff.hamzah.mp.ejbs.security.SecurityUserBean;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityGroup;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityUser;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "securityUserMB")
@ViewScoped
public class SecurityUserMB implements Serializable {

    /**
     * Creates a new instance of SecurityUserMB
     */
    public SecurityUserMB() {
    }
    private List<SecurityGroup> securityGroups;
    private List<SecurityGroup> securityGroups_user;
    private List<SecurityGroup> selectedsecurityGroups;
    private List<SecurityGroup> removeSelectedsecurityGroups;
    private SecurityUser item;
    private List<SecurityUser> items;

    private boolean disableContent = false;
    private boolean inUpdate = false;
    private String pass;
    private String lastPass;

    @Inject
    private SecurityUserBean bean;
    @Inject
    private SecurityGroupBean securityGroupBean;
    @Inject
    private SecurityUserBean sub;

    public void prepareItems() {
        items = bean.findAll();
        System.out.println("t");
        System.out.println("t");
        System.out.println("t");
        System.out.println("t");
    }

    public void prepareCreate() {
        System.out.println("pc");
        item = new SecurityUser();
        item.setCreateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
        item.setCreateTime(new Date());
    }

    public void prepareProfile() {
        item = new SecurityUser();
        item = bean.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString()));
    }

    public void changePassowrd() {
        System.out.println("itempass="+item.getPassword());
        System.out.println("lastPass="+lastPass);
        System.out.println("pass="+pass);
        if (Objects.nonNull(lastPass) && Objects.nonNull(pass)) {
            System.out.println("inf first if");
            if (lastPass == null ? item.getPassword() == null : lastPass.equals(item.getPassword())) {
                System.out.println("in if");
                System.out.println("yes is last");
                item.setPassword(pass);
                System.out.println("before update");
                bean.update(item);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Updated"));
                inUpdate=false;
                System.out.println("after update");
            } else {
                System.out.println("in else");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Wrong Password"));
                return;
            }
        } else {
            System.out.println("in last else");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Wrong Password"));
            return;
        }
    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
        item.setUpdateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
        item.setCreateTime(new Date());
        securityGroups = null;
        disableContent = true;
        securityGroups_user = item.getGroups();
        securityGroups = securityGroupBean.findAll();
        securityGroups.removeAll(securityGroups_user);

        selectedsecurityGroups = null;
        removeSelectedsecurityGroups = null;
    }

    public void create() {
        bean.create(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Saved"));
        //  return "items?faces-redirect=true";
        disableContent = true;
        securityGroups_user = item.getGroups();
        securityGroups = securityGroupBean.findAll();
    }

    public void addPermissionToGroup() {
        System.out.println("heeer");
        System.out.println("item.getGroups();" + item.getGroups().size());
        System.out.println("selectedsecurityGroups.size" + selectedsecurityGroups.size());
        if (selectedsecurityGroups != null) {
            System.out.println("1");
            item.getGroups().addAll(selectedsecurityGroups);
            bean.update(item);
        }
        //
        System.out.println("2");

        securityGroups = null;
        System.out.println("3");
        disableContent = true;
        System.out.println("4");
        securityGroups_user = item.getGroups();
        System.out.println("securityGroups_user.size" + securityGroups_user.size());
        System.out.println("5");
        securityGroups = securityGroupBean.findAll();
        System.out.println("6");
        securityGroups.removeAll(securityGroups_user);
        System.out.println("7");
        selectedsecurityGroups = null;
        System.out.println("8");
        removeSelectedsecurityGroups = null;
        System.out.println("9");
    }

    public void removePermissionFromGroup() {
        System.out.println("1");
        if (removeSelectedsecurityGroups != null) {
            System.out.println("2");
            System.out.println("removeSelectedsecurityGroups.size" + removeSelectedsecurityGroups.size());
            System.out.println("bool" + item.getGroups().removeAll(removeSelectedsecurityGroups));
            bean.update(item);
//            bean.update(item);
        }
        System.out.println("3");
        securityGroups = null;
        System.out.println("4");
        disableContent = true;
        System.out.println("5");
        securityGroups_user = item.getGroups();
        System.out.println("6");
        securityGroups = securityGroupBean.findAll();
        System.out.println("7");
        securityGroups.removeAll(securityGroups_user);
        System.out.println("8");
        selectedsecurityGroups = null;
        System.out.println("9");
        removeSelectedsecurityGroups = null;
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

    public SecurityUser getItem() {
        return item;
    }

    public void setItem(SecurityUser item) {
        this.item = item;
    }

    public List<SecurityUser> getItems() {
        return items;
    }

    public void setItems(List<SecurityUser> items) {
        this.items = items;
    }

    public List<SecurityGroup> getSecurityGroups() {
        return securityGroups;
    }

    public void setSecurityGroups(List<SecurityGroup> securityGroups) {
        this.securityGroups = securityGroups;
    }

    public List<SecurityGroup> getSecurityGroups_user() {
        return securityGroups_user;
    }

    public void setSecurityGroups_user(List<SecurityGroup> securityGroups_user) {
        this.securityGroups_user = securityGroups_user;
    }

    public List<SecurityGroup> getSelectedsecurityGroups() {
        return selectedsecurityGroups;
    }

    public void setSelectedsecurityGroups(List<SecurityGroup> selectedsecurityGroups) {
        this.selectedsecurityGroups = selectedsecurityGroups;
    }

    public List<SecurityGroup> getRemoveSelectedsecurityGroups() {
        return removeSelectedsecurityGroups;
    }

    public void setRemoveSelectedsecurityGroups(List<SecurityGroup> removeSelectedsecurityGroups) {
        this.removeSelectedsecurityGroups = removeSelectedsecurityGroups;
    }

    public boolean isDisableContent() {
        return disableContent;
    }

    public void setDisableContent(boolean disableContent) {
        this.disableContent = disableContent;
    }

    public boolean isInUpdate() {
        return inUpdate;
    }

    public void setInUpdate(boolean inUpdate) {
        this.inUpdate = inUpdate;
    }

    public void changeToUpdate() {
        inUpdate = true;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLastPass() {
        return lastPass;
    }

    public void setLastPass(String lastPass) {
        this.lastPass = lastPass;
    }
}
