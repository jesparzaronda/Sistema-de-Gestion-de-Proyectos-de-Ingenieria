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
				title="Tables"><a class="nav-link" data-toggle="modal"
				data-target="#añadirProyecto"> <i
					class="fa fa-fw fa-circle"></i> <span class="nav-link-text">Trabajadores</span>
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
					${proyecto_gestor}
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
				<li class="breadcrumb-item active">${proyecto_seleccionado}</li>
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
                
              <tr role="row" class="odd">
                  <td class="sorting_1">Airi Satou</td>
                  <td>Trabajador</td>
                  <td>33</td>
                  <td>3</td>
                  <td>188</td>
                  <td><a href="AreaRecursos-trabajador.jsp">Ver informe</a></td>
                </tr><tr role="row" class="even">
                  <td class="sorting_1">Angelica Ramos</td>
                  <td>Gestor de Proyectos</td>
                  <td>38</td>
                  <td>2</td>
                  <td>218</td>
                  <td><a href="AreaRecursos-trabajador.jsp">Ver informe</a></td>
                </tr></tbody>
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