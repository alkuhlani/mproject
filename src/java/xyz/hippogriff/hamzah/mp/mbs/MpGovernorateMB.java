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
import xyz.hippogriff.hamzah.mp.ejbs.MpCountryBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpGovernorateBean;
import xyz.hippogriff.hamzah.mp.entities.MpCountry;
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;

/**
 *
 * @author said
 */
@Named(value = "mpGovernorateMB")
@ViewScoped
public class MpGovernorateMB implements Serializable {

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
        PrimeFaces.current().dialog().openDynamic("newGovernorate", options, null);
    }

    public void onItemChosen(SelectEvent event) {
        MpGovernorate newItem = (MpGovernorate) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "تم اضافة محافظة جديدة",newItem.getName());
        FacesContext.getCurrentInstance().addMessage(null, message);
        items = bean.findAll();
    }

    public MpGovernorateMB() {
    }
    private MpGovernorate item;
    private List<MpGovernorate> items;
    private List<MpCountry> countries;

    @Inject
    private MpGovernorateBean bean;
    @Inject
    private MpCountryBean countryBean;
//    @Inject
//    private SecurityUserBean sub;

    public void prepareItems() {
        items = bean.findAll();
        
    }

    public void prepareCreate() {
        item = new MpGovernorate();
        countries=countryBean.findAll();
        item.setCoId(new MpCountry());
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

    public MpGovernorate getItem() {
        return item;
    }

    public void setItem(MpGovernorate item) {
        this.item = item;
    }

    public List<MpGovernorate> getItems() {
        return items;
    }

    public void setItems(List<MpGovernorate> items) {
        this.items = items;
    }

    public List<MpCountry> getCountries() {
        return countries;
    }

    public void setCountries(List<MpCountry> countries) {
        this.countries = countries;
    }

    
}
