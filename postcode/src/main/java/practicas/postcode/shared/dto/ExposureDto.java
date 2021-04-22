package practicas.postcode.shared.dto;

import java.io.Serializable;
import java.util.List;

public class ExposureDto implements Serializable {


    private static final long serialVersionUID = 1L;

    private long id;

    private String type;

    private List<PostDto> posts;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }
    
}
