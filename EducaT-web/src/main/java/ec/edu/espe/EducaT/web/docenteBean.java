/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
package ec.edu.espe.EducaT.web;

import ec.edu.espe.EducaT.model.Docente;
import ec.edu.espe.EducaT.service.DocenteService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class docenteBean {
    
    @EJB
    private DocenteService docenteService;    
    
    private List<Docente> docente;
    
    @PostConstruct
    public void inicio(){
       this.docente = this.docenteService.ListaDocentes();
    }

    public List<Docente> getDocente() {
        return docente;
    }
    
    
}
