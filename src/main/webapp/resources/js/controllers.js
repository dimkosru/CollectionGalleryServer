/**
 * Created by Дмитрий on 12.07.2015.
 */
var collectionControllers = angular.module('collectionControllers', []);

collectionControllers.controller('BarListCtrl', ['$scope', 'Bar',
    function ($scope, Bar) {

        // callback for ng-click 'deleteBar':
        $scope.deleteBar = function (barId) {
            Bar.remove({barId: barId}, function(){
                $scope.bars = Bar.query();
            });
        };

        $scope.bars = Bar.query();
        $scope.orderProp = 'name';
    }]);

collectionControllers.controller('BarDetailCtrl', ['$scope', '$routeParams', 'Bar',
    function ($scope, $routeParams, Bar) {
        $scope.bar = Bar.get({barId: $routeParams.barId});
    }]);