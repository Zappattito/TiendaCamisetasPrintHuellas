

function pintarFormulario(datos) {


	let html = `<h1>Edita tus datos:</h1>
        <hr>    
       

        <form action="ActualizarUsuarioController" method="post" id="actualizarDatos" enctype="multipart/form-data" >
        
                <input type="hidden"  id="idUsuario" name="idUsuario" value="${datos.idUsuario}">
                
             <div class="form-group">
                <label for="nombre"><h3>Nombre:</h3></label>
                <input type="text" id="nombre" name="nombre" value="${datos.nombre}">
            </div>
       
    
            
            <div class="form-group">
                <label for="correo"><h3>Correo Electronico:</h3></label>
                <input type="text" id="correo" name="correo" value="${datos.correo}">
            </div>
            
           
            
            <div class="form-group">
                <label for="contrasena"><h3>Contraseña:</h3></label>
                <input type="text" id="contrasena" name="contrasena" value="${datos.contrasena}">
            </div>
           
            <div class="form-group">
                <label for="foto"><h3>Foto:</h3></label>
                <input type="file" id="foto" name="foto" accept="image/*" value="${datos.foto}">
            </div>
            
             <div class="form-group">
                <label for="permiso"><h3>Permiso:</h3></label>
                <input type="text" id="permiso" name="permiso" value="${datos.permiso}" readonly>
            </div>
            
           
            <input type= "button" onclick="actualizarUsuario(${datos.idUsuario})" value= "Editar"> 
		</hr>
        </form>`

	document.getElementById("actualizarDatos").innerHTML = html;


}
function llamada(idUsuario) {
	fetch('ActualizarUsuarioController?id=' + idUsuario)
		.then(response => response.json())
		.then(data => pintarFormulario(data))

}


function actualizarUsuario(idUsuario){
	
	const nombre = document.getElementById("nombre").value;
	const correo = document.getElementById("correo").value;
	const contrasena = document.getElementById("contrasena").value;
	const foto = document.getElementById("foto").value;
	const permiso = document.getElementById("permiso").value;
	
	fetch(`ActualizarUsuarioController?idUsuario=${idUsuario}&nombre=${nombre}&correo=${correo}&contrasena=${contrasena}&foto=${foto}&permiso=${permiso}&`, { method: "PUT" })
	
	.then(response => {
  	if(response.ok) {
	window.history.back()
}
})

	
}

window.onload = function() {
	var urlParams = new URLSearchParams(window.location.search);
	var idUsuario = urlParams.get('id');

	llamada(idUsuario);
}

