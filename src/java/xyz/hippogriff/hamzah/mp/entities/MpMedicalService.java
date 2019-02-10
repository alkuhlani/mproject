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
@Table(name = "mp_medical_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpMedicalService.findAll", query = "SELECT m FROM MpMedicalService m")
    , @NamedQuery(name = "MpMedicalService.findById", query = "SELECT m FROM MpMedicalService m WHERE m.id = :id")
    , @NamedQuery(name = "MpMedicalService.findByName", query = "SELECT m FROM MpMedicalService m WHERE m.name = :name")})
public class MpMedicalService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "ma_id", referencedColumnName = "ID")
    @ManyToOne
    private MpMajor maId;

    public MpMedicalService() {
    }

    public MpMedicalService(Long id) {
        this.id = id;
    }

    public MpMedicalService(Long id, String name) {
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

    public MpMajor getMaId() {
        return maId;
    }

    public void setMaId(MpMajor maId) {
        this.maId = maId;
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
        if (!(object instanceof MpMedicalService)) {
            return false;
        }
        MpMedicalService other = (MpMedicalService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.security.MpMedicalService[ id=" + id + " ]";
    }
    
}
