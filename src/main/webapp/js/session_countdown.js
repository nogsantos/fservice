$(document).ready(function () {
    var doCount = function () {
        $('#countdown').each(function () {
            var count = parseInt($(this).html());            
            if (count !== 0) {
                if(count === 10){
                    $("#countdown-container").css("color","#D80000");
                }                                
                $(this).html(count - 1);
            } else {
                SessionExpireEvent();
            }
        });
    };
    setInterval(doCount, 1000);
    /**
     * End session action. 
     * 
     */
    function SessionExpireEvent() {
        alert("Session expired");
    }
});