<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification d'un Departement</title>
<link rel="stylesheet" type="text/css"
	href=<c:out value="${base_url }public/css/bootstrap.css"/> />
<link rel="stylesheet" type="text/css"
	href=<c:out value="${base_url }public/css/notyf.min.css"/> />
</head>
<body>
	<%@ include file="../public/header.jsp"%>
	
	<!-- Les Messages flash en utilisant la bibliotheque notyf.min.js -->

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
        t.error("Le departement <%= request.getAttribute("libelle") %> existe dans la base de donnee");
        setTimeout(()=>{
            t.dismissAll();
        },2000);
		</script>
	</c:if>

	<div class="container col-md-8 offset-md-2">
		<div class="card">
			<div class="card-header bg-primary text-white">Modification
				d'un Departement</div>
			<div class="card-body">
				<!-- Impossible d'avoir les if else dans le jstl raison pour laquelle on utilise choose when -->
				<c:choose>
					<!-- Si le departement existe dans la base de donnees, on affiche le formulaire de modification -->
					<c:when test="${departement!=null }">
						<form
							action=<c:out value="${base_url }Departement/edit/${departement.id }"/>
							method="POST" class="needs-validation" id="form" novalidate>
							<div class="form-group">
								<label class="control-label">Libelle</label> <input type="text"
									name="libelle" id="libelle" class="form-control"
									value='<c:out value="${departement.libelle }"></c:out>'
									required />
							</div>
							<div class="form-group">
								<input type="submit" name="modifier" id="modifier"
									class="btn btn-primary" value="Modifier" />
							</div>

						</form>
					</c:when>
					<!-- Sinon on affiche l'alert -->
					<c:otherwise>
						<div class="alert alert-danger">Ce Departement n'existe pas dans la base de donnees</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<script type="text/javascript" src='<c:out value="${base_url }public/js/jquery.js"></c:out>'></script>
	<script type="text/javascript" src='<c:out value="${base_url }public/js/bootstrap.js"></c:out>'></script>
	<script type="text/javascript" src='<c:out value="${base_url }departement/departement.js"></c:out>'></script>

</body>
</html>