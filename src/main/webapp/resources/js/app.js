/**
 * Created by Дмитрий on 12.07.2015.
 */
var phonecatApp = angular.module('collectionApp', [
    'ngRoute',
    'collectionControllers',
    'collectionServices',
    'angular.filter',
    'ui.bootstrap'
]);

phonecatApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/bars', {
                templateUrl: 'resources/partials/bar-list.html',
                controller: 'BarListCtrl'
            }).
            when('/bars/:barId', {
                templateUrl: 'resources/partials/bar-detail.html',
                controller: 'BarDetailCtrl'
            }).
            otherwise({
                redirectTo: '/bars'
            });
    }]);