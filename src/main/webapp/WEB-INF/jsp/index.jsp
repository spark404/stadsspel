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
          <a class="navbar-brand" href="#">Stadspel 2016</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Scores</a></li>
            <li><a href="/events">Berichten</a></li>
            <li><a href="/overig">Overig</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
      <h2>Scores</h2>
      <jsp:useBean id="now" class="java.util.Date" />
      <table class="table table-responsive score">
        <thead>
	      <tr>
	        <th class="col-md-1 align-center">#</th>
	        <th class="col-md-8" >Groep</th>
	        <th class="col-md-1 align-right">Score</th>
	      </tr>
	  </thead>
	<tbody>
	<c:forEach items="${rankings}" var="element">
	  <c:choose>
        <c:when test="${element.groupName == group.groupname}">
          <c:set value="success" var="cssClass"></c:set>
        </c:when>
        <c:otherwise>
          <c:set value="" var="cssClass"></c:set>
        </c:otherwise>
      </c:choose>
      <tr class="${cssClass}">
        <td class="align-center">${element.getRank()}</td>

        <td>${element.groupName}</td>
        <td class="align-right">&euro;&nbsp;${element.getMoney()}</td>
      </tr>
    </c:forEach>
	</tbody>
      </table>
            <p>Laatst bijgewerkt op <fmt:formatDate type="both" value="${now}" /></p>

    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

