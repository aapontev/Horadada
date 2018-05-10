function initMap() {
    
    var uluru = { lat: parseFloat(-11.978158), lng: parseFloat(-77.016725) };
        var map = new google.maps.Map(document.getElementById('lienzoMapa'), {
            zoom: 18,
            center: uluru
        });
        var marker = new google.maps.Marker({
            position: uluru,
            map: map
        });
    }
