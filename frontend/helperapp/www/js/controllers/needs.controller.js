/**
 * Created by MiiKE on 14.11.2015.
 */
angular.module('starter.controllers')
.controller('NeedsCtrl',function($scope) {

})
  .controller('ByMeCtrl',function($scope) {
    $scope.needs = [
      {id: 1, owner: "By Me", tags:[{name:'Sessel'},{name:'Stühle'}], amount: '200 Stk.'},
      {id: 2, owner: "By Me", tags:[{name:'Essen'},{name:'Babynahrung'}], amount: '50 Stk.'}
    ]
  })
  .controller('ForMeCtrl',function($scope) {
    $scope.needs = [
      {id: 1, owner: "Caritas", tags:[{name:'Sessel'},{name:'Stühle'}], amount: '200 Stk.'},
      {id: 2, owner: "Diakonie", tags:[{name:'Essen'},{name:'Babynahrung'}], amount: '50 Stk.'}
    ]
  })
  .controller('ToDoCtrl',function($scope) {
    $scope.needs = [
      {id: 1, owner: "Caritas", tags:[{name:'Sessel'},{name:'Stühle'}], amount: '200 Stk.'}

    ]
  });