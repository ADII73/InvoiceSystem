<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="vo.ProductVO, daoImpl.DaoImpl, vo.ResultVO, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Choose Product</title>
<!-- Font Awesome Icons  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />

<!-- Google Fonts  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/forget.css">
<style>
.passInput {
	color: palevioletred;
}

.card {
	height: 45vh;
}

@media ( max-width :365px) {
	h2 {
		font-size: 1.9rem !important;
		text-align: center;
	}
	p {
		font-size: 0.8rem;
	}
}

@media ( max-width :450px) {
	button {
		font-size: 9px;
	}
}

@media ( max-width :323px) {
	button {
		font-size: 8px;
	}
}
</style>
</head>
<body>
	<%
	DaoImpl daoImpl = new DaoImpl();
	List<ProductVO> list = daoImpl.productLists();
	request.setAttribute("list", list);
	%>
	<form class="card" action="invoiceform.jsp" method="POST">

		<p class="lock-icon">
			<i class="fas fa-receipt"> </i>
		</p>
		<h2>Make Invoice</h2>
		<br>
		<p>Select the Product For making its Invoice</p>
		<br> <select class="passInput" name="pname">
			<c:forEach var="product" items="${list}">
				<option value="${product.getId()}">${product.getProductname()}</option>
			</c:forEach>
		</select> <br>
		<button type="submit" name="submit">Make Invoice</button>
	</form>


</body>
</html>