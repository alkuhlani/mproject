/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.mbs;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import xyz.hippogriff.hamzah.mp.ejbs.MpCountryBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpDirectorateBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpGeneralMajorBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpGovernorateBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpMajorBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpNicknameBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpServiceBean;
import xyz.hippogriff.hamzah.mp.ejbs.MpStreetBean;
import xyz.hippogriff.hamzah.mp.entities.MpCountry;
import xyz.hippogriff.hamzah.mp.entities.MpDirectorate;
import xyz.hippogriff.hamzah.mp.entities.MpGeneralMajor;
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;
import xyz.hippogriff.hamzah.mp.entities.MpMajor;
import xyz.hippogriff.hamzah.mp.entities.MpNickname;
import xyz.hippogriff.hamzah.mp.entities.MpService;
import xyz.hippogriff.hamzah.mp.entities.MpStreet;

/**
 *
 * @author said
 */
@Named(value = "mpServiceMB")
@ViewScoped
public class MpServiceMB implements Serializable {

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
        PrimeFaces.current().dialog().openDynamic("new", options, null);
    }

    public void onItemChosen(SelectEvent event) {
        MpService newItem = (MpService) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "تم اضافة خدمة جديدة", newItem.getFullName());
        FacesContext.getCurrentInstance().addMessage(null, message);
        items = bean.findAll();
    }

    public MpServiceMB() {
    }
    private MpService item;
    private List<MpService> items;
    private List<MpService> allItems;
    private List<MpStreet> streets;
    private List<MpDirectorate> directorates;
    private List<MpGeneralMajor> generalMajors;
    private List<MpMajor> majors;
    private List<MpMajor> selectedMajors;
    private List<MpNickname> nicknames;
    private List<MpCountry> countrys;
    private List<MpGovernorate> governorates;
    private long majorId;
    private long countryId;
    private long governorateId;
    private long directorateId;
    private List<String> service1;
    private List<String> service2;
    private String searchName;

    @Inject
    private MpServiceBean bean;
    @Inject
    private MpStreetBean streetBean;
    @Inject
    private MpDirectorateBean directorateBean;
    @Inject
    private MpGeneralMajorBean generalMajorBean;
    @Inject
    private MpMajorBean majorBean;
    @Inject
    private MpNicknameBean nicknameBean;
    @Inject
    private MpCountryBean countryBean;
    @Inject
    private MpGovernorateBean governorateBean;

    public void prepareItems() {
        items = bean.findAll();
    }

    public void prepareCreate() {
        item = new MpService();
        countrys = countryBean.findAll();
        generalMajors = generalMajorBean.findAll();
        nicknames = nicknameBean.findAll();
        item.setStreetId(new MpStreet());
        item.setDirectorateId(new MpDirectorate());
        item.setGeMaId(new MpGeneralMajor());
        item.setNicknameId(new MpNickname());
//        item.setCreateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
//        item.setCreateTime(new Date());

    }
    public void prepareSearch(){
        countrys = countryBean.findAll();
        countryId=countrys.get(0).getId();
        governorates=governorateBean.findByCountryId(countryId);
        
    }

    public void prepareUpdate(Long id2) {
        item = bean.find(id2);
        if (item.getServices1() != null) {
            service1 = Arrays.asList(item.getServices1().split(","));
        }
        if (item.getServices2() != null) {
            service2 = Arrays.asList(item.getServices2().split(","));
        }
//        item.setUpdateUser(sub.find(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userId").toString())));
//        item.setCreateTime(new Date());
    }

    public void create() {
        System.out.println("item.getItem_keyWords():" + service1);
        System.out.println("item.getItem_keyWords():" + service2);
        item.setServices1(service1.stream().collect(Collectors.joining(",")));
        item.setServices2(service2.stream().collect(Collectors.joining(",")));
        bean.create(item);

//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfuly Saved"));
//        prepareCreate();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "تم اضافة خدمة جديدة", item.getFullName());
        FacesContext.getCurrentInstance().addMessage(null, message);
//        PrimeFaces.current().dialog().closeDynamic(item);
        //  return "items?faces-redirect=true";
    }
    public void search(){
        System.out.println("in search");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", governorateId+"\n"+directorateId+"\n"+searchName));
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

    public void MajorListner() {
        majors = majorBean.findByGenMajId(item.getGeMaId().getId());
    }

    public void CountryListner() {
        governorates = governorateBean.findByCountryId(countryId);
        directorates = directorateBean.findByGovId(governorateId);
        streets=streetBean.findBydirId(item.getDirectorateId().getId());
    }

    public void GovernorateListner() {
        directorates = directorateBean.findByGovId(governorateId);
        streets=streetBean.findBydirId(item.getDirectorateId().getId());
    }
    public void GovernorateListnerInSearch() {
        directorates = directorateBean.findByGovId(governorateId);
    }
    public void DirectorateListner() {
        streets=streetBean.findBydirId(item.getDirectorateId().getId());
    }

    public MpService getItem() {
        return item;
    }

    public void setItem(MpService item) {
        this.item = item;
    }

    public List<MpService> getItems() {
        return items;
    }

    public void setItems(List<MpService> items) {
        this.items = items;
    }

    public List<MpStreet> getStreets() {
        return streets;
    }

    public void setStreets(List<MpStreet> streets) {
        this.streets = streets;
    }

    public List<MpDirectorate> getDirectorates() {
        return directorates;
    }

    public void setDirectorates(List<MpDirectorate> directorates) {
        this.directorates = directorates;
    }

    public List<MpGeneralMajor> getGeneralMajors() {
        return generalMajors;
    }

    public void setGeneralMajors(List<MpGeneralMajor> generalMajors) {
        this.generalMajors = generalMajors;
    }

    public List<MpNickname> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<MpNickname> nicknames) {
        this.nicknames = nicknames;
    }

    public List<MpMajor> getMajors() {
        return majors;
    }

    public void setMajors(List<MpMajor> majors) {
        this.majors = majors;
    }

    public long getMajorId() {
        return majorId;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public List<MpMajor> getSelectedMajors() {
        return selectedMajors;
    }

    public void setSelectedMajors(List<MpMajor> selectedMajors) {
        this.selectedMajors = selectedMajors;
    }

    public List<String> getService1() {
        return service1;
    }

    public void setService1(List<String> service1) {
        this.service1 = service1;
    }

    public List<String> getService2() {
        return service2;
    }

    public void setService2(List<String> service2) {
        this.service2 = service2;
    }

    public List<MpCountry> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<MpCountry> countrys) {
        this.countrys = countrys;
    }

    public List<MpGovernorate> getGovernorates() {
        return governorates;
    }

    public void setGovernorates(List<MpGovernorate> governorates) {
        this.governorates = governorates;
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

    public long getDirectorateId() {
        return directorateId;
    }

    public void setDirectorateId(long directorateId) {
        this.directorateId = directorateId;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

}
