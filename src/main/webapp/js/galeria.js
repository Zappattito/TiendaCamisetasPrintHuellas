
function llamada(){
		
		fetch('ListadoController')
		.then(res => res.json())
		.then(res => pintarResultados(res));
		
	}
	function pintarResultados(datos){
		
		let html = "<table>";
			
		for(let i=0;i<datos.length;i++){
			html+="<tr><td>"+datos[i].id+"</td>";
			html+="<td>"+datos[i].nombre+"</td>";
			html+="<td>"+datos[i].correo+"</td>";
			html+="<td>"+datos[i].contrasena+"</td>";
			html+="<td>"+datos[i].foto+"</td>";
			html+="<td>"+datos[i].permiso+"</td>";
			html+="<td><a href='formulario.html?id="+datos[i].id+"'>Editar</a></td>";
			html+="</tr>";	
		}
		html += "</table>";
		document.getElementById("resultados").innerHTML = html;
	}

	window.onload = function(){
		
		llamada()

	}
	

