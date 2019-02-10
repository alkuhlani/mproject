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
import xyz.hippogriff.hamzah.mp.entities.MpCountry;
import xyz.hippogriff.hamzah.mp.entities.MpGeneralMajor;

/**
 *
 * @author said
 */
@Named(value = "mpGeneralMajorMB")
@ViewScoped
public class MpGeneralMajorMB implements Serializable {

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
        PrimeFaces.current().dialog().openDynamic("newGeneralMajor", options, null);
    }

    public void onItemChosen(SelectEvent event) {
        MpGeneralMajor newItem = (MpGeneralMajor) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "تم اضافة تخصص رئيسي جديد",newItem.getName());
        FacesContext.getCurrentInstance().addMessage(null, message);
        items = bean.findAll();
    }

    public MpGeneralMajorMB() {
    }
    private MpGeneralMajor item;
    private List<MpGeneralMajor> items;

    @Inject
    private MpGeneralMajorBean bean;
//    @Inject
//    private SecurityUserBean sub;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new MpGeneralMajor();
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

    public MpGeneralMajor getItem() {
        return item;
    }

    public void setItem(MpGeneralMajor item) {
        this.item = item;
    }

    public List<MpGeneralMajor> getItems() {
        return items;
    }

    public void setItems(List<MpGeneralMajor> items) {
        this.items = items;
    }

    

}
