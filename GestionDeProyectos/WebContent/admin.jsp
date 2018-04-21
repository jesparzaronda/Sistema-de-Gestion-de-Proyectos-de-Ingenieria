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
	<section id="area-login">
        <div class="container">
            <div class="text-center">
                <h2 class="text-center">Añadir Trabajador</h2>
                <div class="devider"></div>
               
            </div>              
            
            <div class="col-lg-10 offset-lg-1">
                  <form class="form-contact" action="FormLogin" >
                    <div class="row">
                    <div class="col-md-5">
                    	<strong>Nombre:</strong><br>
                    	<input class="form-control form-control-lg  text-center" type="text" name="nombre" placeholder="Nombre"> <br />
                    </div>
                    <div class="col-md-5">
                    	<strong>Apellidos:</strong><br>
                    	<input class="form-control form-control-lg text-center" type="text" name="apellidos" placeholder="Apellidos" ><br />
                    </div>
                    <div class="col-md-2">
                    	<strong>Edad:</strong><br>
                    	<input class="form-control form-control-lg text-center" type="text" name="eda" placeholder="Edad" ><br />
                    </div>
                    <div class="col-md-6">
                    	<strong>Email:</strong><br>
                    	<input class="form-control form-control-lg text-center" type="email" name="email" placeholder="Email" ><br />
                    </div>
                    <div class="col-md-6">
                    	<strong>Contaseña:</strong><br>
                    	<input class="form-control form-control-lg text-center" type="password" name="password" placeholder="Contraseña" ><br />
                    </div>
                    <div class="col-md-6">
                    	<strong>Empresa:</strong><br>
                   		<input class="form-control form-control-lg text-center" type="text" name="empresa" placeholder="Empresa" ><br />
                   	</div>
                    <div class="col-md-6">
                    	<strong>Privilegios: (1 = trabajador; 2 = gestor de proyecto; 3 = recursos humanos)</strong><br>
                    	<input class="form-control form-control-lg text-center" type="text" name="privilegio" placeholder="Privilegio" ><br />
                    </div>
                    
                    <div class="col-md-12 text-center btn-submit">
                      <input class="btn btn-default btn-lg-xl " name='boton' type="submit" value="Añadir Trabajador" />  
                    </div>
                  </form>
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
</body>
</html>