package practicas.postcode.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicas.postcode.models.requests.UserDeatailsRequestModel;
import practicas.postcode.models.responses.PostRest;
import practicas.postcode.models.responses.UserRest;
import practicas.postcode.services.UserServiceInterface;
import practicas.postcode.shared.dto.PostDto;
import practicas.postcode.shared.dto.UserDto;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

@Autowired
UserServiceInterface userService;

@Autowired
ModelMapper  mapper; //Aqui se cre una instancia global por lo cual no hay que instanciar en cada metodo, esto se define como Bean en el POSTCODE//


@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })   //Esto es para devolver en tipo xml el objeto
public UserRest getUser(){

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    String email = authentication.getPrincipal().toString();

    UserDto userDto = userService.getUser(email);

    UserRest userToReturn = new UserRest();

    BeanUtils.copyProperties(userDto, userToReturn); //BeanUtils permite copiar los datos de un tipo de objeto a otro

    return userToReturn;
}


@PostMapping//Crear usuario
public UserRest createUser(@RequestBody UserDeatailsRequestModel userDetails){

  UserRest userToReturn= new UserRest();

  UserDto userDto= new UserDto();

  BeanUtils.copyProperties(userDetails, userDto);

  UserDto createdUser= userService.createUser(userDto);

  BeanUtils.copyProperties(createdUser, userToReturn);

    return userToReturn;

    }

    //Ver los posts de el usuario que esta loggeado
    @GetMapping(path = "/posts") // localhost:8080/users/posts
    public List<PostRest> getPosts() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getPrincipal().toString();

        List<PostDto> posts = userService.getUserPosts(email);

        List<PostRest> postRests = new ArrayList<>();

        for (PostDto post : posts) {
            PostRest postRest = mapper.map(post, PostRest.class);
            if (postRest.getExpiresAt().compareTo(new Date(System.currentTimeMillis())) < 0) {
                postRest.setExpired(true);
            }
            postRests.add(postRest);
        }

        return postRests;
    }

    @PutMapping(path = "/{userId}")
    public UserRest updateUser(@RequestBody UserDeatailsRequestModel userDetails,  @PathVariable String userId ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getPrincipal().toString();

        //UserDto user = userService.getUser(authentication.getPrincipal().toString());
        /** Recibo los datos segun el modelo,se mapean para una clase Dto. Luego con el servicio 
        realizo la transformacion haciendo uso del repositorio para que se guarde como entidad*/
           UserDto userUpdate= mapper.map(userDetails,UserDto.class );
           
            UserDto userDto= userService.updateUser(userId, userUpdate);

            UserRest userUpdated=mapper.map(userDto, UserRest.class);
        
        return userUpdated;

    }
}
