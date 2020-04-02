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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "image_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageTable.findAll", query = "SELECT i FROM ImageTable i"),
    @NamedQuery(name = "ImageTable.findByIdImage", query = "SELECT i FROM ImageTable i WHERE i.idImage = :idImage"),
    @NamedQuery(name = "ImageTable.findByName", query = "SELECT i FROM ImageTable i WHERE i.name = :name"),
    @NamedQuery(name = "ImageTable.findByType", query = "SELECT i FROM ImageTable i WHERE i.type = :type")})
public class ImageTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_image")
    private Integer idImage;
    @Size(max = 1024)
    @Column(name = "name")
    private String name;
    @Size(max = 1024)
    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "pic_byte")
    private byte[] picByte;
    @OneToMany(mappedBy = "idImage")
    @JsonIgnore
    private List<Product> productList;

    public ImageTable() {
    }

    public ImageTable(Integer idImage) {
        this.idImage = idImage;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImage != null ? idImage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageTable)) {
            return false;
        }
        ImageTable other = (ImageTable) object;
        if ((this.idImage == null && other.idImage != null) || (this.idImage != null && !this.idImage.equals(other.idImage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se211.ecommerce.entity.ImageTable[ idImage=" + idImage + " ]";
    }
    
}
