package cl.veterinaria.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "tipo_animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAnimal.findAll", query = "SELECT t FROM TipoAnimal t"),
    @NamedQuery(name = "TipoAnimal.findByTipoAnimalId", query = "SELECT t FROM TipoAnimal t WHERE t.tipoAnimalId = :tipoAnimalId"),
    @NamedQuery(name = "TipoAnimal.findByNombre", query = "SELECT t FROM TipoAnimal t WHERE t.nombre = :nombre")})
public class TipoAnimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_animal_id")
    private Integer tipoAnimalId;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "tipoAnimalId")
    private List<Mascota> mascotaList;

    public TipoAnimal() {
    }

    public TipoAnimal(Integer tipoAnimalId) {
        this.tipoAnimalId = tipoAnimalId;
    }

    public Integer getTipoAnimalId() {
        return tipoAnimalId;
    }

    public void setTipoAnimalId(Integer tipoAnimalId) {
        this.tipoAnimalId = tipoAnimalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (tipoAnimalId != null ? tipoAnimalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAnimal)) {
            return false;
        }
        TipoAnimal other = (TipoAnimal) object;
        if ((this.tipoAnimalId == null && other.tipoAnimalId != null) || (this.tipoAnimalId != null && !this.tipoAnimalId.equals(other.tipoAnimalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.veterinaria.entity.TipoAnimal[ tipoAnimalId=" + tipoAnimalId + " ]";
    }
    
}
