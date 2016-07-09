package cl.veterinaria.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Rodrigo
 */
@Entity
@Table(name = "dueno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dueno.findAll", query = "SELECT d FROM Dueno d"),
    @NamedQuery(name = "Dueno.findByRut", query = "SELECT d FROM Dueno d WHERE d.rut = :rut"),
    @NamedQuery(name = "Dueno.findByNombre", query = "SELECT d FROM Dueno d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Dueno.findByTelefono", query = "SELECT d FROM Dueno d WHERE d.telefono = :telefono")})
public class Dueno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut")
    private Integer rut;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private Integer telefono;
    @OneToMany(mappedBy = "duenoId")
    private List<Mascota> mascotaList;

    public Dueno() {
    }

    public Dueno(Integer rut) {
        this.rut = rut;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<Mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dueno)) {
            return false;
        }
        Dueno other = (Dueno) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.veterinaria.entity.Dueno[ rut=" + rut + " ]";
    }
    
}
