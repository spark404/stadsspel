<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="nl">
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
            <li><a href="/">Scores</a></li>
            <li class="active"><a href="/events">Berichten</a></li>
            <li><a href="/locations">Lokaties</a></li>
            <li><a href="/overig">Overig</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
      <h2>Berichten voor ${group.groupname}</h2>
      <c:if test="${empty events}">
        <p class="text-info"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Nog geen berichten, tijd om wat te gaan doen!</p>
      </c:if>
      <c:forEach items="${events}" var="event">
          <c:choose>
            <c:when test="${event.event == 'bezoek' && event.groupName == group.groupname}">
                <p class="text-success"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> <fmt:formatNumber value="${event.amount}" type="currency" currencyCode="EUR" maxFractionDigits="0"/>, Jullie hebben bezoek gehad van ${event.otherGroupName} op jullie locatie ${event.locationCode}</p>
            </c:when>
            <c:when test="${event.event == 'bezoek' && event.otherGroupName == group.groupname}">
                <p class="text-danger"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> <fmt:formatNumber value="${-event.amount}" type="currency" currencyCode="EUR" maxFractionDigits="0"/>, Jullie zijn op bezoek geweest bij ${event.otherGroupName} op hun locatie ${event.locationCode}</p>
            </c:when>
            <c:when test="${event.event == 'kanskaart'}">
                <p class="text-info"><span class="glyphicon glyphicon-gift" aria-hidden="true"></span> <fmt:formatNumber value="${event.amount}" type="currency" currencyCode="EUR" maxFractionDigits="0"/>, Jullie hebben een kans kaart getrokken met een geld bedrag</p>
            </c:when>
            <c:when test="${event.event == 'boete'}">
                <p class="text-danger"><span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span> <fmt:formatNumber value="${event.amount}" type="currency" currencyCode="EUR" maxFractionDigits="0"/>, Jullie hebben een boete gehad van de spelleiding</p>
            </c:when>
            <c:otherwise>
                <p class="text-info"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Er is een ${event.event} bericht voor jullie, neem contact op met de spelleiding</p>
            </c:otherwise>
          </c:choose>
      </c:forEach>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

