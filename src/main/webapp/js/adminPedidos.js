      function llamada(){
        fetch('GestionCamisetaController')
        .then(response => response.json())
        .then(data => pintarTabla(data))

      }

      function pintarTabla(datos){
        let html = "<table border=2>";

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