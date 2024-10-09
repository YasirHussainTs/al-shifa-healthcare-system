//app/services/userService.js
app.service('UserService', function($http)){
    this.getUsers = function(){
        return $http.get('http://localhost:8080/api/users'); // Replace with your actual endpoint
    };
});