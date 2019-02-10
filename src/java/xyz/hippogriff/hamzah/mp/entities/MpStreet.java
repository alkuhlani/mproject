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
@Table(name = "mp_street")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpStreet.findAll", query = "SELECT m FROM MpStreet m")
    , @NamedQuery(name = "MpStreet.findBydirId", query = "SELECT m FROM MpStreet m WHERE m.dirId.id = :id")
    , @NamedQuery(name = "MpStreet.findById", query = "SELECT m FROM MpStreet m WHERE m.id = :id")
    , @NamedQuery(name = "MpStreet.findByName", query = "SELECT m FROM MpStreet m WHERE m.name = :name")})
public class MpStreet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "streetId")
    private List<MpService> mpServiceList;
    @JoinColumn(name = "dir_id", referencedColumnName = "ID")
    @ManyToOne
    private MpDirectorate dirId;

    public MpStreet() {
    }

    public MpStreet(Long id) {
        this.id = id;
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
    public List<MpService> getMpServiceList() {
        return mpServiceList;
    }

    public void setMpServiceList(List<MpService> mpServiceList) {
        this.mpServiceList = mpServiceList;
    }

    public MpDirectorate getDirId() {
        return dirId;
    }

    public void setDirId(MpDirectorate dirId) {
        this.dirId = dirId;
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
        if (!(object instanceof MpStreet)) {
            return false;
        }
        MpStreet other = (MpStreet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.security.MpStreet[ id=" + id + " ]";
    }
    
}
