$(function () {
    // Admin Panel settings

    //****************************
    /* This is for the mini-sidebar if width is less then 1170*/
    //****************************
    var setsidebartype = function () {
        var width =
                window.innerWidth > 0 ? window.innerWidth : this.screen.width;
        if (width < 1199) {
            $("#main-wrapper").attr("data-sidebartype", "mini-sidebar");
            $("#main-wrapper").addClass("mini-sidebar");
        } else {
            $("#main-wrapper").attr("data-sidebartype", "full");
            $("#main-wrapper").removeClass("mini-sidebar");
        }
    };
    $(window).ready(setsidebartype);
    $(window).on("resize", setsidebartype);
    //****************************
    /* This is for sidebartoggler*/
    //****************************
    $(".sidebartoggler").on("click", function () {
        $("#main-wrapper").toggleClass("mini-sidebar");
        if ($("#main-wrapper").hasClass("mini-sidebar")) {
            $(".sidebartoggler").prop("checked", !0);
            $("#main-wrapper").attr("data-sidebartype", "mini-sidebar");
        } else {
            $(".sidebartoggler").prop("checked", !1);
            $("#main-wrapper").attr("data-sidebartype", "full");
        }
    });
    $(".sidebartoggler").on("click", function () {
        $("#main-wrapper").toggleClass("show-sidebar");
    });
})

function borrar(idBorrar) {
    var mensaje = "¿Estás seguro de que deseas continuar, se perdera la informacion de esta persona?";
    var resultado = confirm(mensaje);

    // Verificar la respuesta del usuario
    if (resultado) {
        window.location.href = '/persona/borrarpersona?idpersona=' + idBorrar;
        setTimeout(function () {
            location.reload();
        }, 500);
    } else {
        // Se hizo clic en "Cancelar"
        console.log("El usuario ha cancelado el mensaje de confirmación");
        // Aquí puedes agregar el código para el caso en que el usuario cancele el mensaje
    }
}

function restEliminar(idEliminar) {
    //th:href="@{/persona/borrarpersona?idpersona=__${per.idPersona}__}"
    $.ajax({
        url: "/persona/borrarpersona?idpersona=" + idEliminar,
        dataType: "json",
        data: {
        },
        success: function (data) {
            console.log("se elimino!!");
        }
    });
}