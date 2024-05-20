<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/styles2.css" />
<title>Document</title>

<script type="text/javascript">

      function llamada(){
        fetch('GestionCamisetaController')
        .then(response => response.json())
        .then(data => pintarTabla(data))

      }

      function pintarTabla(datos){
        let html = "<table border=2>";<!--esto no se puede hacer los estilos van en otra hoja-->

        for(let i=0;i<datos.length;i++){
          html += "<tr><td>"+datos[i].id+"</td><td>"+datos[i].modelo+"</td>";
          html += "<td>"+datos[i].talla+"</td>";
          html += "<td>"+datos[i].color+"</td>";
          html += "<td>"+datos[i].foto+"</td>";
          html += "<td>"+datos[i].cantidad+"</td>";
          html += "<td>"+datos[i].estado+"</td>";
          html += "</tr>";
        }  
        
        html += "</table>";
        
        document.getElementById("pedido").innerHTML = html;
      }
      window.onload = function(){
        llamada();
      }
    </script>
</head>
<body>
	<h1>CARRITO DE TU COMPRA DE ALVARO</h1>
	<section id="menu">
		<header>
			<div class="logo">
				<a href="index2.html"><img src="img/Group 6.png" alt="logo" /></a>
			</div>
			<div id="menuOpciones">
				<nav>
					<ul id="opciones">
						<li><a href="index2.html">DISEÑA</a></li>
						<li><a href="conocenos.html">CONOCENOS</a></li>
						<li><a href="micuenta.html">MI CUENTA</a></li>
						<li id="carrito"><a href="carrito.html"><img
								src="img/10528208 1.png" alt="carrito" /></a></li>
					</ul>
				</nav>
			</div>
		</header>
	</section>
	<h1>RESUMEN DE TU PEDIDO</h1>
	<%
	if (session != null) {
	%>
	<%=session.getAttribute("correo")%>
	<div id="pedido"></div>
	<%
	}
	%>
	</section>
	<footer>
		<p>&copy; 2024 Tienda de Camisetas. Todos los derechos reservados.</p>
		<div>
			<a href="https://www.instagram.com/print.huellas/"><img
				src="img/instagram.png" alt=""></a> <a
				href="https://www.facebook.com/printhuellas1/?locale=es_ES"><img
				src="img/facebook.png" alt=""></a>
		</div>
	</footer>
	</section>
</body>
</html>
