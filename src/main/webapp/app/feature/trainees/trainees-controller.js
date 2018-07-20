"use strict";

(function() {

    var TraineeController =  function(traineeService, Data, $log, $state) {

        var vm = this;

        vm.isHidden = false;

        vm.hideTable = function()
        {
            vm.isHidden = !vm.isHidden
        };

        function init() {
            traineeService.getTrainees().then(function (results) {
                vm.trainees = results;
                $log.log("In the trainee controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.trainees));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        init();

        vm.passTrainee = function (data) {
            Data.setData(data);
            $state.go("furtherInfo", { obj:  vm.selectedTrainee });
        }

        vm.selectedTrainee = Data.getData();
    };

    angular.module('traineeApp').controller('traineeController', ['traineeService', 'Data','$log', '$state', TraineeController]);
}());