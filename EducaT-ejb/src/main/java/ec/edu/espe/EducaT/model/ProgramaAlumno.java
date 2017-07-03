/*
 * The MIT License
 *
 * Copyright 2017 Jonathan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package ec.edu.espe.EducaT.model;

/**
* Importacion de los paquetes necesarios para el funcionamiento del sistema.
*/
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase encargada de obtener los datos de la base de datos EducaTBD.
 *
 * @author Adrián Calvopiña, Jonathan Almeida, David Suarez.
 * @version 1.0
 */

@Entity
/**
* Determinar el nombre de la entidad que de la cual se pretende obtener los datos dentro de la base de datos.
*/
@Table(name = "programa_alumno", catalog = "educat", schema = "")

public class ProgramaAlumno implements Serializable {

    /**
    * Variable que representa el numero de version que posee la clase Serializable.
    */
    private static final long serialVersionUID = 1L;      
    /**
    * Objeto de la clase ProgramaAlumnoPK.
    */
    @EmbeddedId
    protected ProgramaAlumnoPK programaAlumnoPK;    
    /**
    * Columna que corresponde al estado del estudiante con respecto a algun programa.
    * Este puede ser: inscrito (INS), matriculado (MAT), en progreso (PRO) o finalizafo (FIN).
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;      
    /**
    * Clave primaria correspondiente a la que identifica a la entidad "ALUMNO".
    */
    @JoinColumn(name = "COD_ALUMNO", referencedColumnName = "COD_ALUMNO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;    
    /**
    * Clave primaria correspondiente a la que identifica a la entidad "PROGRAMA".
    */    
    @JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Programa programa;

    /**
    * Constructor sin parametros, vacio.
    */
    public ProgramaAlumno() {
    }//Cierre del constructor.
    
    /**
    * Constructor con el parametro de programaAlumnoPK.
    * @param programaAlumnoPK variable que hace referencia a la relacion entre las entidades PROGRAMA y ALUMNO.
    */
    public ProgramaAlumno(ProgramaAlumnoPK programaAlumnoPK) {
        this.programaAlumnoPK = programaAlumnoPK;
    }//Cierre del constructor.
    
    /**
    * Constructor con los parametros de programaAlumnoPK, estado.
    * @param programaAlumnoPK variable que hace referencia a la relacion entre las entidades PROGRAMA y ALUMNO.
    * @param estado Columna que corresponde al estado del estudiante con respecto a algun programa, 
    * este puede ser: inscrito (INS), matriculado (MAT), en progreso (PRO) o finalizafo (FIN).
    */
    public ProgramaAlumno(ProgramaAlumnoPK programaAlumnoPK, String estado) {
        this.programaAlumnoPK = programaAlumnoPK;
        this.estado = estado;
    }//Cierre del constructor.

    /**
    * Constructor con los parametros de codPrograma, codAlumno.
    * @param codPrograma variable que hace referencia a la clave primaria de la entidad PROGRAMA.
    * @param codAlumno variable que hace referencia a la clave primaria de la entidad ALUMNO.
    */
    public ProgramaAlumno(String codPrograma, String codAlumno) {
        this.programaAlumnoPK = new ProgramaAlumnoPK(codPrograma, codAlumno);
    }//Cierre del constructor.

    /**
    * Metodo get para mostrar el atributo programaAlumnoPK.
    * @return programaAlumnoPK.
    */
    public ProgramaAlumnoPK getProgramaAlumnoPK() {
        return programaAlumnoPK;
    }//Cierre de metodo.
    
    /**
    * Metodo set para modificar el atributo programaAlumnoPK.
    * @param programaAlumnoPK.
    */
    public void setProgramaAlumnoPK(ProgramaAlumnoPK programaAlumnoPK) {
        this.programaAlumnoPK = programaAlumnoPK;
    }//Cierre de metodo.

    /**
    * Metodo get para mostrar el atributo estado.
    * @return estado.
    */
    public String getEstado() {
        return estado;
    }//Cierre de metodo.

    /**
    * Metodo set para modificar el atributo estado.
    * @param estado.
    */
    public void setEstado(String estado) {
        this.estado = estado;
    }//Cierre de metodo.

    /**
    * Metodo get para mostrar el atributo alumno.
    * @return alumno.
    */
    public Alumno getAlumno() {
        return alumno;
    }//Cierre de metodo.
    
    /**
    * Metodo set para modificar el atributo alumno.
    * @param alumno.
    */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }//Cierre de metodo.

    /**
    * Metodo get para mostrar el atributo programa.
    * @return alumno.
    */
    public Programa getPrograma() {
        return programa;
    }//Cierre de metodo.

    /**
    * Metodo set para modificar el atributo programa.
    * @param alumno.
    */
    public void setPrograma(Programa programa) {
        this.programa = programa;
    }//Cierre de metodo.
    
    /**
    * Metodo hasCode sobreescrito.
    * @return hash.
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaAlumnoPK != null ? programaAlumnoPK.hashCode() : 0);
        return hash;
    }//Cierre de metodo.
        
    /**
    * Metodo sobreescrito equals.
    * @param object.
    * @return boolen.
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaAlumno)) {
            return false;
        }
        ProgramaAlumno other = (ProgramaAlumno) object;
        if ((this.programaAlumnoPK == null && other.programaAlumnoPK != null) || (this.programaAlumnoPK != null && !this.programaAlumnoPK.equals(other.programaAlumnoPK))) {
            return false;
        }
        return true;
    }//Cierre de metodo.
    
    /**
    * Metodo sobreescrito toString.
    * @return cadena de caracteres.
    */
    @Override
    public String toString() {
        return "ec.edu.espe.EducaT.ProgramaAlumno[ programaAlumnoPK=" + programaAlumnoPK + " ]";
    }//Cierre de metodo.
    
}//Cierre de la clase.