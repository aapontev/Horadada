	function initMap() {

	   var lati = parseFloat(document.getElementById('latitud').value); 	   
	   var lngt = parseFloat(document.getElementById('longitud').value); 	 
	   
	   // Map options
	      var options = {
	        zoom:16,
	        center:{lat: lati ,lng: lngt}
	      }

	      // New map
	      var map = new google.maps.Map(document.getElementById('map'), options);

	      // Listen for click on map
	      google.maps.event.addListener(map, 'click', function(event){
	        // Add marker
	        addMarker({coords:event.latLng});
	      });


	      // Array of markers
	      var markers = [
	        {
	          coords:{lat:lati,lng:lngt},
	          iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
	          content:'<h1>HORADADA</h1>'
	        }
	       
	      ];

	      // Loop through markers
	      for(var i = 0;i < markers.length;i++){
	        // Add marker
	        addMarker(markers[i]);
	      }

	      // Add Marker Function
	      function addMarker(props){
	        var marker = new google.maps.Marker({
	          position:props.coords,
	          map:map,
	          //icon:props.iconImage
	        });

	        // Check for customicon
	        if(props.iconImage){
	          // Set icon image
	          marker.setIcon(props.iconImage);
	        }

	        // Check content
	        if(props.content){
	          var infoWindow = new google.maps.InfoWindow({
	            content:props.content
	          });

	          marker.addListener('click', function(){
	            infoWindow.open(map, marker);
	          });
	        }
      }
	}
	
	/*function sumadias() {

		var fecha = document.getElementById('fechainicio').value;
		var dia= fecha.substr(0,2)
		var mes = fecha.substr(3,2);
		var año = fecha.substr(6,4);
		   var fecha2 = new Date(mes + "/" + dia + "/" + año); 
		   var diasasumar = document.getElementById('diasestimados').value; 
		   var fechanueva = fecha2 + diasasumar;
		   document.getElementById('fechafin').value = fechanueva;
		   return fechanueva;
		   
		   Date.prototype.addDays = function(days) {
  var dat = new Date(this.valueOf());
  dat.setDate(dat.getDate() + days);
  return dat;
}

var dat = new Date();

alert(dat.addDays(5))
		   
	}
	