<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Área Trabajador</title>
<!-- Bootstrap core CSS-->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="assets/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="assets/css/trabajador.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Mis proyectos</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Example Pages"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#misProyectosGestionados" data-parent="#exampleAccordion">
					<i class="fa fa-fw fa-cogs"></i> <span class="nav-link-text">
						Mis proyectos</span>
			</a>
				<ul class="sidenav-second-level collapse"
					id="misProyectosGestionados">

					<c:forEach items="${proyectos_trabajador}" var="proyecto">
						<li>
							<form action="SeleccionarProyecto">
								<input type="hidden" name="nombre_proy"
									value="${proyecto.nombre}" />
								<button type="submit">${proyecto.nombre}</button>
							</form>
						</li>
					</c:forEach>

				</ul></li>
       
      
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-envelope"></i>
            <span class="d-lg-none">Mensajes
              <span class="badge badge-pill badge-primary">12 Nuevos</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
         
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Notificaciones
              <span class="badge badge-pill badge-warning">6 Nuevas</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout: ${trabajadorLogged}</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Proyectos</a>
        </li>
        <li class="breadcrumb-item active">${proyecto_seleccionado}</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-lg-6">

          <h2>Información</h2>
          <p><b>Nombre del proyecto: </b>${proyecto_seleccionado}</p>
          <p><b>Gestor: </b>${proyecto_trabajador}</p>

          <a type="button" class="btn btn-success" action="desactivar()" name="start" id="start" href="HorasIniTrabajador">Empezar</a>
          <a type="button" class="btn btn-danger" disabled="" action="desactivar()" name="stop" id="stop" href="HorasFinTrabajador">Parar</a>
          <c:choose>
          <c:when test="${privilegios == 2}">
          <a type="button" class="btn btn-default" href="TrabajadorToGestor" id="VolverGestor">Volver Área Gestor</a>
          
          </c:when>
          </c:choose>
          <script type="text/javascript">
			function desactivar(){
				if (document.getElementById('start').disabled == false){
					document.getElementById('start').disabled = true;
					document.getElementById('stop').disabled = false;
				}else if (document.getElementById('stop').disabled == false){
					document.getElementById('start').disabled = false;
					document.getElementById('stop').disabled = true;
				}
			}
		 </script>

        </div>
        <div class="col-lg-6">
           <div class="row">
              <div class="col-xl-6 col-sm-6 mb-3">
                <div class="card text-white bg-primary o-hidden h-100">
                  <div class="card-body">
                    <div class="card-body-icon">
                      <i class="fa fa-fw fa-comments"></i>
                    </div>
                    <div class="mr-5">2 Nuevos Mensajes</div>
                  </div>
                  <a class="card-footer text-white clearfix small z-1" href="#">
                    <span class="float-left">Ver</span>
                    <span class="float-right">
                      <i class="fa fa-angle-right"></i>
                    </span>
                  </a>
                </div>
              </div>
              <div class="col-xl-6 col-sm-6 mb-3">
                <div class="card text-white bg-warning o-hidden h-100">
                  <div class="card-body">
                    <div class="card-body-icon">
                      <i class="fa fa-fw fa-list"></i>
                    </div>
                    <div class="mr-5">3 Nuevas tareas</div>
                  </div>
                  <a class="card-footer text-white clearfix small z-1" href="#">
                    <span class="float-left">Ver Detalles</span>
                    <span class="float-right">
                      <i class="fa fa-angle-right"></i>
                    </span>
                  </a>
                </div>
              </div>
              
            </div>
            <!-- Area Chart Example-->
            <div class="card mb-3 col-lg-12">
              <div class="card-header">
                <i class="fa fa-area-chart"></i> Horas trabajadas en el proyecto</div>
               <div class="card-body">
                <canvas id="myAreaChart" width="100%" height="30"></canvas>
              </div> 
             
              </div>
            </div>
     
    
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © ISST 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">¿Seguro que quiere salir?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Seleccione "Logout" solo si está seguro/a de que quiere cerrar la sesión.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
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