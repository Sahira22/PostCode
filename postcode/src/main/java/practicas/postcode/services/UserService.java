package practicas.postcode.services;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import practicas.postcode.UserRepository;
import practicas.postcode.entities.UserEntity;
import practicas.postcode.shared.dto.UserDto;


@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired 
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {
        
        if(userRepository.findByEmail(user.getEmail()) != null)
        throw new RuntimeException("El usuario que desea insertar ya existe, por favor intente nuevamente");      
     
   
     UserEntity userEntity= new UserEntity();
     BeanUtils.copyProperties(user, userEntity);
    
     userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

     UUID userId=UUID.randomUUID();
     userEntity.setUserId(userId.toString());


     UserEntity storedUserDetails= userRepository.save(userEntity);


     UserDto userToReturn = new UserDto();
    BeanUtils.copyProperties(storedUserDetails, userToReturn);
        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity= userRepository.findByEmail(email);



          
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(), new ArrayList<>());
    }
    
}
