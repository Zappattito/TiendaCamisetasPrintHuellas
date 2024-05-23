

function pintarFormulario(datos) {


	let html = `<h1>Edita Pedido:</h1>
        <hr>    
       

        <form action="ActualizarPedidoController" method="post" id="actualizarDatos" enctype="multipart/form-data" >
        
                <input type="hidden"  id="idCamiseta" name="idCamiseta" value="${datos.idCamiseta}">
                
             <div class="form-group">
                <label for="modelo"><h3>Modelo:</h3></label>
                <input type="text" id="modelo" name="modelo" value="${datos.modelo}">
            </div>
       
    
            
            <div class="form-group">
                <label for="talla"><h3>Talla:</h3></label>
                <input type="text" id="talla" name="talla" value="${datos.talla}">
            </div>
            
           
            
            <div class="form-group">
                <label for="cantidad"><h3>Cantidad:</h3></label>
                <input type="text" id="cantidad" name="cantidad" value="${datos.cantidad}">
            </div>
            
             <div class="form-group">
                <label for="color"><h3>Color:</h3></label>
                <input type="text" id="color" name="color" value="${datos.color}" readonly>
            </div>
           
            <div class="form-group">
                <label for="foto"><h3>Foto:</h3></label>
                <input type="file" id="foto" name="foto" accept="image/*" value="${datos.foto}">
            </div>
            
             <div class="form-group">
                <label for="estado"><h3>Estado:</h3></label>
                <input type="text" id="estado" name="estado" value="${datos.estado}" >
            </div>
            
           
            <input type= "button" onclick="actualizarCamiseta(${datos.idCamiseta})" value= "Editar"> 
		</hr>
        </form>`

	document.getElementById("actualizarDatos").innerHTML = html;

}    
function llamada(idCamiseta) {
	fetch('ActualizarPedidoController?id=' + idCamiseta)
		.then(response => response.json())
		.then(data => pintarFormulario(data))

}


function actualizarCamiseta(idCamiseta){
	
	const modelo = document.getElementById("modelo").value;
	const talla = document.getElementById("talla").value;
	const cantidad = document.getElementById("cantidad").value;
	const color = document.getElementById("color").value
	const foto = document.getElementById("foto").value;
	const estado = document.getElementById("estado").value;
	
	fetch(`ActualizarPedidoController?idCamiseta=${idCamiseta}&modelo=${modelo}&talla=${talla}&cantidad=${cantidad}&color=${color}&foto=${foto}&estado=${estado}&`, { method: "PUT" })
	
	.then(response => {
  	if(response.ok) {
	window.history.back()
}
})

	
}

window.onload = function() {
	var urlParams = new URLSearchParams(window.location.search);
	var idCamiseta = urlParams.get('id');

	llamada(idCamiseta);
}

     
     
     
     
  