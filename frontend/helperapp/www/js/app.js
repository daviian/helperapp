// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('helperapp', ['ionic', 'helperapp.controllers', 'helperapp.services', 'ngResource', 'ngCordova', 'ion-autocomplete','base64'])
  .constant('baseurl','http://localhost:8080/')
.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
})

.config(function($stateProvider, $urlRouterProvider,$httpProvider) {
  //Enable Cross Domain Calls
  $httpProvider.defaults.useXDomain = true;
  $httpProvider.interceptors.push('authInterceptor');

  $stateProvider
  .state('welcome', {
    url: '/welcome',
    templateUrl: 'templates/welcome.html',
    controller: 'AppCtrl',
    data: {
      requireLogin: false
    }
  })
  .state('registration', {
    url: '/registration',
    templateUrl: 'templates/registration.html',
    controller: 'RegistrationCtrl',
    data: {
      requireLogin: false
    }
  })
  .state('app', {
    url: '/app',
    abstract: true,
    templateUrl: 'templates/menu.html',
    controller: 'AppCtrl',
    data: {
      requireLogin: true // this property will apply to all children of 'app'
    }
  })
  .state('app.needs', {
    url:'/needs',
    abstract: true,
    views: {
      'menuContent': {
        templateUrl: 'templates/needs.html',
        controller: 'NeedsCtrl'
      }
    }
  })
  .state('app.needs.all',{
    url:'/all',
    views: {
      'all-tab': {
        templateUrl: 'templates/needs-list.html',
        controller: 'AllCtrl'
      }
    }
  })
  .state('app.needs.byme',{
    url:'/byme',
    views: {
      'byme-tab': {
        templateUrl: 'templates/needs-list.html',
        controller: 'ByMeCtrl'
      }
    }
  })
  .state('app.needs.forme',{
    url:'/forme',
    views: {
      'forme-tab': {
        templateUrl: 'templates/needs-list.html',
        controller: 'ForMeCtrl'
      }
    }
  })
  .state('app.needs.todo',{
    url:'/todo',
    views: {
      'todo-tab': {
        templateUrl: 'templates/needs-list.html',
        controller: 'ToDoCtrl'
      }
    }
  })
  .state('app.subscriptions', {
    url: '/subscriptions',
    views: {
      'menuContent': {
        templateUrl: 'templates/subscriptions.html',
        controller: 'SubscriptionCtrl'
      }
    }
  });
  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/welcome');
});

angular.module('helperapp.controllers', []);
angular.module('helperapp.services', []);
