'use strict';

var bLib = angular.module('bLib', [], function($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
});
