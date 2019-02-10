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
import java.util.Objects;
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
import xyz.hippogriff.hamzah.mp.ejbs.MpStreetBean;
import xyz.hippogriff.hamzah.mp.entities.MpCountry;
import xyz.hippogriff.hamzah.mp.entities.MpDirectorate;
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;
import xyz.hippogriff.hamzah.mp.entities.MpStreet;

/**
 *
 * @author said
 */
@Named(value = "mpStreetBM")
@ViewScoped
public class MpStreetBM implements Serializable {

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
        PrimeFaces.current().dialog().openDynamic("newStreet", options, null);
    }

    public void onItemChosen(SelectEvent event) {
        MpStreet newItem = (MpStreet) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "تم اضافة شارع جديدة",newItem.getName());
        FacesContext.getCurrentInstance().addMessage(null, message);
        items = bean.findAll();
    }

    public MpStreetBM() {
    }
    private MpStreet item;
    private List<MpStreet> items;
    private List<MpDirectorate> directorates;
    private List<MpGovernorate> governorates;
    private List<MpCountry> countries;
    private long countryId;
    private long governorateId;

    @Inject
    private MpStreetBean bean;
    @Inject
    private MpDirectorateBean directorateBean;
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
        item = new MpStreet();
        countries=countryBean.findAll();
        System.out.println("countries"+countries.size());
        System.out.println("countries"+countries.get(0).getName());
        governorates=governorateBean.findByCountryId(countries.get(0).getId());
        
        if(Objects.nonNull(governorates)){
            System.out.println("governorates"+governorates.size());
            directorates=directorateBean.findByGovId(governorates.get(0).getId());
        }
        else{
            System.out.println("governorates="+null);
            directorates=null;
        }
        item.setDirId(new MpDirectorate());
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
        directorates=directorateBean.findByGovId(governorateId);
    }
        public void GovernorateListner(){
        directorates=directorateBean.findByGovId(governorateId);
    }
    public MpStreet getItem() {
        return item;
    }

    public void setItem(MpStreet item) {
        this.item = item;
    }

    public List<MpStreet> getItems() {
        return items;
    }

    public void setItems(List<MpStreet> items) {
        this.items = items;
    }

    public List<MpDirectorate> getDirectorates() {
        return directorates;
    }

    public void setDirectorates(List<MpDirectorate> directorates) {
        this.directorates = directorates;
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

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public long getGovernorateId() {
        return governorateId;
    }

    public void setGovernorateId(long governorateId) {
        this.governorateId = governorateId;
    }

}
