package practicas.postcode.shared.dto;

import java.io.Serializable;
import java.util.Date;

import practicas.postcode.entities.ExposureEntity;
import practicas.postcode.entities.UserEntity;

public class PostDto implements Serializable {


 private static final long serialVersionUID = 1L;

  
 
 private long id;

 private String postId;

 private String title;

 private String content;

 private Date expiresAt;

 private Date createdAt;

 private UserEntity user;

 private ExposureEntity exposure;

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getPostId() {
    return postId;
}

public void setPostId(String postId) {
    this.postId = postId;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}


public Date getExpiresAt() {
    return expiresAt;
}

public void setExpiresAt(Date expiresAt) {
    this.expiresAt = expiresAt;
}

public Date getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
}

public UserEntity getUser() {
    return user;
}

public void setUser(UserEntity user) {
    this.user = user;
}

public ExposureEntity getExposure() {
    return exposure;
}

public void setExposure(ExposureEntity exposure) {
    this.exposure = exposure;
}



 


}
