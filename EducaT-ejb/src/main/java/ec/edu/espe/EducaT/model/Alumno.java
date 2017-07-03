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
/**
* Determinar el nombre de la entidad que de la cual se pretende obtener los datos dentro de la base de datos.
*/
@Table(name = "alumno", catalog = "educat", schema = "")
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
    * Clave primaria que corresponde a la cédula de identidad del estudiante.
    */
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_ALUMNO")
    private String codAlumno;
    /**
    * Columna que corresponde al nombre y apellido del estudiante.
    */ 
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE")
    private String nombre;
    /**
    * Columna que corresponde a la direccion de la vivienda del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DIRECCION")
    private String direccion;
    /**
    * Columna que corresponde al telefono, ya sea el movil o el de casa, del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONO")
    private String telefono;    
    /**
    * Columna correspondiente al correo electronico del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    /**
    * Columna correspondiente a la fecha de nacimiento del estudiante.
    */
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    /**
    * Columna correspondiente al genero del estudiante, este puede ser masculino (M), femenino (F) u otros (O).
    */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GENERO")
    private String genero;
    /**
    * Indica la relacion de uno a varios que existe entre la entidad ALUMNO y CAPACITACION. 
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<CapacitacionAlumno> capacitacionAlumnoList;
    /**
    * Indica la relacion de uno a varios que existe entre la entidad ALUMNO y CAPACITACION. 
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<ProgramaAlumno> programaAlumnoList;

    /**
    * Constructor sin parametros, vacio.
    */
    public Alumno() {
    }//Cierre del constructor.
    
    /**
    * Constructor con el parametro de codAlumno.
    * @param codAlumno variable que hace referencia a la columna codAlumno de la entidad ALUMNO.
    */
    public Alumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }//Cierre del constructor.

    /**
    * Constructor con varios parametros.
    * @param codAlumno variable que hace referencia a la columna codAlumno de la entidad ALUMNO.
    * @param nombre variable que hace referencia a la columna nombre de la entidad ALUMNO.
    * @param direccion variable que hace referencia a la columna direccion de la entidad ALUMNO.
    * @param telefono variable que hace referencia a la columna telefono de la entidad ALUMNO.
    * @param correoElectronico variable que hace referencia a la columna correoElectronico de la entidad ALUMNO.
    * @param fechaNacimiento variable que hace referencia a la columna fechaNacimiento de la entidad ALUMNO.
    * @param genero variable que hace referencia a la columna genero de la entidad ALUMNO.
    */
    public Alumno(String codAlumno, String nombre, String direccion, String telefono, String correoElectronico, Date fechaNacimiento, String genero) {
        this.codAlumno = codAlumno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }//Cierre del constructor.

    /**
    * Metodo get para mostrar el atributo codAlumno.
    * @return codAlumno.
    */
    public String getCodAlumno() {
        return codAlumno;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo codAlumno.
    * @param codAlumno.
    */
    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }//Cierre del metodo.

    /**
    * Metodo get para mostrar el atributo nombre.    
    * @return nombre;
    */
    public String getNombre() {
        return nombre;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo nombre.
    * @param nombre.
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//Cierre del metodo.

    /**
    * Metodo get para mostrar el atributo direccion.
    * @return direccion.
    */
    public String getDireccion() {
        return direccion;
    }//Cierre del metodo.

    /**
    * Metodo set para modificar el atributo direccion.
    * @param direccion.
    */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }//Cierre del metodo.

    /**
    * Metodo get para mostrar el atributo telefono.
    * @return telefono.
    */
    public String getTelefono() {
        return telefono;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo telefono.
    * @param telefono.
    */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }//Cierre del metodo.

    /**
    * Metodo get para mostrar el atributo correoElectronico.
    * @return correoElectronico.
    */
    public String getCorreoElectronico() {
        return correoElectronico;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo correoElectronico.
    * @param correoElectronico.
    */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }//Cierre del metodo.

    /**
    * Metodo get para mostrar el atributo fechaNacimiento.
    * @return fechaNacimiento.
    */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }//Cierre del metodo.

    /**
    * Metodo set para modificar el atributo fechaNacimiento.
    * @param fechaNacimiento.
    */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }//Cierre del metodo.
    
    /**
    * Metodo get para mostrar el atributo genero.
    * @return genero.
    */
    public String getGenero() {
        return genero;
    }//Cierre del metodo.
    
    /**
    * Metodo set para modificar el atributo genero.
    * @param genero.
    */
    public void setGenero(String genero) {
        this.genero = genero;
    }//Cierre del metodo.

    /**
    * Metodo get para mostrar el atributo capacitacionAlumnoCollection.
    * @return capacitacionAlumnoList.
    */
    public List<CapacitacionAlumno> getCapacitacionAlumnoList() {
        return capacitacionAlumnoList;
    }//Cierre del metodo.

    /**
    * Metodo set para modificar el atributo capacitacionAlumnoCollection.
    * @param capacitacionAlumnoList
    */
    public void setCapacitacionAlumnoList(List<CapacitacionAlumno> capacitacionAlumnoList) {
        this.capacitacionAlumnoList = capacitacionAlumnoList;
    }//Cierre del metodo.

    /**
    * Metodo get para mostrar el atributo programaAlumnoCollection.    
    * @return programaAlumnoList.
    */
    public List<ProgramaAlumno> getProgramaAlumnoList() {
        return programaAlumnoList;
    }//Cierre del metodo.

    /**
    * Metodo set para modificar el atributo programaAlumnoCollection.
    * @param programaAlumnoList.
    */
    public void setProgramaAlumnoList(List<ProgramaAlumno> programaAlumnoList) {
        this.programaAlumnoList = programaAlumnoList;
    }//Cierre del metodo.
    
    /**
    * Metodo hasCode sobreescrito.
    * @return hash.
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }//Cierre del metodo.

    /**
    * Metodo sobreescrito equals.
    * @param object.
    * @return boolen.
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }//Cierre del metodo.

    /**
    * Metodo sobreescrito toString.
    * @return cadena de caracteres.
    */
    @Override
    public String toString() {
        return "ec.edu.espe.EducaT.model.Alumno[ codAlumno=" + codAlumno + " ]";
    }//Cierre del metodo.
}//Cierre de la clase.
