package practicas.postcode.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name= "user")
public class UserEntity implements Serializable {


private static final long serialVersionUID = 1L;




@Id
@GeneratedValue
private long id;

@Column(nullable = false)
private String userId;

@Column(nullable = false, length = 250)
private String firstName;

@Column(nullable = false, length = 50)
private String lastName;

@Column(nullable = false, length = 255)
private String email;

@Column(nullable = false)
private String password;

@Column(nullable = false)
private String encryptedPassword;



public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getUserId() {
    return userId;
}

public void setUserId(String userId) {
    this.userId = userId;
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

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getEncryptedPassword() {
    return encryptedPassword;
}

public void setEncryptedPassword(String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
}

    
}
