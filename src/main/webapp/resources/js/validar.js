jQuery('#form\\:bt').click(function () {
    alert('elemento foi clicado');
});


jQuery(".datepicker").datepicker({
    showAnim: "blind",
    buttonImage: "images/calendar.gif",
    dateFormat:  "dd-mm-yy" ,
    buttonImageOnly: true})


function zeraForm() {
    jQuery('#camposComputador').hide();
    jQuery('#rowEst').hide();
    jQuery('#rowServ').hide();
    jQuery('#rowNot').hide();
    jQuery('#form\\:SelectMenuServidor').hide();
    jQuery('#form\\:SelectMenuEstacao').hide();
}

window.onload = function () {
    var url = window.location.href.toString();
    var result = url.split("=", 2);
    var console = result[1];



    if (console == "1") {
        jQuery('#form\\:consolePc').show();

    }


}

function habilitaForm(tipo) {

    this.zeraForm();

    jQuery('#content').show();
    jQuery('.camposGerais').show();

    switch (tipo) {
        case "estacao":
            jQuery('#camposComputador').show();
            jQuery('#rowEst').show();
            jQuery('#form\\:SelectMenuEstacao').show();
            break;
        case "servidor":
            jQuery('#camposComputador').show();
            jQuery('#rowServ').show();
            jQuery('#form\\:SelectMenuServidor').show();
            break;
        case "notebook":
            jQuery('#camposComputador').show();
            jQuery('#rowNot').show();
            jQuery('#form\\:SelectMenuEstacao').show();
            break;

    }
}

function habilitaFormPrime(tipo) {

    jQuery('#form\\:gridPrincipal').show();
}


jQuery("#form\\:myInput").on("keyup", function() {

    var value = jQuery(this).val().toLowerCase();
    jQuery("#form\\:myTable tr").filter(function() {
        jQuery(this).toggle(jQuery(this).text().toLowerCase().indexOf(value) > -1)
    });
});