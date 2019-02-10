/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.mbs;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import xyz.hippogriff.hamzah.mp.ejbs.MpGeneralMajorBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpMajorBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpNicknameBean;
import xyz.hippogriff.hamzah.mp.entities.MpGeneralMajor;
import xyz.hippogriff.hamzah.mp.entities.MpMajor;
import xyz.hippogriff.hamzah.mp.entities.MpNickname;

/**
 *
 * @author said
 */
@Named(value = "mpNicknameMB")
@ViewScoped
public class MpNicknameMB implements Serializable {

    /**
     * Creates a new instance of SecurityPermissionMB
     */
    public void chooseItem() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("closeOnEscape", true);
        options.put("dir", "rtl");
        PrimeFaces.current().dialog().openDynamic("newMajor", options, null);
    }

    public void onItemChosen(SelectEvent event) {
        MpMajor newItem = (MpMajor) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "تم اضافة تخصص فرعي جديد",newItem.getName());
        FacesContext.getCurrentInstance().addMessage(null, message);
        items = bean.findAll();
    }

    public MpNicknameMB() {
    }
    private MpNickname item;
    private List<MpNickname> items;

    @Inject
    private MpNicknameBean bean;
    
//    @Inject
//    private SecurityUserBean sub;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new MpNickname();
//        item.setCreateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
//        item.setCreateTime(new Date());

    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
//        item.setUpdateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
//        item.setCreateTime(new Date());
    }

    public void create() {
        bean.create(item);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Saved"));
//        prepareCreate();
        PrimeFaces.current().dialog().closeDynamic(item);
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

    public MpNickname getItem() {
        return item;
    }

    public void setItem(MpNickname item) {
        this.item = item;
    }

    public List<MpNickname> getItems() {
        return items;
    }

    public void setItems(List<MpNickname> items) {
        this.items = items;
    }

}
