/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author said
 */
@Entity
@Table(name = "mp_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpCustomer.findAll", query = "SELECT m FROM MpCustomer m")
    , @NamedQuery(name = "MpCustomer.findById", query = "SELECT m FROM MpCustomer m WHERE m.id = :id")
    , @NamedQuery(name = "MpCustomer.findByFullName", query = "SELECT m FROM MpCustomer m WHERE m.fullName = :fullName")
    , @NamedQuery(name = "MpCustomer.findByEmail", query = "SELECT m FROM MpCustomer m WHERE m.email = :email")
    , @NamedQuery(name = "MpCustomer.findByMobileNo", query = "SELECT m FROM MpCustomer m WHERE m.mobileNo = :mobileNo")
    , @NamedQuery(name = "MpCustomer.findByBirthday", query = "SELECT m FROM MpCustomer m WHERE m.birthday = :birthday")})
public class MpCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "mobileNo")
    private String mobileNo;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @JoinColumn(name = "co_id", referencedColumnName = "ID")
    @ManyToOne
    private MpCountry coId;

    public MpCustomer() {
    }

    public MpCustomer(Long id) {
        this.id = id;
    }

    public MpCustomer(Long id, String fullName, String mobileNo) {
        this.id = id;
        this.fullName = fullName;
        this.mobileNo = mobileNo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public MpCountry getCoId() {
        return coId;
    }

    public void setCoId(MpCountry coId) {
        this.coId = coId;
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
        if (!(object instanceof MpCustomer)) {
            return false;
        }
        MpCustomer other = (MpCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.security.MpCustomer[ id=" + id + " ]";
    }
    
}
