<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Trains</title>
    </head>
<body>
<div class="container">
    <div class="row justify-content-md-center">

        <form action="${pageContext.request.contextPath}/train/edit/" method="post">
            <c:if test="${!empty trainDTO.id}">
                <input type="hidden" name="id" value="${trainDTO.id}">
            </c:if>
            <div class="form-col">
                <div class="row">
                    <label for="number">Train name</label>
                    <input type="text" class="form-control" name="number" id="number" value="${trainDTO.trainName}"/>
                </div>
                <div class="row">
                    <label for="seatsNumber">Train seats</label>
                    <input type="number" class="form-control" name="seatsNumber" id="seatsNumber" value="${trainDTO.seats}"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
    </div>
    <a href="../"  role="button" class="btn btn-primary btn-lg">Back</a>
</div>
</body>
</html>
