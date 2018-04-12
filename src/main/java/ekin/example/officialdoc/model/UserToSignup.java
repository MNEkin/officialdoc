package ekin.example.officialdoc.model;

public class UserToSignup
{
    private String userEmail;
    private String password;
    private String userName;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String user_name)
    {
        this.userName = user_name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserEmail()
    {

        return userEmail;
    }

    public void setUserEmail(String user_email)
    {
        this.userEmail = user_email;
    }
}
