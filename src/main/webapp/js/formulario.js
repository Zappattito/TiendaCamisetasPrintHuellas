function llamada(id, op){
			fetch('GestionUsuariosController?id='+id+"&op="+op)
			.then(response => response.json())
			.then(data => pintarFormulario(data))
		
	}
		/**
 * Funci�n para otener el valor de un parametro en el GET 
 */
function getParameterByName(name) {
		    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		    results = regex.exec(location.search);
		    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}


function validarFormulario(){
			  
		    let nombre = document.getElementById('nombre').value;
			let correo = document.getElementById('correo').value;
   		    let contrasena = document.getElementById('contrasena').value;
			let foto = document.getElementById('foto').value;
			
			let ok = true;
			if(nombre == ""){
				ok = false;
				document.getElementById('nombre').style.background = "red";
			}
			
			if(email == ""){
				ok = false;
				document.getElementById('correo').style.background = "red";
			}
			
			if(tel == ""){
				ok = false;
				document.getElementById('contrasena').style.background = "red";
			}
			
			if(ok == true){
				
				document.getElementById("registroUsuario").submit();
				
			}
				   
		}
function pintarFormulario(datos){
			document.getElementById("IdUsuario").value = datos.idUsuario; 
			document.getElementById("nombre").value = datos.nombre;
			document.getElementById("correo").value = datos.correo;
			document.getElementById("contrasena").value = datos.contrasena;
			document.getElementById("foto").value = datos.foto;
			document.getElementById("permiso").value = datos.foto;



		}
		
		
		
		window.onload = function(){
			let id = getParameterByName("id");
			let op = getParameterByName("op");
			llamada(id,op);
			
		}
				