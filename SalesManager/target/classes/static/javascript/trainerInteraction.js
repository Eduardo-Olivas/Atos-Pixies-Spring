$(document).ready(
    $('.container-details-yes').hide(),
    $('#switch-for-trainer').click(
        function(){
            if($(this).is(':checked')){
                $('.container-details').hide();
                $('.container-details-yes').show();
            } else {
                $('.container-details').show();
                $('.container-details-yes').hide();
            }
        }
    )
);