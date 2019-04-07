<%-- 
    Document   : SaisieClasse
    Created on : 4 mars 2019, 10:00:51
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="bootstrap.css" />
         <link rel="stylesheet" type="text/css" href="cssIndex.css" /> 
        <title>  saisie classe</title>
    </head>
    <body>
          <header>      
                   <nav class="navbar navbar-expand-lg  navbar-dark bg-primary">
  <a class="navbar-brand" href="aiguillage?cmd=page5">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span> 
  </button> 

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Contact <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Navigation
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="aiguillage?cmd=page1">page Classe</a>
          <a class="dropdown-item" href="aiguillage?cmd=page2">page Prof</a>
          <a class="dropdown-item" href="SaisieClasse.jsp">saisie Classe</a>
          <a class="dropdown-item" href="SaisieProf.jsp">saisie Prof</a>
      <!--    <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a> -->
        </div>
      </li>
      <li class="nav-item">
      <!--  <a class="nav-link disabled" href="#">Contact</a> -->
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav> 
        </header>  
        <main>
        <h3>Saisie Classe</h3>
        <p class='jaune'> ${ requestScope.message }  </p>
     <form name="SaisieClasse" method="post">
         Nom de la classe : <input type="text" name="NomClasse" id="NomClasse" value="" size="50" /><br>
         <input type="submit" value="Envoi" name="BtnSubmit" />
    </form>
        </main>
     <aside></aside> 
     <footer></footer>  
    </body>
       <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="jsIndex.js"></script>
</html>
