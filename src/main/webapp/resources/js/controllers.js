/**
 * Created by Дмитрий on 12.07.2015.
 */
var collectionControllers = angular.module('collectionControllers', []);

collectionControllers.controller('BarListCtrl', ['$scope', 'Bar',
    function ($scope, Bar) {
        $scope.filteredBars = []
            ,$scope.currentPage = 1
            ,$scope.numPerPage = 10
            ,$scope.maxSize = 5;
        $scope.brandIncludes = [];

        $scope.includeBrand = function(id) {
            var i = $.inArray(id, $scope.brandIncludes);
            if (i > -1) {
                $scope.brandIncludes.splice(i, 1);
            } else {
                $scope.brandIncludes.push(id);
            }
        }

        $scope.brandFilter = function(bar) {
            if ($scope.brandIncludes.length > 0) {
                if ($.inArray(bar.brand.id, $scope.brandIncludes) < 0)
                    return;
            }
            return bar;
        }

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