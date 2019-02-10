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
import xyz.hippogriff.hamzah.mp.ejbs.MpDirectorateBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpGovernorateBean;
import xyz.hippogriff.hamzah.mp.entities.MpCountry;
import xyz.hippogriff.hamzah.mp.entities.MpDirectorate;
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;

/**
 *
 * @author said
 */
@Named(value = "mpDirectorateMB")
@ViewScoped
public class MpDirectorateMB implements Serializable {

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
        PrimeFaces.current().dialog().openDynamic("newDirectorate", options, null);
    }

    public void onItemChosen(SelectEvent event) {
        MpDirectorate newItem = (MpDirectorate) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "تم اضافة مديرية جديدة",newItem.getName());
        FacesContext.getCurrentInstance().addMessage(null, message);
        items = bean.findAll();
    }

    public MpDirectorateMB() {
    }
    private MpDirectorate item;
    private List<MpDirectorate> items;
    private List<MpGovernorate> governorates;
    private List<MpCountry> countries;
    private long countryId;

    @Inject
    private MpDirectorateBean bean;
    @Inject
    private MpGovernorateBean governorateBean;
    @Inject
    private MpCountryBean countryBean;
//    @Inject
//    private SecurityUserBean sub;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new MpDirectorate();
        countries=countryBean.findAll();
        governorates=governorateBean.findByCountryId(countries.get(0).getId());
        item.setGoId(new MpGovernorate());
        
        
        
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
    public void CountryListner(){
        governorates=governorateBean.findByCountryId(countryId);
    }

    public MpDirectorate getItem() {
        return item;
    }

    public void setItem(MpDirectorate item) {
        this.item = item;
    }

    public List<MpDirectorate> getItems() {
        return items;
    }

    public void setItems(List<MpDirectorate> items) {
        this.items = items;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public List<MpGovernorate> getGovernorates() {
        return governorates;
    }

    public void setGovernorates(List<MpGovernorate> governorates) {
        this.governorates = governorates;
    }

    public List<MpCountry> getCountries() {
        return countries;
    }

    public void setCountries(List<MpCountry> countries) {
        this.countries = countries;
    }

}
