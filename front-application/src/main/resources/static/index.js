
angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contentPath = 'http://localhost:5555/cloud/feign'

    $scope.Products = [{id: null, title: '', price: null}]


    $scope.fillProducts = function () {
        $http({
            url: contentPath + '/products',
            method: 'GET'
        }).then(function (response) {
            $scope.Products = response.data;
        });
    };

    $scope.fillProducts();
});

