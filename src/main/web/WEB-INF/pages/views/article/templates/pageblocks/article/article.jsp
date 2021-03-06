<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="my" uri="/WEB-INF/taglibs/neutrino.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- init : Obligatoire dans le JSP contenant le Doctype --%>
<my:init test="${!initialized}"/>

<h1>PAGEBLOCK NAME = ${activeBlock.name} </h1>

<h2>attribut : title = ${title.value} - ${title.type}</h2>
<h2>attribut : number = ${number.value} - ${number.type}</h2>

<h2>attribut : album = ${album.value.name} - ${album.type} - ${album.objectType}</h2>
<c:forEach var="item" items="${albums.value}" varStatus="status">
	<h2>Element ${status.index} : ${item.value.name} - ${item.type}</h2>
</c:forEach>

<c:forEach var="item" items="${numbers.value}" varStatus="status">
	<h2>Element ${status.index} : ${item.value} - ${item.type}</h2>
</c:forEach>

<div>
	<my:block position="title" />
</div>

<div>
	<my:block position="content" />
<!-- 	<data-ui-position facade="facade" position="content" /> -->
</div>





	
			