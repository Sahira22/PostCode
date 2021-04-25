package practicas.postcode.models.responses;

import java.util.Date;

public  class PostRest {
    
    
private String postId;

private String title;

private String content;

private Date expiresAt;

private Date createdAt;

private boolean expired= false;

private UserRest user;

private ExposureRest exposure;


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

public boolean isExpired() {
    return expired;
}

public void setExpired(boolean expired) {
    this.expired = expired;
}

public UserRest getUser() {
    return user;
}

public void setUser(UserRest user) {
    this.user = user;
}

public ExposureRest getExposure() {
    return exposure;
}

public void setExposure(ExposureRest exposure) {
    this.exposure = exposure;
}



}


