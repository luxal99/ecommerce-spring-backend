/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se211.ecommerce.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luxal
 */
@Entity
@Table(name = "client_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientAddress.findAll", query = "SELECT c FROM ClientAddress c"),
    @NamedQuery(name = "ClientAddress.findByIdClientAddress", query = "SELECT c FROM ClientAddress c WHERE c.idClientAddress = :idClientAddress"),
    @NamedQuery(name = "ClientAddress.findByCity", query = "SELECT c FROM ClientAddress c WHERE c.city = :city"),
    @NamedQuery(name = "ClientAddress.findByAddress", query = "SELECT c FROM ClientAddress c WHERE c.address = :address")})
public class ClientAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client_address")
    private Integer idClientAddress;
    @Size(max = 64)
    @Column(name = "city")
    private String city;
    @Size(max = 64)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client idClient;

    public ClientAddress() {
    }

    public ClientAddress(Integer idClientAddress) {
        this.idClientAddress = idClientAddress;
    }

    public Integer getIdClientAddress() {
        return idClientAddress;
    }

    public void setIdClientAddress(Integer idClientAddress) {
        this.idClientAddress = idClientAddress;
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

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientAddress != null ? idClientAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientAddress)) {
            return false;
        }
        ClientAddress other = (ClientAddress) object;
        if ((this.idClientAddress == null && other.idClientAddress != null) || (this.idClientAddress != null && !this.idClientAddress.equals(other.idClientAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se211.ecommerce.entity.ClientAddress[ idClientAddress=" + idClientAddress + " ]";
    }
    
}
