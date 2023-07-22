<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="vo.InvoiceVO, daoImpl.DaoImpl, vo.ResultVO, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Manage Invoice</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
<link rel="stylesheet" href="css/manage.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Tilt+Warp&display=swap"
	rel="stylesheet" />
</head>
<body>
	<%
	DaoImpl daoImpl = new DaoImpl();
	List<InvoiceVO> list = daoImpl.invoiceLists();
	request.setAttribute("list", list);
	%>
	<div class="main-div">
		<h1>List of Invoices</h1>

		<div class="center-div">
			<div class="table-responsive">
				<table>
					<thead>
						<tr>
							<!-- invoice number -->
							<th>Invoice</th>
							<!-- Customer -->
							<th>Customer</th>
							<!-- Invoice date -->
							<th>Issue Date</th>
							<!-- Due Date -->
							<th>Due Date</th>
							<!-- Invoice Status -->
							<th>Invoice Status</th>
							<th colspan="3">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="invoice" items="${list}">
							<tr>
								<td><span class=".invoice-style">${invoice.getInvoiceNo()}</span></td>
								<td>${invoice.getCustomer()}</td>
								<td>${invoice.getInvoiceDate()}</td>
								<td>${invoice.getDueDate()}</td>
								<td>${invoice.getInvoiceStatus()}</td>
								<td><a style="color: black;" href="invoiceupdateform.jsp?id=${invoice.getId()}" data-toggle="tooltip"
									data-placement="bottom" title="UPDATE"><i
										class="fa-regular fa-pen-to-square"></i></a></td>
								<td><a style="color: black;" href="DownloadInvoice?id=${invoice.getId()}" data-toggle="tooltip"
									data-placement="bottom" title="DOWNLOAD" target="_blank"><i
										class="fa-solid fa-download"></i></a></td>
								<td><a style="color: black;" href="InvoiceDelete?id=${invoice.getId()}" data-toggle="tooltip"
									data-placement="bottom" title="DELETE"><i
										class="fa-solid fa-trash"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>





	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>


</body>
</html>