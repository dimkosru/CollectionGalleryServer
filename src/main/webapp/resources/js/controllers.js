/**
 * Created by Дмитрий on 12.07.2015.
 */
var collectionControllers = angular.module('collectionControllers', []);

collectionControllers.controller('BarListCtrl', ['$scope', 'Bar',
    function($scope, Bar) {
        $scope.bars = Bar.query();
        $scope.orderProp = 'name';
    }]);

collectionControllers.controller('BarDetailCtrl', ['$scope', '$routeParams', 'Bar',
    function($scope, $routeParams, Bar) {
        $scope.bar = Bar.get({barId: $routeParams.barId});
    }]);