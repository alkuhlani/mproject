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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "mp_governorate")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "MpGovernorate.findAll", query = "SELECT m FROM MpGovernorate m")
    , @NamedQuery(name = "MpGovernorate.findByCountryId", query = "SELECT m FROM MpGovernorate m WHERE m.coId.id = :id")
    , @NamedQuery(name = "MpGovernorate.findById", query = "SELECT m FROM MpGovernorate m WHERE m.id = :id")
    , @NamedQuery(name = "MpGovernorate.findByName", query = "SELECT m FROM MpGovernorate m WHERE m.name = :name")})
public class MpGovernorate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goId")
    private List<MpDirectorate> mpDirectorateList;
    @JoinColumn(name = "co_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private MpCountry coId;

    public MpGovernorate() {
    }

    public MpGovernorate(Long id) {
        this.id = id;
    }

    public MpGovernorate(Long id, String name) {
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
    public List<MpDirectorate> getMpDirectorateList() {
        return mpDirectorateList;
    }

    public void setMpDirectorateList(List<MpDirectorate> mpDirectorateList) {
        this.mpDirectorateList = mpDirectorateList;
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
        if (!(object instanceof MpGovernorate)) {
            return false;
        }
        MpGovernorate other = (MpGovernorate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.security.MpGovernorate[ id=" + id + " ]";
    }
    
}
