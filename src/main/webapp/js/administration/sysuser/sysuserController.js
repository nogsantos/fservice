/**
 * Controller form
 */
$app.controller('sysuserControllerForm', function ($scope, $http, $sce) {
    /**
     * Emails
     */
    $scope.emails = [
        {
            placeholder: "e-mail",
            id         : 1
        }
    ];
    $scope.addNewEmail = function () {
        var newItemNo = $scope.emails.length + 1;
        $scope.emails.push({
            placeholder: "e-mail",
            id         :  newItemNo
        });
    };
    /**
     * Removing role from user
     */
    $scope.rmRole = function(userId, roleId){
        if(confirm($("#alert-message").html())){
            $http.delete(
                $scope.server(
                    "/sysuser/deleterolebyuser/"+userId+"/"+roleId
                )
            ).success(function(data){
                window.location.reload();
            }).
            error(function() {
                $scope.showAjaxError = true;
            });
        }
    };
});
/*
 * Data table
 */
$(document).ready(function() {
    $('#sysUserTable').DataTable();
});