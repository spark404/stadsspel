<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            <li><a href="/"><span class="glyphicon glyphicon-sort-by-order" aria-hidden="true"></span> Scores</a></li>
            <li><a href="/events"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Berichten</a></li>
            <li><a href="/locations"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> Lokaties</a></li>
            <li class="active"><a href="/overig"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Spelregels</a></li>

          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
      <h2><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Spelregels</h2>
      <h3>Spelregels in het kort</h3>
       <p>Het doel van dit spel is zoveel mogelijk geld te verdienen. Je kan geld verdienen door straten te claimen en door te zorgen dat andere groepen
       ook op jouw straten terecht komen. De regels zijn afgeleid van het bekende monopoly, maar dan toch weer een beetje anders.
       Hieronder vind je de belangrijkste regels. Bij twijfel over een regel kan je altijd contact opnemen met de spelleiding.</p>

       <p>Bij de start van het spel krijg je een kaart, (Als je nu een stuk papaier in handen hebt, kijk even op de andere kant.)
       Op de kaart zie je de mogelijke straten staan die je kan claimen. De straten zijn gegroepeerd in locaties vernoemd naar locaties
       van een bekend evenement in Houten. Elke straat heeft ook een bedrag, dit bedrag krijg je als je de straat claimt.</p>

       <p>Om een straat te claimen moet je fysiek naar het punt toe dat op de kaart staat aangegeven. Als je denkt dat je dichtbij genoeg bent om de straat te kunnen claimen neem je contact op met de spelleiding:<p>
       <ol>
        <li>De spelleiding kan vragen om aanvullend bewijs dat je op de straat bent. Bijvoorbeeld een foto van die lokatie (in veel gevallen is dat een gedicht of een bord van Kwink kinderopvang).</li>
        <li>Als de straat nog niet geclaimed is krijg je van de spelleiding een opdracht, een vraagt of een kanskaart.</li>
         <ol>
           <li>Als je de opdracht goed uitvoert is de straat van jullie. Gefeliciteerd!</li>
           <li>Als je de vraag goed beantwoordt is de straat van jullie, Gefeliciteerd!</li>
           <li>Als je en kanskaart krijgt moet je maar afwachten, we hebben zowel positieve als negatieve kanskaarten.</li>
         </ol>
         <li>Als de straat al geclaimed is door een andere groep betaal je een bedrag om daar te zijn aan die groep. Heeft de andere groep de hele locatie in bezit betaal je dubbel!</li>
         </ol>

      <p>Je kan een locatie niet twee keer achter elkaar "proberen", lukt het niet om in één keer de straat te claimen dan moet je eerst een andere straat bezoeken voor je het nog een keer kan proberen.</p>

        <p>Om een lokatie compleet te maken mag je straten met andere groepen ruilen. Dit doe je eenvoudig weg door een berichtje te sturen van de ruil naar de spelleiding samen met een
        foto waar beide groepen compleet op staan en elkaar de handen schudden.</p>

        <p>Een actueel score overzicht is via internet op te vragen op de website http://city.strocamp.net. Wij werken dit bij met de berichten die we ontvangen van de groepjes en hier kan je
        zelf zien wat je huidige score is, welke straten je geclaimed hebt en/of andere groepn jouw straten hebben bezocht. Hiervoor is wel een teamcode nodig, deze code krijg je bij de
        voorbereiding van het spel en kan je op de berichten pagina invoeren.</p>

        <p>De winaar is het groepje dat om 16:00 nederlandse zomertijd met de hoogste score bij de spelleiding staat.</p>

        <p>Let op, hou regelmatig contact met de spelleiding om te voorkomen dat je een boete krijgt voor onachtzaamheid!</p>

        <p>De spelleiding is bereikbaar op whatsapp en fysiek te vinden op J.G. Sandbrinkstraat 3 (Eetcafe 't Witte Paard). Mocht onze locatie door omstandigheden moeten wijzigen dan laten we dit via whatsapp tijdig weten.</p>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

