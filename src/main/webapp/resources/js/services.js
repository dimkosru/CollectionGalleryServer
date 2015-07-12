/**
 * Created by Дмитрий on 12.07.2015.
 */
var collectionServices = angular.module('collectionServices', ['ngResource']);

collectionServices.factory('Bar', ['$resource',
    function($resource){
        return $resource('rest/bars/:barId', {}, {
            query: {method:'GET', params:{barId:'@barId'}, isArray:true}//gjbcr ,
            //post: {method:'POST'},
            //update: {method:'PUT'},
            //remove: {method:'DELETE'}
        });
    }]);