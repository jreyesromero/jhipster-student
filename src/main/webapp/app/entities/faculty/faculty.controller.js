(function() {
    'use strict';

    angular
        .module('myStudentApp')
        .controller('FacultyController', FacultyController);

    FacultyController.$inject = ['$scope', '$state', 'Faculty'];

    function FacultyController ($scope, $state, Faculty) {
        var vm = this;

        vm.faculties = [];

        loadAll();

        function loadAll() {
            Faculty.query(function(result) {
                vm.faculties = result;
                vm.searchQuery = null;
            });
        }
    }
})();
