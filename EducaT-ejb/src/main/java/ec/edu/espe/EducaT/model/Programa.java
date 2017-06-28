/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.EducaT.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase encargada de obtener los datos de la base de datos EducaTBD.
 *
 * @author Adrián Calvopiña, Jonathan Almeida, David Suarez.
 * @version 1.0
 */
@Entity
@Table(name = "programa", catalog = "educat", schema = "")
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_PROGRAMA")
    /**
     * Clave primaria que identifica al programa.
     */
    private String codPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    /**
     * Es el nombre que recibe el programa por los temas que llega a tratar.
     */
    private String nombre;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION")
    /**
     * Es la descripción que tiene ese curso de una manera mucho más específica.
     */
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    /**
     * Es el número de días que dura cada uno de los programas.
     */
    private short duracion;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    /**
     * Fecha en la que se tiene previsto empezar el programa.
     */
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    /**
     * Fecha en la que se tiene previsto finalizar el programa.
     */
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    /**
     * Lista de programas.
     */
    private List<ProgramaCurso> programaCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    /**
     * Lista de las relaciones que existe entre los alumnos y los programas.
     */
    private List<ProgramaAlumno> programaAlumnoList;

    public Programa() {
    }

    public Programa(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    public Programa(String codPrograma, String nombre, short duracion) {
        this.codPrograma = codPrograma;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<ProgramaCurso> getProgramaCursoList() {
        return programaCursoList;
    }

    public void setProgramaCursoList(List<ProgramaCurso> programaCursoList) {
        this.programaCursoList = programaCursoList;
    }

    public List<ProgramaAlumno> getProgramaAlumnoList() {
        return programaAlumnoList;
    }

    public void setProgramaAlumnoList(List<ProgramaAlumno> programaAlumnoList) {
        this.programaAlumnoList = programaAlumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrograma != null ? codPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.codPrograma == null && other.codPrograma != null) || (this.codPrograma != null && !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.EducaT.model.Programa[ codPrograma=" + codPrograma + " ]";
    }
    
}
