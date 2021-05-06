package practicas.postcode.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import practicas.postcode.shared.dto.PostDto;
import practicas.postcode.shared.dto.UserDto;

public interface UserServiceInterface extends UserDetailsService {
    
    public UserDto createUser(UserDto user);

    public UserDto getUser(String username);

    public List<PostDto> getUserPosts(String email);

    public UserDto updateUser(String userId, UserDto userUpdate);
}
