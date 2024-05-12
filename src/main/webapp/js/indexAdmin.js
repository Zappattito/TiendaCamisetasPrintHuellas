
      function llamada(){
        fetch('GestionUsuariosController')
        .then(response => response.json())
        .then(data => pintarTabla(data))

      }

      function pintarTabla(datos){
        let html = "<table border=2>";

        for(let i=0; i<datos.length; i++){
          html += "<tr><td>"+datos[i].idUsuario+"</td><td>"+datos[i].nombre+"</td>"
          html += "<td>"+datos[i].correo+"</td>"
          html += "<td>"+datos[i].contrasena+"</td>"
          html += "<td>"+datos[i].foto+"</td>"
          html += "<td>"+datos[i].permiso+"</td>"
          html += "<td><a href='formulario.html?id="+datos[i].id+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].id+")'>Borrar</a></td>";
          html += "</tr>"
        }  
        
        html += "</table>";
        
        document.getElementById("listado").innerHTML = html;
      }
      
      function busquedaPorTipo(tipoUsuario){
		
		fetch('GestionUsuariosController?op=4&tipoUsuario='+tipoUsuario)
			.then(response => response.json())
			.then(data => pintarTabla(data))
		
	}
      window.onload = function(){
        llamada();
      }
 