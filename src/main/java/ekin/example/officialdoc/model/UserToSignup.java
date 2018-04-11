package ekin.example.officialdoc.model;

public class UserToSignup
{
    private String user_email;
    private String password;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUser_email()
    {

        return user_email;
    }

    public void setUser_email(String user_email)
    {
        this.user_email = user_email;
    }
}
