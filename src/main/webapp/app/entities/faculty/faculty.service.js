(function() {
    'use strict';
    angular
        .module('myStudentApp')
        .factory('Faculty', Faculty);

    Faculty.$inject = ['$resource'];

    function Faculty ($resource) {
        var resourceUrl =  'api/faculties/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
