	function initMap() {

	   var lati = parseFloat(document.getElementById('latitud').value); 	   
	   var lngt = parseFloat(document.getElementById('longitud').value); 	 
	   
        var uluru = {lat:lati , lng:lngt };
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
	       