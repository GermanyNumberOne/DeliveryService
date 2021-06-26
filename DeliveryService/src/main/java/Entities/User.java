package Entities;


public class User {
    private String password = "password";
    private String login = "user";

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }

}
