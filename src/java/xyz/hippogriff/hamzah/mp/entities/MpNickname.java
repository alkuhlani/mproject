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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author said
 */
@Entity
@Table(name = "mp_nickname")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MpNickname.findAll", query = "SELECT m FROM MpNickname m")
    , @NamedQuery(name = "MpNickname.findById", query = "SELECT m FROM MpNickname m WHERE m.id = :id")
    , @NamedQuery(name = "MpNickname.findByName", query = "SELECT m FROM MpNickname m WHERE m.name = :name")})
public class MpNickname implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "nicknameId")
    private List<MpService> mpServices;

    public MpNickname() {
    }

    public MpNickname(Long id) {
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

    public List<MpService> getMpServices() {
        return mpServices;
    }

    public void setMpServices(List<MpService> mpServices) {
        this.mpServices = mpServices;
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
        if (!(object instanceof MpNickname)) {
            return false;
        }
        MpNickname other = (MpNickname) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "xyz.hippogriff.hamzah.mp.entities.MpNickname[ id=" + id + " ]";
    }
    
}
