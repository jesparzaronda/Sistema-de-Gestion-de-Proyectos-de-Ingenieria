<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Área Recursos Humanos</title>
<!-- Bootstrap core CSS-->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="assets/css/gestor.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav"> <a class="navbar-brand" href="index.html">Área Recursos Humanos
</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="AreaRecursos.jsp"> <i
					class="fa fa-fw fa-circle"></i> <span class="nav-link-text">Trabajadores</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Tables"><a class="nav-link" href="AreaRecursos-proyectos.jsp"> <i
					class="fa fa-fw fa-circle"></i> <span class="nav-link-text">Proyectos</span>
			</a></li>
			

			
		</ul>
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown"
				href="#" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fa fa-fw fa-envelope"></i> <span
					class="d-lg-none">Messages <span
						class="badge badge-pill badge-primary">12 New</span>
				</span> <span class="indicator text-primary d-none d-lg-block"> <i
						class="fa fa-fw fa-circle"></i>
				</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown"
				href="#" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fa fa-fw fa-bell"></i> <span
					class="d-lg-none">Alerts <span
						class="badge badge-pill badge-warning">6 New</span>
				</span> <span class="indicator text-warning d-none d-lg-block"> <i
						class="fa fa-fw fa-circle"></i>
				</span>
			</a></li>

			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout:
					${RRHHLogged}
			</a></li>
		</ul>
	</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Área Recursos Humanos</a>
				</li>
				<li class="breadcrumb-item active">Trabajadores</li>
			</ol>
			<!-- Icon Cards-->
			<div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Datos Trabajadores</div>
        <div class="card-body">
          <div class="table-responsive">
            <div id="dataTable_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
            
            <div class="row">
            <div class="col-sm-12">
            <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
              <thead>
                <th rowspan="1" colspan="1">Nombre</th>
                <th rowspan="1" colspan="1">Cargo</th>
                <th rowspan="1" colspan="1">Edad</th>
                <th rowspan="1" colspan="1">Número de proyectos</th>
                <th rowspan="1" colspan="1">Horas trabajadas</th>
                <th rowspan="1" colspan="1">Informe</th></thead>
              
              </thead>
              <tbody>                               
                
     
                
            <c:forEach items="${trabajadores_list}" var="trabajador" varStatus="status">
            <c:choose>
            <c:when test="${trabajador.getEmpresa().getNombre() eq nombre_empresa}">
            <c:choose>
            <c:when test="${trabajador.getPrivilegios() != 3}">
              <tr role="row" class="odd">
                  <td class="sorting_1">${trabajador.getNombre()} ${trabajador.getApellidos()}</td>
                  <td>	
                  	<c:choose>
                  		<c:when test="${trabajador.getPrivilegios()==1}">
                  			Trabajador
                  		</c:when>
                  		<c:when test="${trabajador.getPrivilegios()==2}">
                  			Gestor
                  		</c:when>
                   	</c:choose>
                  </td>
                  <td>${trabajador.getEdad()}</td>
                  <td>${trabajador.getProyectosTrabajador().size()}</td>
                  <td>${horas_list[status.index]}</td>
                  <td>
                  
                  <form action="RealizarInforme">
					<input type="hidden" name="nombre_trabajador"value="${trabajador.getNombre()} ${trabajador.getApellidos()}"/>
						<button type="submit">Ver Informe</button>
				  </form>
                 
              </tr>
              </c:when>
              </c:choose>
              </c:when>
              </c:choose>
           	</c:forEach>
                
         
            </table></div></div>
            
            
          </div>
        </div>
      </div>




		</div>
		<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © ISST 2018</small>
			</div>
		</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>

		
	

		<!-- Logout Modal-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="FormLogout">Logout</a>
					</div>
				</div>
			</div>
		</div>





		<!-- Bootstrap core JavaScript-->
		<script src="assets/vendor/jquery/jquery.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>
		<!-- Page level plugin JavaScript-->
		<script src="assets/vendor/chart.js/Chart.min.js"></script>
		<script src="assets/vendor/datatables/jquery.dataTables.js"></script>
		<script src="assets/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="assets/js/sb-admin.min.js"></script>
		<!-- Custom scripts for this page-->
		<script src="assets/js/sb-admin-datatables.min.js"></script>
		<script src="assets/js/sb-admin-charts.js"></script>
	</div>
</body>
</html>