/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author said
 */
@Entity
@Table(name = "mp_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpCountry.findAll", query = "SELECT m FROM MpCountry m")
    , @NamedQuery(name = "MpCountry.findById", query = "SELECT m FROM MpCountry m WHERE m.id = :id")
    , @NamedQuery(name = "MpCountry.findByName", query = "SELECT m FROM MpCountry m WHERE m.name = :name")})
public class MpCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "coId")
    private List<MpCustomer> mpCustomerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coId")
    private List<MpGovernorate> mpGovernorateList;

    public MpCountry() {
    }

    public MpCountry(Long id) {
        this.id = id;
    }

    public MpCountry(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<MpCustomer> getMpCustomerList() {
        return mpCustomerList;
    }

    public void setMpCustomerList(List<MpCustomer> mpCustomerList) {
        this.mpCustomerList = mpCustomerList;
    }

    @XmlTransient
    public List<MpGovernorate> getMpGovernorateList() {
        return mpGovernorateList;
    }

    public void setMpGovernorateList(List<MpGovernorate> mpGovernorateList) {
        this.mpGovernorateList = mpGovernorateList;
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
        if (!(object instanceof MpCountry)) {
            return false;
        }
        MpCountry other = (MpCountry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.security.MpCountry[ id=" + id + " ]";
    }
    
}
