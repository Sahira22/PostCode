package practicas.postcode.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name= "posts")
@EntityListeners(AuditingEntityListener.class)
public class PostEntity implements Serializable {

    private static final long serialVersionUID = 1L;

  
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String postId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false,columnDefinition="TEXT")
    private Date expiresAt;

    @CreatedDate/**Esto es para que se genere automaticamente la fecha cuando se crea un post */
    private Date createdAt;


    @ManyToOne
    @JoinColumn(name="user_id") /**Relacionando tablas por Joins de user */
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="exposure_id")
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
