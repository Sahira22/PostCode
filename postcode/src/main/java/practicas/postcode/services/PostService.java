package practicas.postcode.services;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practicas.postcode.entities.ExposureEntity;
import practicas.postcode.entities.PostEntity;
import practicas.postcode.entities.UserEntity;
import practicas.postcode.repositories.ExposureRepository;
import practicas.postcode.repositories.PostRepository;
import practicas.postcode.repositories.UserRepository;
import practicas.postcode.shared.dto.PostCreationDto;
import practicas.postcode.shared.dto.PostDto;

@Service
public class PostService implements PostServiceInterface{
    
@Autowired
PostRepository postRepository;

@Autowired
UserRepository userRepository;

@Autowired
ExposureRepository exposureRepository;

@Autowired
ModelMapper mapper;

@Override
public PostDto createPost(PostCreationDto post){

    UserEntity userEntity = userRepository.findByEmail(post.getUserEmail());
        ExposureEntity exposureEntity = exposureRepository.findById(post.getExposureId());

        PostEntity postEntity = new PostEntity();
        postEntity.setUser(userEntity);
        postEntity.setExposure(exposureEntity);
        postEntity.setTitle(post.getTitle());
        postEntity.setContent(post.getContent());
        postEntity.setPostId(UUID.randomUUID().toString());
        postEntity.setExpiresAt(new Date(System.currentTimeMillis() + (post.getExpirationTime() * 60000)));
   
        PostEntity createdPost = postRepository.save(postEntity);


        PostDto postToReturn = mapper.map(createdPost, PostDto.class);

        return postToReturn;
}
}
