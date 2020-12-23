<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="ex" items="${list}">
    <div class="list-box">
        <a href="detail?name=${ex.name}" class="img-box ">
            <img src="../../image/exercise/${ex.engName}1.jpg" height="134px" width="150px" alt="">
        </a>
        <div class="name">
            <a href="detail?name=${ex.name}">${ex.name}</a>
        </div>
    </div>
</c:forEach>