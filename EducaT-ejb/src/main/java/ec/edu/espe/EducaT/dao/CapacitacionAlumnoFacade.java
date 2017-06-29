/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.EducaT.dao;

import ec.edu.espe.EducaT.model.CapacitacionAlumno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER
 */
@Stateless
public class CapacitacionAlumnoFacade extends AbstractFacade<CapacitacionAlumno> {
    @PersistenceContext(unitName = "EducaT_EducaT-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacitacionAlumnoFacade() {
        super(CapacitacionAlumno.class);
    }
    
}
