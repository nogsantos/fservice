/*
 * URL de acesso ao servidor RESTful
 */ 
SERVER_URL = "";
/*
 * Criação ao $app que é o modulo que representa toda a aplicação 
 */
var $app = angular.module("fService",['ngResource','ngRoute']);
/*
 * 
 */
$app.run(['$rootScope',function($rootScope){
    /*
     * Uma flag que define se o ícone de acesso ao servidor deve estar ativado
     */ 
    $rootScope.showLoaderFlag = false;
    /*
     * Força que o ícone de acesso ao servidor seja ativado
     */ 
    $rootScope.showLoader=function(){
        $rootScope.showLoaderFlag=true;
    };
    /*
     * Força que o ícone de acesso ao servidor seja desativado
     */
    $rootScope.hideLoader=function(){
        $rootScope.showLoaderFlag=false;
    };
    /*
     * Método que retorna a URL completa de acesso ao servidor. 
     * Evita usar concatenação
     */
    $rootScope.server=function(url){
        return SERVER_URL + url;
    };
}]);
/*
 * We already have a limitTo filter built-in to angular,
 * let's make a startFrom filter
 */
$app.filter('startFrom', function() {
    return function(input, start) {
        if (input===null){
            return null;
        }
        start = +start; //parse to int
        return input.slice(start);
    };
});
/**
 * JQuery
 */
$(function(){
    /**
     * Display current day on view
     */
    moment.locale('pt_BR');
    $("#info-time").html("Bem vindo! "+moment().format("dddd, D [de] MMMM [de] YYYY"));
    /**
     */
    $('#changePasswordForm').modal({
       show     : false,
       backdrop : 'static',
       keyboard : false
    });
    $('#changePasswordForm').on('show.bs.modal', function (event) {
        var button    = $(event.relatedTarget);
        var recipient = button.data('userid');
        var modal     = $(this);
        modal.find('.modal-title').text('Alteração de senha ' + recipient);
        modal.find('.modal-body input').val(recipient);
    });
    /**
     * Data table defaults
     */
    $.extend( $.fn.dataTable.defaults, {
        "language": {
            "url": "/libs/datatable/Portuguese-Brasil.json"
        }
    });
});