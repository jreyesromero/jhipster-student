(function() {
    'use strict';

    angular
        .module('myStudentApp')
        .controller('FacultyDeleteController',FacultyDeleteController);

    FacultyDeleteController.$inject = ['$uibModalInstance', 'entity', 'Faculty'];

    function FacultyDeleteController($uibModalInstance, entity, Faculty) {
        var vm = this;

        vm.faculty = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Faculty.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
