/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author said
 */
@Entity
@Table(name = "mp_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpService.findAll", query = "SELECT m FROM MpService m")
    , @NamedQuery(name = "MpService.findById", query = "SELECT m FROM MpService m WHERE m.id = :id")
    , @NamedQuery(name = "MpService.findByFullName", query = "SELECT m FROM MpService m WHERE m.fullName = :fullName")
    , @NamedQuery(name = "MpService.findByDesci", query = "SELECT m FROM MpService m WHERE m.desci = :desci")
    , @NamedQuery(name = "MpService.findByInfo", query = "SELECT m FROM MpService m WHERE m.info = :info")
    , @NamedQuery(name = "MpService.findByVisitors", query = "SELECT m FROM MpService m WHERE m.visitors = :visitors")
    , @NamedQuery(name = "MpService.findByRateNo", query = "SELECT m FROM MpService m WHERE m.rateNo = :rateNo")
    , @NamedQuery(name = "MpService.findByViewes", query = "SELECT m FROM MpService m WHERE m.viewes = :viewes")
    , @NamedQuery(name = "MpService.findByCostMoney", query = "SELECT m FROM MpService m WHERE m.costMoney = :costMoney")
    , @NamedQuery(name = "MpService.findByWaitTime", query = "SELECT m FROM MpService m WHERE m.waitTime = :waitTime")
    , @NamedQuery(name = "MpService.findByStreetName", query = "SELECT m FROM MpService m WHERE m.streetName = :streetName")
    , @NamedQuery(name = "MpService.findByAddress", query = "SELECT m FROM MpService m WHERE m.address = :address")
    , @NamedQuery(name = "MpService.findByAddressMap", query = "SELECT m FROM MpService m WHERE m.addressMap = :addressMap")
    , @NamedQuery(name = "MpService.findByComobileNo", query = "SELECT m FROM MpService m WHERE m.comobileNo = :comobileNo")
    , @NamedQuery(name = "MpService.findByCophoneNo", query = "SELECT m FROM MpService m WHERE m.cophoneNo = :cophoneNo")
    , @NamedQuery(name = "MpService.findBySmFb", query = "SELECT m FROM MpService m WHERE m.smFb = :smFb")
    , @NamedQuery(name = "MpService.findBySmInstegram", query = "SELECT m FROM MpService m WHERE m.smInstegram = :smInstegram")
    , @NamedQuery(name = "MpService.findBySmTwitter", query = "SELECT m FROM MpService m WHERE m.smTwitter = :smTwitter")
    , @NamedQuery(name = "MpService.findBySmlinkedIn", query = "SELECT m FROM MpService m WHERE m.smlinkedIn = :smlinkedIn")
    , @NamedQuery(name = "MpService.findBySmWhatsapp", query = "SELECT m FROM MpService m WHERE m.smWhatsapp = :smWhatsapp")})
public class MpService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "desci")
    private String desci;
    @Column(name = "info")
    private String info;
    @Column(name = "visitors")
    private String visitors;
    @Column(name = "rateNo")
    private String rateNo;
    @Column(name = "viewes")
    private String viewes;
    @Column(name = "costMoney")
    private String costMoney;
    @Column(name = "waitTime")
    private String waitTime;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "address")
    private String address;
    @Column(name = "addressMap")
    private String addressMap;
    @Column(name = "co_mobileNo")
    private String comobileNo;
    @Column(name = "co_phoneNo")
    private String cophoneNo;
    @Column(name = "sm_fb")
    private String smFb;
    @Column(name = "sm_instegram")
    private String smInstegram;
    @Column(name = "sm_twitter")
    private String smTwitter;
    @Column(name = "sm_linkedIn")
    private String smlinkedIn;
    @Column(name = "sm_whatsapp")
    private String smWhatsapp;
    @Column(name = "services1")
    private String services1;
    @Column(name = "services2")
    private String services2;
    @JoinColumn(name = "street_id", referencedColumnName = "ID")
    @ManyToOne
    private MpStreet streetId;
    @JoinColumn(name = "directorate_id", referencedColumnName = "ID")
    @ManyToOne
    private MpDirectorate directorateId;
    @JoinColumn(name = "ge_ma_id", referencedColumnName = "ID")
    @ManyToOne
    private MpGeneralMajor geMaId;
    @JoinColumn(name = "nickname_id", referencedColumnName = "ID")
    @ManyToOne
    private MpNickname nicknameId;
    @Column(name = "gender")
    private Character gender;
    
    public MpService() {
    }

    public MpService(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesci() {
        return desci;
    }

    public void setDesci(String desci) {
        this.desci = desci;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVisitors() {
        return visitors;
    }

    public void setVisitors(String visitors) {
        this.visitors = visitors;
    }

    public String getRateNo() {
        return rateNo;
    }

    public void setRateNo(String rateNo) {
        this.rateNo = rateNo;
    }

    public String getViewes() {
        return viewes;
    }

    public void setViewes(String viewes) {
        this.viewes = viewes;
    }

    public String getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(String costMoney) {
        this.costMoney = costMoney;
    }

    public String getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(String addressMap) {
        this.addressMap = addressMap;
    }

    public String getComobileNo() {
        return comobileNo;
    }

    public void setComobileNo(String comobileNo) {
        this.comobileNo = comobileNo;
    }

    public String getCophoneNo() {
        return cophoneNo;
    }

    public void setCophoneNo(String cophoneNo) {
        this.cophoneNo = cophoneNo;
    }

    public String getSmFb() {
        return smFb;
    }

    public void setSmFb(String smFb) {
        this.smFb = smFb;
    }

    public String getSmInstegram() {
        return smInstegram;
    }

    public void setSmInstegram(String smInstegram) {
        this.smInstegram = smInstegram;
    }

    public String getSmTwitter() {
        return smTwitter;
    }

    public void setSmTwitter(String smTwitter) {
        this.smTwitter = smTwitter;
    }

    public String getSmlinkedIn() {
        return smlinkedIn;
    }

    public void setSmlinkedIn(String smlinkedIn) {
        this.smlinkedIn = smlinkedIn;
    }

    public String getSmWhatsapp() {
        return smWhatsapp;
    }

    public void setSmWhatsapp(String smWhatsapp) {
        this.smWhatsapp = smWhatsapp;
    }

    public MpStreet getStreetId() {
        return streetId;
    }

    public void setStreetId(MpStreet streetId) {
        this.streetId = streetId;
    }

    public MpDirectorate getDirectorateId() {
        return directorateId;
    }

    public void setDirectorateId(MpDirectorate directorateId) {
        this.directorateId = directorateId;
    }

    public MpGeneralMajor getGeMaId() {
        return geMaId;
    }

    public void setGeMaId(MpGeneralMajor geMaId) {
        this.geMaId = geMaId;
    }

    public MpNickname getNicknameId() {
        return nicknameId;
    }

    public void setNicknameId(MpNickname nicknameId) {
        this.nicknameId = nicknameId;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getServices1() {
        return services1;
    }

    public void setServices1(String services1) {
        this.services1 = services1;
    }

    public String getServices2() {
        return services2;
    }

    public void setServices2(String services2) {
        this.services2 = services2;
    }
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MpService)) {
            return false;
        }
        MpService other = (MpService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.security.MpService[ id=" + id + " ]";
    }
    
}
