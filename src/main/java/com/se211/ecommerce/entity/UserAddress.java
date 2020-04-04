/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se211.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luxal
 */
@Entity
@Table(name = "user_address")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_address")
    private Integer idUserAddress;
    @Size(max = 64)
    @Column(name = "city")
    private String city;
    @Size(max = 64)
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "idUserAddress")
    @JsonIgnore
    private List<Client> clientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserAddress")
    @JsonIgnore
    private List<Company> companyList;

    public UserAddress() {
    }

    public UserAddress(Integer idUserAddress) {
        this.idUserAddress = idUserAddress;
    }

    public Integer getIdUserAddress() {
        return idUserAddress;
    }

    public void setIdUserAddress(Integer idUserAddress) {
        this.idUserAddress = idUserAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @XmlTransient
    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserAddress != null ? idUserAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAddress)) {
            return false;
        }
        UserAddress other = (UserAddress) object;
        if ((this.idUserAddress == null && other.idUserAddress != null) || (this.idUserAddress != null && !this.idUserAddress.equals(other.idUserAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se211.ecommerce.entity.UserAddress[ idUserAddress=" + idUserAddress + " ]";
    }
    
}
