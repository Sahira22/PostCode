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

 private Date expires_at;

 private Date created_at;

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

public Date getExpires_at() {
    return expires_at;
}

public void setExpires_at(Date expires_at) {
    this.expires_at = expires_at;
}

public Date getCreated_at() {
    return created_at;
}

public void setCreated_at(Date created_at) {
    this.created_at = created_at;
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
