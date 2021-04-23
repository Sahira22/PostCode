package practicas.postcode.services;

import practicas.postcode.shared.dto.PostCreationDto;
import practicas.postcode.shared.dto.PostDto;

public interface PostServiceInterface {
    
    public PostDto createPost(PostCreationDto post);

}
