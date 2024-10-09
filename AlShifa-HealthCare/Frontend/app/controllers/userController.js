// app/controllers/userController.js
app.controller('UserController', function(UserService) {
    var self = this;
    self.users = [];

    self.loadUsers = function() {
        UserService.getUsers()
            .then(function(response)) {
                self.users = response.data;
            })
            .catch(function(error) {
                console.error('Error loading users', error);
            });
    };

    // Load users on controller initialization
    self.loadUsers();
});