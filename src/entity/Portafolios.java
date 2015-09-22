/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 60044723
 */
@Entity
@Table(name = "portafolios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portafolios.findAll", query = "SELECT p FROM Portafolios p"),
    @NamedQuery(name = "Portafolios.findByIdportafolios", query = "SELECT p FROM Portafolios p WHERE p.idportafolios = :idportafolios"),
    @NamedQuery(name = "Portafolios.findByNombre", query = "SELECT p FROM Portafolios p WHERE p.nombre = :valnombre"),
    @NamedQuery(name = "Portafolios.findByValorinicial", query = "SELECT p FROM Portafolios p WHERE p.valorinicial = :valorinicial"),
    @NamedQuery(name = "Portafolios.findByFechacreacion", query = "SELECT p FROM Portafolios p WHERE p.fechacreacion = :fechacreacion")})
public class Portafolios implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "portafolios")
    private List<Operaciones> operacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "protafolios")
    private Collection<Resultados> resultadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "portafolios")
    private Collection<Aportaciones> aportacionesCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idportafolios")
    private Integer idportafolios;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "valorinicial")
    private double valorinicial;
    @Basic(optional = false)
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;

    public Portafolios() {
    }

    public Portafolios(Integer idportafolios) {
        this.idportafolios = idportafolios;
    }

    public Portafolios(Integer idportafolios, String nombre, double valorinicial, Date fechacreacion) {
        this.idportafolios = idportafolios;
        this.nombre = nombre;
        this.valorinicial = valorinicial;
        this.fechacreacion = fechacreacion;
    }

    public Integer getIdportafolios() {
        return idportafolios;
    }

    public void setIdportafolios(Integer idportafolios) {
        this.idportafolios = idportafolios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(double valorinicial) {
        this.valorinicial = valorinicial;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idportafolios != null ? idportafolios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portafolios)) {
            return false;
        }
        Portafolios other = (Portafolios) object;
        if ((this.idportafolios == null && other.idportafolios != null) || (this.idportafolios != null && !this.idportafolios.equals(other.idportafolios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Portafolios[ idportafolios=" + idportafolios + " ]";
    }

    @XmlTransient
    public Collection<Aportaciones> getAportacionesCollection() {
        return aportacionesCollection;
    }

    public void setAportacionesCollection(Collection<Aportaciones> aportacionesCollection) {
        this.aportacionesCollection = aportacionesCollection;
    }

    @XmlTransient
    public Collection<Resultados> getResultadosCollection() {
        return resultadosCollection;
    }

    public void setResultadosCollection(Collection<Resultados> resultadosCollection) {
        this.resultadosCollection = resultadosCollection;
    }

    @XmlTransient
    public List<Operaciones> getOperacionesList() {
        return operacionesList;
    }

    public void setOperacionesList(List<Operaciones> operacionesList) {
        this.operacionesList = operacionesList;
    }
    
}
