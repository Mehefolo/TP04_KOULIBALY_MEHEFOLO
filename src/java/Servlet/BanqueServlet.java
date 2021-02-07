/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import GestionnaireCompteBancaire.GestionnaireDeCompte;
import banque.CompteBancaire;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MEHEFOLO
 * 
 */
    

@WebServlet(name = "BanqueServlet",
     urlPatterns = {"/Banque"}    
)

public class BanqueServlet extends HttpServlet {
    
    @EJB
    private GestionnaireDeCompte gestionnaireDeCompte;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";

        if (action != null) {
            switch (action) {
                case "listeAccount":
                    {
                        Collection<CompteBancaire> liste = gestionnaireDeCompte.getAllComptesBancaires();
                        request.setAttribute("listeDesComptes", liste);
                        forwardTo = "listAccount.jsp?action=listeAccount";
                        message = "Liste des Comptes";
                        break;
                    }
                case "createAccount":
                    {
                        creerCompteBancaire(request);
                        Collection<CompteBancaire> liste = gestionnaireDeCompte.getAllComptesBancaires();
                        request.setAttribute("listeDesComptes", liste);
                        forwardTo = "listAccount.jsp?action=listeAccount";
                        message = "Liste des Comptes";
                        break;
                    }
                case "creerDonneesDeTest":
                    {
                        gestionnaireDeCompte.creerDonneesDeTest();
                        Collection<CompteBancaire> liste = gestionnaireDeCompte.getAllComptesBancaires();
                        request.setAttribute("listeDesComptes", liste);
                        forwardTo = "listAccount.jsp?action=listeAccount";
                        message = "Liste des Comptes";
                        break;
                    }
                default:
                    forwardTo = "newAccount.jsp?action=todo";
                    message = "La fonctionnalité pour le paramètre " + action + " est à été implémenter !";
                    break;
            }
        }
        
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
        dp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void creerCompteBancaire(HttpServletRequest request){
       String nom,prenom,compte;
       String solde; double balance;
       nom=request.getParameter("firstName");
       prenom=request.getParameter("lastName");
       compte=request.getParameter("accountNumber");
       solde=request.getParameter("balance");
       balance=Double.valueOf(solde);
       gestionnaireDeCompte.creerUnCompte(nom,prenom,compte,balance);
       
       
   }
}
