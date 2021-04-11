package practicas.postcode.models.requests;


public class UserDeatailsRequestModel {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

   
   
}
