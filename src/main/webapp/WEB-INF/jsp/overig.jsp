<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Stadsspel2016</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/stadsspel.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Stadspel 2016</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#"><span class="glyphicon glyphicon-sort-by-order" aria-hidden="true"></span> Scores</a></li>
            <li><a href="/events"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Berichten</a></li>
            <li><a href="/locations"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> Lokaties</a></li>
            <li class="active"><a href="/overig"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"> Overig</a></li>

          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
      <h2><span class="glyphicon glyphicon-info-sign" aria-hidden="true"> Overige</h2>
      <h3>Spelregels in het kort</h3>
      <p>Op de kaart zie je de mogelijke lokaties die je kan claimen. Als je op een lokatie bent aangekomen neem via whatsapp contact op met de spelleiding,
      de spelleiding kan vragen om aanvullend bewijs dat je op de locatie bent. Bijvoorbeeld een foto van de lokatie en je team genoten.</p>
      <p>Op een lokatie zijn er verschillende mogelijkheden, als de lokatie al geclaimed is door een andere groep betaal je en bedrag om daar te mogen zijn.
      Als de lokatie nog niet geclaimed krijg je dat van de spel leiding te horen eventueel met een aanvullende opdracht om de lokatie te claimen.
      Als er geen opdracht is of je voert de opdracht goed uit is de lokatie van jullie. Gefeliciteerd!</p>
      <h3>Tips<h3>
      <ul>
        <li>Als je gezien wordt vlak bij een lokatie is de kans groot dat het andere groepje die lokatie overslaat!</li>
      </ul>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

