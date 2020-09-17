//import * as $ from 'jquery';

    function successAlertDismis(){
        $("#success-alert").css({  'opacity' : '' });
        $('#success-alert').show();
        window.setTimeout(function() {
            $("#success-alert").fadeTo(500, 0).slideUp(500, function(){
                //$("#success-alert").hide(); 
                $("#success-alert").addClass("alert-success");
            });
        }, 5000);
    }

    function dangerAlertDismis(){
        $("#alert-danger").css({  'opacity' : '' });
        $('#alert-danger').show();
        window.setTimeout(function() {
            $("#alert-danger").fadeTo(500, 0).slideUp(500, function(){
                $("#alert-danger").hide(); 
                
            });
        }, 5000);
    }
   
    function closeModel(){
        $("#myModal").modal("hide");
    }
