function llamada(id, op){
			fetch('GestionCamisetaController?id='+id+"&op="+op)
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
			  
		    let modelo = document.getElementById('modelo').value;
			let talla = document.getElementById('talla').value;
   		    let cantidad = document.getElementById('cantidad').value;
			let color = document.getElementById('color').value;
			let foto = document.getElementById('foto').value;
			let estado = document.getElementById('estado').value;
			
			let ok = true;
			if(modelo == ""){
				ok = false;
				document.getElementById('modelo').style.background = "red";
			}
			
			if(talla == ""){
				ok = false;
				document.getElementById('talla').style.background = "red";
			}
			
			if(cantidad == ""){
				ok = false;
				document.getElementById('cantidad').style.background = "red";
			}
			if(color == ""){
				ok = false;
				document.getElementById('color').style.background = "red";
			}
			if(foto == ""){
				ok = false;
				document.getElementById('foto').style.background = "red";
			}
			
		    if(estado == ""){
				ok = false;
				document.getElementById('estado').style.background = "red";
			}
			if(ok == true){
				
				document.getElementById("registroCamiseta").submit();
				
			}
				   
		}
function pintarFormulario(datos){
			document.getElementById("IdCamiseta").value = datos.idCamiseta; 
			document.getElementById("modelo").value = datos.modelo;
			document.getElementById("talla").value = datos.talla;
			document.getElementById("cantidad").value = datos.cantidad;
			document.getElementById("color").value = datos.color;
			document.getElementById("foto").value = datos.foto;
			document.getElementById("estado").value = datos.estado;



		}
		
		
		
		window.onload = function(){
			let id = getParameterByName("id");
			let op = getParameterByName("op");
			llamada(id,op);
			
		}
				
