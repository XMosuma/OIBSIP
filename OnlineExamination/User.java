package OnlineExamination;

class User {

    private String username;
    private String password;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword)
    {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public void updateProfile(String newUsername, String newPassword) 
    {
        this.username = newUsername;
        this.password = newPassword;
    }
}
