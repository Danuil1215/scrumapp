/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto2.scrumapp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findById", query = "SELECT p FROM Proyecto p WHERE p.id = :id")
    , @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyecto.findByDescipcion", query = "SELECT p FROM Proyecto p WHERE p.descipcion = :descipcion")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "descipcion")
    private String descipcion;
    @OneToMany(mappedBy = "idProyecto")
    private Collection<Backlog> backlogCollection;
    @JoinColumn(name = "id_propietario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idPropietario;
    @JoinColumn(name = "scrum_master", referencedColumnName = "id")
    @ManyToOne
    private Usuario scrumMaster;

    public Proyecto() {
    }

    public Proyecto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    @XmlTransient
    public Collection<Backlog> getBacklogCollection() {
        return backlogCollection;
    }

    public void setBacklogCollection(Collection<Backlog> backlogCollection) {
        this.backlogCollection = backlogCollection;
    }

    public Usuario getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Usuario idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Usuario getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(Usuario scrumMaster) {
        this.scrumMaster = scrumMaster;
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
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto2.scrumapp.entities.Proyecto[ id=" + id + " ]";
    }
    
}
