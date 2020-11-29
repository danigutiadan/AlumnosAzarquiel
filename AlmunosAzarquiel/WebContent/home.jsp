<%@page import="model.Alumno"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <title>Agenda Alumnos</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="css/mycss.css" />
</head>

<%	
	ArrayList<Curso> cursos = (ArrayList<Curso>) session.getAttribute("cursos");
%>

<body>

  <div class="container fondo p-0">
	
	<!-- img header -->
    <img src="img/header.jpg" class="mb-3 imgheader" alt="Imagen header"/>

	<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary rounded mx-3 px-4">
        <!-- Boton de expandir/colapsar -->
        <button class="navbar-toggler my-2" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Contenedor colapsable -->
        <div class="collapse navbar-collapse" id="navbarNavDropdown">    
			<div class="row">		
				<div class="col-6">
				
					<!-- Search -->
                	<div class="md-form active-cyan-2">
                  		<input class="form-control" type="text" placeholder="Search" aria-label="Search">
                	</div>

				</div>						
				<div class="col-6">
				
					<!-- Seleccione curso -->
				    <form action="Controller?op=alumnosByCurso" method="POST">
			        	<select class="btn miselect bg-secondary" style="max-width=500px;" name="curso"
			            		id="curso" onchange="this.form.submit()">
			            	<option value="" readonly>Seleccione curso</option>
			            	<% for (Curso curso:cursos) { %>
			            	<option value="<%=curso.getCurso()%>"><%=curso.getCurso()%></option>
			            	<%}%> 
			            </select>
			          	<input type="hidden" name="op" value="alumnosByCurso">
		            </form>   
		          
		            <!-- Boton anadir curso -->
		            <form action="Controller" method="POST">
			          <button class="btn-secondary btn-sm ml-1" type="button" na>
						 <img src="img/add.png" width="24px" alt="Boton añadir curso"/>
			          </button>
			          <input type="hidden" name="op" value="#">
		            </form>
			  
				</div>			
			</div>	
        </div>
    </nav>

	<!-- Boton anadir alumno -->
    <div class="row justify-content-center my-3">
      <form action="Controller" method="POST">
       	<button class="btn-secondary btn-sm ml-1" type="button" >
			<img src="img/add.png" width="24px" alt="Boton añadir card view alumno"/>
       	</button>
        <input type="hidden" name="op" value="#">
      </form>
    </div>
 
    
    <%	ArrayList<Alumno> alumnos = (ArrayList<Alumno>) request.getAttribute("alumnos");
    	if (alumnos != null) {%>   
    <!-- Cards -->
    <div class="row mb-4">
    
    	<% for (Alumno alumno : alumnos) { %>
    	<!-- Card Alumno -->
    	<div class="col-12 col-md-6 col-lg-4">   	
	      <div class="card m-3 bg-info " style="width: 17rem;">
	        <div class="card-body">
	        
	          <!-- Nombre -->
	          <h5 class="card-title bold"><%=alumno.getNombre().toUpperCase()%></h5>
	          
	          <!-- DNI -->
	          <div class="card-text"><%=alumno.getDni()%></div>
	
			  <!-- Email -->
	          <div class="card-text enlinea">
	          	<span>ejemplocorreo@hotmail.com</span>
	            <!-- Boton anadir email -->
			    <form action="Controller" method="POST">
		          <button class="btn-secondary btn-sm ml-1" type="button" >
				    <img src="img/add.png" width="24px" alt="Boton añadir email"/>
		          </button>
		          <input type="hidden" name="op" value="#">
	            </form>
	            <!-- Boton eliminar email -->
			    <form action="Controller" method="POST">
		          <button class="btn-secondary btn-sm ml-1" type="button" >
				    <img src="img/delete.png" width="24px" alt="Boton eliminar email"/>
		          </button>
		          <input type="hidden" name="op" value="#">
	            </form>
	          </div>
	          
	          <!-- Telefono -->
	          <div class="card-text enlinea">
	          	<span>623434355</span>
	            <!-- Boton anadir telefono -->
			    <form action="Controller" method="POST">
		          <button class="btn-secondary btn-sm ml-1" type="button" >
				    <img src="img/add.png" width="24px" alt="Boton añadir telefono"/>
		          </button>
		          <input type="hidden" name="op" value="#">
	            </form>
	            <!-- Boton eliminar telefono -->
			    <form action="Controller" method="POST">
		          <button class="btn-secondary btn-sm ml-1" type="button" >
				    <img src="img/delete.png" width="24px" alt="Boton eliminar telefono"/>
		          </button>
		          <input type="hidden" name="op" value="#">
	            </form>
	          </div>
	          
			  <!-- Curso -->
	          <div class="card-text">2020-2021</div>
	          
	        </div>
	      </div>
    	</div>
    	<!-- Card Alumno -->
    	<%} %>
    		
    </div>
    <!-- Cards -->   
    <%} %>

    <!-- Footer -->
    <footer class="page-footer font-small blue">
      <!-- Copyright -->
      <h2 class="text-center footer-color py-4">IES AZARQUIEL - S2DAM - 2020-21</h2>
    </footer>
    <!-- Footer -->

  </div>
  
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
</body>

</html>