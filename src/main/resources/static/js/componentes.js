	function initMap() {

	   var lati = -12.046975110896387;//parseFloat(document.getElementById('latitud').value); 	   
	   var lngt = -77.0433212872066;//parseFloat(document.getElementById('longitud').value); 	 
	   
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
	

	