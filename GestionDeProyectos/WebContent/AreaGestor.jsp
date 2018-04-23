<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Área Gestor de Proyectos</title>
  <!-- Bootstrap core CSS-->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="assets/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="assets/css/gestor.css" rel="stylesheet">
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
     	<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" data-toggle="modal" data-target="#añadirProyecto">
            <i class="fa fa-fw fa-plus-circle"></i>
            <span class="nav-link-text">Crear nuevo proyecto</span>
          </a>
        </li>
        

         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#añadirProyecto" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-cogs"></i>
            <span class="nav-link-text">Gestionar mis proyectos</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExamplePages">
            <li>
              <a href="">Proyecto 2</a>
            </li>            
          </ul>
        </li>
         
       
       
      
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
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
         
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout: user</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Gestionar Proyecto</a>
        </li>
        <li class="breadcrumb-item active">Proyecto 2</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-lg-4">
          <h2>Información</h2>
          <p><b>Nombre del proyecto: </b>Proyecto 1</p>
          <p><b>Descripción: </b>descripción</p>
          <p><b>Gestor: </b>gestor</p>
          <p><b>Objetivos: </b>objetivos</p>
          <button type="button" class="btn btn-secondary" style="margin-bottom: 20px;">Editar</button>

        <h2>Trabajadores:</h2>

          <button type="button" class="btn btn-info" data-toggle="modal" data-target="#añadirTrabajador"style="margin-bottom: 20px;">Añadir</button>
         <button type="button" class="btn btn-info" style="margin-bottom: 20px;">Eliminar</button>

         

        </div>
        <div class="col-lg-8">
          <div class="row">
              <div class="card mb-3 col-lg-12">
                <div class="card-header"><i class="fa fa-table"></i>Trabajadores en el proyecto</div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                      <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Fecha comienzo</th>
                          <th>Horas trabajaas</th>
                        </tr>
                      </thead>
                      
                      <tbody>
                        <tr>
                          <td>Trabajador 1</td>
                          <td>02/03/2018</td>
                          <td>25</td>
                        </tr>     
                        <tr>
                          <td>Trabajador 2</td>
                          <td>02/03/2018</td>
                          <td>20</td>
                        </tr>   
                        <tr>
                          <td>Trabajador 3</td>
                          <td>05/03/2018</td>
                          <td>17</td>
                        </tr>   
                        <tr>
                          <td>Trabajador 4</td>
                          <td>06/03/2018</td>
                          <td>18</td>
                        </tr>   
                        <tr>
                          <td>Trabajador 5</td>
                          <td>13/03/2018</td>
                          <td>8</td>
                        </tr>             
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
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
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    
    <!-- Añadir proyecto-->
    <div class="modal fade" id="añadirProyecto">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Añadir Nuevo Proyecto</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <form class="form-contact" action="CrearProyecto" >   
		        	<div class="row">          
                    <div class="col-md-6">
                    	<strong>Nombre del proyecto:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="nombre"> <br />
                    </div>               
                    <div class="col-md-6">
                    	<strong>Fecha inicio de proyecto:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="fechaInicio"> <br />
                    </div>  
                    <div class="col-md-6">
                    	<strong>Fecha fin de proyecto:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="fechaFinal"> <br />
                    </div>  
                    <div class="col-md-6">
                    	<strong>Empresa</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="empresa"> <br />
                    </div>   
                    <div class="col-md-12 text-center btn-submit">
                      <input class="btn btn-default btn-lg-xl " name='boton' type="submit" value="Crear proyecto" />  
                    </div>                    
                    </div>      
                  </form>
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		
		    </div>
		  </div>
		</div>
		<!-- Añadir trabajador al proyecto-->
    <div class="modal fade" id="añadirTrabajador">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Añadir Trabajador</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <form class="form-contact" action="AñadirTrabajadorProyecto" >   
		        	<div class="row">          
                    <div class="col-md-12">
                    	<strong>Seleccionar trabajador:</strong><br>
                    	<select>
                    		<c:forEach items="${trabajadores_list}" var="trabajador">
                    			<option>${trabajador.nombre} ${trabajador.apellidos}</option>
                    		</c:forEach>
                    	</select>
                    </div>     
                       
                    <div class="col-md-12 text-center btn-submit">
                      <input class="btn btn-default btn-lg-xl " name='boton' type="submit" value="Añadir trabajador al proyecto" />  
                    </div>                    
                    </div>      
                  </form>
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		
		    </div>
		  </div>
		</div>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
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