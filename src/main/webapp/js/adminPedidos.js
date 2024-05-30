function llamada() {
	fetch('GestionCamisetaController')
		.then(response => response.json())
		.then(data => pintarTabla(data))

}

function borrarCamiseta(idCamiseta) {
	console.log(idCamiseta)
	fetch(`ActualizarPedidoController?idCamiseta=${idCamiseta}`, { method: "DELETE" })
	.then (response => {
		if (response.ok){
			llamada()
		}
	})
}

function pintarTabla(datos) {
	let html = "<table border=2>";

	for (let i = 0; i < datos.length; i++) {
		html += "<tr><td>" + datos[i].idCamiseta + "</td><td>" + datos[i].modelo + "</td>"
		html += "<td>" + datos[i].talla + "</td>"
		html += "<td>" + datos[i].cantidad + "</td>"
		html += "<td>" + datos[i].color + "</td>"
		html += "<td>" + datos[i].foto + "</td>"
		html += "<td>" + datos[i].estado + "</td>"
		html += "<td><a href='actualizarPedidos.html?id=" + datos[i].idCamiseta + "'>Editar</a></td><td><button onclick='borrarCamiseta(" + datos[i].idCamiseta + ")'>Borrar</button></td>"
		html += "</tr>"
	}

	html += "</table>";

	document.getElementById("pedido").innerHTML = html;
}

function busquedaPorTipo(tipoCamiseta) {

	fetch('GestionCamisetaController?op=4&tipoCamiseta=' + tipoCamiseta)
		.then(response => response.json())
		.then(data => pintarTabla(data))

}
window.onload = function() {
	llamada();
}
