<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'un Departement</title>
<link rel="stylesheet" type="text/css"
	href=<c:out value="${base_url }public/css/bootstrap.css"/> />
<link rel="stylesheet" type="text/css"
	href=<c:out value="${base_url }public/css/notyf.min.css"/> />
</head>
<body>
	<%@ include file="../public/header.jsp"%>

	<c:if test="${vide != null && vide == 1 }">
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
        t.error("Le libelle est obligatoire");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
	</c:if>

	<c:if test="${existe != null && existe==1 }">
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
        t.error("Ce departement existe dans la base de donnee");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
	</c:if>

	<div class="container col-md-8 offset-md-2">
		<div class="card">
			<div class="card-header bg-primary text-white">Ajout d'un
				Departement</div>
			<div class="card-body">
				<form action=<c:out value="${base_url }Departement/add"/>
					method="POST" class="needs-validation" id="form" novalidate>
					<div class="form-group">
						<label class="control-label">Libelle</label>
						<input type="text" name="libelle" id="libelle" class="form-control" <c:if test="${libelle != null }">value="${libelle }"</c:if> required />
					</div>
					<div class="form-group">
						<input type="submit" name="ajouter" id="ajouter"
							class="btn btn-primary" value="Ajouter" />
					</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../public/js/jquery.js"></script>
	<script type="text/javascript" src="../public/js/bootstrap.js"></script>
	<script type="text/javascript" src="../departement/departement.js"></script>

</body>
</html>