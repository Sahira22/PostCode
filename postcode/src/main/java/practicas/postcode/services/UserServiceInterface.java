package practicas.postcode.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import practicas.postcode.shared.dto.UserDto;

public interface UserServiceInterface extends UserDetailsService {
    
    public UserDto createUser(UserDto user);

    
}
