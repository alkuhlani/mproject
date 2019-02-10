/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author said
 */
@Entity
@Table(name = "mp_major")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpMajor.findAll", query = "SELECT m FROM MpMajor m")
    , @NamedQuery(name = "MpMajor.findById", query = "SELECT m FROM MpMajor m WHERE m.id = :id")
    , @NamedQuery(name = "MpMajor.findByGenMajId", query = "SELECT m FROM MpMajor m WHERE m.geMaId.id = :id")
    , @NamedQuery(name = "MpMajor.findByName", query = "SELECT m FROM MpMajor m WHERE m.name = :name")})
public class MpMajor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "maId")
    private List<MpMedicalService> mpMedicalServiceList;
    @JoinColumn(name = "ge_ma_id", referencedColumnName = "ID")
    @ManyToOne
    private MpGeneralMajor geMaId;

    public MpMajor() {
    }

    public MpMajor(Long id) {
        this.id = id;
    }

    public MpMajor(Long id, String name) {
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
    public List<MpMedicalService> getMpMedicalServiceList() {
        return mpMedicalServiceList;
    }

    public void setMpMedicalServiceList(List<MpMedicalService> mpMedicalServiceList) {
        this.mpMedicalServiceList = mpMedicalServiceList;
    }

    public MpGeneralMajor getGeMaId() {
        return geMaId;
    }

    public void setGeMaId(MpGeneralMajor geMaId) {
        this.geMaId = geMaId;
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
        if (!(object instanceof MpMajor)) {
            return false;
        }
        MpMajor other = (MpMajor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.security.MpMajor[ id=" + id + " ]";
    }
    
}
