/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 60044723
 */
@Entity
@Table(name = "aportaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aportaciones.findAll", query = "SELECT a FROM Aportaciones a"),
    @NamedQuery(name = "Aportaciones.findByIdaportaciones", query = "SELECT a FROM Aportaciones a WHERE a.idaportaciones = :idaportaciones"),
    @NamedQuery(name = "Aportaciones.findByFecha", query = "SELECT a FROM Aportaciones a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Aportaciones.findByCantidad", query = "SELECT a FROM Aportaciones a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "Aportaciones.getSum", query = "SELECT sum(a.cantidad) FROM Aportaciones a WHERE a.portafolios = :portafolios and a.fecha <= :fecha")
})
public class Aportaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaportaciones")
    private Integer idaportaciones;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @JoinColumn(name = "portafolios", referencedColumnName = "idportafolios")
    @ManyToOne(optional = false)
    private Portafolios portafolios;

    public Aportaciones() {
    }

    public Aportaciones(Integer idaportaciones) {
        this.idaportaciones = idaportaciones;
    }

    public Aportaciones(Integer idaportaciones, Date fecha, double cantidad) {
        this.idaportaciones = idaportaciones;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Integer getIdaportaciones() {
        return idaportaciones;
    }

    public void setIdaportaciones(Integer idaportaciones) {
        this.idaportaciones = idaportaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Portafolios getPortafolios() {
        return portafolios;
    }

    public void setPortafolios(Portafolios portafolios) {
        this.portafolios = portafolios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaportaciones != null ? idaportaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aportaciones)) {
            return false;
        }
        Aportaciones other = (Aportaciones) object;
        if ((this.idaportaciones == null && other.idaportaciones != null) || (this.idaportaciones != null && !this.idaportaciones.equals(other.idaportaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aportaciones[ idaportaciones=" + idaportaciones + " ]";
    }
    
}
