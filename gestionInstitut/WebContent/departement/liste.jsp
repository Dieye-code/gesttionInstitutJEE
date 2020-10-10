<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Departement</title>
<link rel="stylesheet" type="text/css"
	href=<c:out value="${base_url }public/css/bootstrap.css"/> />
<link rel="stylesheet" type="text/css"
	href=<c:out value="${base_url }public/css/notyf.min.css"/> />
</head>
<body>
	<%@ include file="../public/header.jsp"%>

	<c:if test="${a!= null }">
		<script type="text/javascript" src="${base_url }public/js/jquery.js"></script>
		<script type="text/javascript"
			src="${base_url }public/js/notyf.min.js"></script>
		<script type="text/javascript">
		var t = new Notyf({
            duration : 2000 , 
            position : { 
                x : 'right' , 
                y : 'top' , 
            }
        });
        t.success("Departement bien ajouté");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
	</c:if>

	<div class="container col-md-6 offset-md-3 mt-5">
		<div>
			<a href="<c:out value='${base_url }Departement/add'/>"
				class="btn btn-primary">Ajouter</a>
		</div>
		<div class="card">
			<div class="card-header bg-primary text-white">Liste Des
				Departements</div>
			<div class="card-body">
				<table class="table table-bordered table-striped">
					<tr>
						<th>ID</th>
						<th>Libelle</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${departements }" var="departement">
						<tr>
							<td><c:out value="${departement.id }" /></td>
							<td><c:out value="${departement.libelle }" /></td>
							<td><a
								href="<c:out value='${base_url }Departement/edit/${departement.id }'/>">edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>