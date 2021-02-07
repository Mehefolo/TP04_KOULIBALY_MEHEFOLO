<%-- 
    Document   : listAccount
    Created on : 5 févr. 2021, 21:29:06
    Author     : MEHEFOLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulter les comptes</title>
    </head>
    <body>
        <div align="center">
            <h1>LISTE DES COMPTES</h1>
            
            <c:if test="${param['action'] == 'listeAccount'}" >
            
            
  
            <ul>
                <li><a href="Banque?action=listeAccount">Afficher/raffraichir la liste de tous les comptes</a></li>
                <p>
            </ul>

            <table border="10">
                <!-- La ligne de titre du tableau des comptes -->
                <tr>
                    <td><b>Nom</b></td>
                    <td><b>Prenom</b></td>
                    <td><b>Numero de compte</b></td>
                    <td><b>Solde</b></td>
                </tr>

                <!-- Ici on affiche les lignes, une par utilisateur -->
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->
                <c:set var="total" value="0"/>

                <c:forEach var="c" items="${requestScope['listeDesComptes']}">
                    <tr>
                        <td>${c.firstName}</td>
                        <td>${c.lastName}</td>
                        <td>${c.accountNumber}</td>
                        <td>${c.balance}</td>
                        <!-- On compte le nombre de users -->
                        <c:set var="total" value="${total+1}"/>
                    </tr>
                </c:forEach>

                <!-- Affichage du solde total dans la dernière ligne du tableau -->
                <tr><td><b>TOTAL</b></td><td></td><td><b>${total}</b></td><td></td></tr>
            </table>
            <br>
            <br>
            
        </c:if>
            <br>
            <br>
            <a href="newAccount.jsp">Enregistrer un nouveau compte</a>
        </div>
    </body>
</html>
