<%-- 
    Document   : newAccount
    Created on : 5 févr. 2021, 21:28:39
    Author     : MEHEFOLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouveau compte</title>
    </head>
    <body>
        <div align="center">
            <h1>Creer un compte</h1>
        <form action="Banque" method="get">
            Nom : <input type="text" name="firstName"/><br>
            Prénom : <input type="text" name="lastName"/><br>
            Numero de compte : <input type="text" name="accountNumber"/><br>
            Solde : <input type="number" name="balance"/><br>
                <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->
            <input type="hidden" name="action" value="createAccount"/>
            <input type="submit" value="Créer le compte" name="submit"/>            
        </form>
            <a href="Banque?action=creerDonneesDeTest">Créer donnée de test</a>
            <br>
            <a href="listAccount.jsp">Voir la liste des comptes</a>
        </div>
    </body>
</html>
