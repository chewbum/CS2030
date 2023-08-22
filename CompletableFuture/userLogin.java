public CompletableFuture<LoginStatus> userLogin(String username, String password) {
    if (this.loggedIn) {
        return CompletableFuture.<LoginStatus>completedFuture(new LoginStatus(true, "Already logged in"))
    } else {
        if (usernameExists(username) && isValidPassword(passoword)) {
            return CompletableFuture.<LoginStatus>supplyAsync(() -> {
                if (doLogin(username, password)) {
                    return new LoginStatus(true, "Login by password.");
                } else {
                    return new LoginStatus(false, "No Server Response");
                }
            })
        } else {
            return CompletableFuture.<LoginStatus>completedFuture(new LoginStatus(false, "Incorrect Username/Password"));
        }
    }
}