/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionnaireCompteBancaire;

import banque.CompteBancaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author MEHEFOLO
 */
@Stateless
public class GestionnaireDeCompte {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
    public void creerDonneesDeTest() {
        creerUnCompte("Koulibaly","mehefolo", "2253326", 150000000);
        creerUnCompte("yede","eunice", "1255463", 1200053);
        creerUnCompte("koffi","Axel", "955741", 16220000);
        creerUnCompte("youan","toussaint", "2331566", 16022000);
    }
    
    public CompteBancaire creerUnCompte(String firstName, String lastName, String accountNumber, double balance) {
        CompteBancaire c = new CompteBancaire(firstName, lastName,accountNumber,balance);
        em.persist(c);
        return c;
    }
    
    public List<CompteBancaire> getAllComptesBancaires() {
       
        Query q = em.createQuery("select c from CompteBancaire c ");
        
        return q.getResultList();
    }

   
  
    
}
