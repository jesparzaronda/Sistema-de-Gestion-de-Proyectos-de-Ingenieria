<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<!-- Bootstrap core CSS -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
</head>
<body id="page-top">
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#" style="color:white;">Área Administrador</a>
	    </div>
	    
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="FormLogout"  style="color:white;"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-12 text-center">
					<!-- Button to Open the Modal -->
					<button type="button" class="btn btn-standard" data-toggle="modal" data-target="#modalTrabajador">
					  Añadir Trabajador
					</button>
				</div>
				<div class="col-12 text-center">
					<button type="button" class="btn btn-standard" data-toggle="modal" data-target="#modalEmpresa">
					  Añadir Empresa
					</button>
				</div>
			</div>
		</div>
		<div class="modal fade" id="modalEmpresa">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Añadir Empresa</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <form class="form-contact" action="FormAñadirNuevaEmpresa" >   
		        	<div class="row">          
                    <div class="col-md-6">
                    	<strong>Nombre:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="nombre"> <br />
                    </div>     
                    <div class="col-md-6">
                    	<strong>CIF:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="cif"> <br />
                    </div>          
                    <div class="col-md-6">
                    	<strong>Código Postal:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="codigoPostal"> <br />
                    </div>  
                    <div class="col-md-6">
                    	<strong>Télefono:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="tel" name="telefono"> <br />
                    </div>  
                    <div class="col-md-6">
                    	<strong>Ciudad:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="ciudad"> <br />
                    </div>    
                    <div class="col-md-6">
                    	<strong>Email:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="email" name="email"> <br />
                    </div>        
                    
                    <div class="col-md-12 text-center btn-submit">
                      <input class="btn btn-default btn-lg-xl " name='boton' type="submit" value="Añadir Empresa" />  
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
	
		<!-- The Modal -->
		<div class="modal fade" id="modalTrabajador">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Añadir Trabajador</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <form class="form-contact" action="AdminServlet" >
                    <div class="row">
	                    <div class="col-md-4">
	                    	<strong>Nombre:</strong><br>
	                    	<input class="form-control form-control-lg  text-center" type="text" name="nombre"> <br />
	                    </div>
	                    <div class="col-md-5">
	                    	<strong>Apellidos:</strong><br>
	                    	<input class="form-control form-control-lg text-center" type="text" name="apellidos"><br />
	                    </div>
	                    <div class="col-md-3">
	                    	<strong>Edad:</strong><br>
	                    	<input class="form-control form-control-lg text-center" type="text" name="edad"><br />
	                    </div>
	                    <div class="col-md-6">
	                    	<strong>Email:</strong><br>
	                    	<input class="form-control form-control-lg text-center" type="email" name="email"><br />
	                    </div>
	                    <div class="col-md-6">
	                    	<strong>Contaseña:</strong><br>
	                    	<input class="form-control form-control-lg text-center" type="password" name="password" ><br />
	                    </div>
	                    <div class="col-md-12">
	                    	<strong>Empresa:</strong><br>
	                   		<input class="form-control form-control-lg text-center" type="text" name="empresa"><br />
	                   	</div>
	                    <div class="col-md-12">
	                    	<strong>Privilegios: (1 = trabajador; 2 = gestor de proyecto; 3 = recursos humanos)</strong><br>
	                    	<input class="form-control form-control-lg text-center" type="text" name="privilegio"><br />
	                    </div>
	                    
	                    <div class="col-md-12 text-center btn-submit">
	                      <input class="btn btn-default btn-lg-xl " name='boton' type="submit" value="Añadir Trabajador" />  
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
		
		
	</section>
	

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <span class="copyright">Copyright &copy; 2018 ISST Gestión de Proyectos</span>
          </div>      
        </div>
      </div>
    </footer>
    
    <!-- Bootstrap core JavaScript -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>