(function() {
    'use strict';

    angular
        .module('myStudentApp')
        .controller('FacultyDetailController', FacultyDetailController);

    FacultyDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Faculty', 'Student'];

    function FacultyDetailController($scope, $rootScope, $stateParams, previousState, entity, Faculty, Student) {
        var vm = this;

        vm.faculty = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('myStudentApp:facultyUpdate', function(event, result) {
            vm.faculty = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
