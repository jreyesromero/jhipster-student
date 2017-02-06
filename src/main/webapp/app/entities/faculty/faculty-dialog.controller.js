(function() {
    'use strict';

    angular
        .module('myStudentApp')
        .controller('FacultyDialogController', FacultyDialogController);

    FacultyDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Faculty', 'Student'];

    function FacultyDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Faculty, Student) {
        var vm = this;

        vm.faculty = entity;
        vm.clear = clear;
        vm.save = save;
        vm.students = Student.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.faculty.id !== null) {
                Faculty.update(vm.faculty, onSaveSuccess, onSaveError);
            } else {
                Faculty.save(vm.faculty, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('myStudentApp:facultyUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
