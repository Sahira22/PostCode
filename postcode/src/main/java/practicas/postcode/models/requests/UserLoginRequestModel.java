package practicas.postcode.models.requests;


public class UserLoginRequestModel {

    private String email;
    private String password;

    
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}