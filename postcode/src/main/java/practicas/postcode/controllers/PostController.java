package practicas.postcode.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicas.postcode.models.requests.PostCreateRequestModel;
import practicas.postcode.models.responses.OperationStatusModel;
import practicas.postcode.models.responses.PostRest;
import practicas.postcode.services.PostServiceInterface;
import practicas.postcode.services.UserServiceInterface;
import practicas.postcode.shared.dto.PostCreationDto;
import practicas.postcode.shared.dto.PostDto;
import practicas.postcode.shared.dto.UserDto;

@RestController
@RequestMapping("/posts") //localhost:8080/posts
public class PostController {
/**Metodo del controlador, puede ser GET,POST,PUT, DELETE. El resquestbody son los datos que se traeran desde el cliente que vienen definidos por el PostModel */
    @Autowired
    PostServiceInterface postService;
    
    @Autowired
    UserServiceInterface userService;

    @Autowired
    ModelMapper  mapper; //Aqui se cre una instancia global por lo cual no hay que instanciar en cada metodo, esto se define como Bean en el POSTCODE//
   
    
   
    @PostMapping
    public PostRest createPost(@RequestBody PostCreateRequestModel createRequestModel){
    
        //Autenticando con el token que se genera al iniciar session para que se le sea permitido realizar aaciones
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getPrincipal().toString();

        
        PostCreationDto postCreationDto = mapper.map(createRequestModel, PostCreationDto.class);

        postCreationDto.setUserEmail(email);

        PostDto postDto = postService.createPost(postCreationDto);

         PostRest postToReturn = mapper.map(postDto, PostRest.class);

        // /Comparando la fecha para definir si el post esta expirado / 
         if(postToReturn.getExpiresAt().compareTo(new Date(System.currentTimeMillis()))<0){

            postToReturn.setExpired(true);
         }
        return postToReturn;
}

@GetMapping(path = "/last") // localhost:8080/posts/last
public List<PostRest> lastPosts() {
    List<PostDto> posts = postService.getLastPosts(); //Se carga desde los servicios de tipo interface

    List<PostRest> postRests = new ArrayList<>();

    //Ciclo para cargar los datos de cada post. Viene con los datos del user y exposure
    for (PostDto post : posts) {
        PostRest postRest = mapper.map(post, PostRest.class);
        postRests.add(postRest);
    }

    return postRests;
}

@GetMapping(path = "/{id}") // localhost:8080/posts/uuid
public PostRest getPost(@PathVariable String id) {

    PostDto postDto = postService.getPost(id);

    PostRest postRest = mapper.map(postDto, PostRest.class);

     //VALIDAR SI EL POST ES PRIVADO O SI EL POST YA EXPIRO, para cualquiera de los dos el usuario debe tener autentificacion
     if (postRest.getExposure().getId() == 1|| postRest.getExpired()) {
   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         UserDto user = userService.getUser(authentication.getPrincipal().toString());

        if (user.getId() != postDto.getUser().getId()) {//Si el usuario no es el mismo que realiza el post no podra verlo
            throw new RuntimeException("No tienes permisos para realizar esta accion");
        }
 }

    return postRest;
}


 @DeleteMapping(path = "/{id}")
    public OperationStatusModel deletePost(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDto user = userService.getUser(authentication.getPrincipal().toString());

        OperationStatusModel operationStatusModel = new OperationStatusModel();
        operationStatusModel.setName("DELETE");

        postService.deletePost(id, user.getId());
        operationStatusModel.setResult("SUCCESS");

        return operationStatusModel;
       
       
    }


    @PutMapping(path = "/{id}")
    public PostRest updatePost(@RequestBody PostCreateRequestModel postCreateRequestModel,
            @PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDto user = userService.getUser(authentication.getPrincipal().toString());

        PostCreationDto postUpdateDto = mapper.map(postCreateRequestModel, PostCreationDto.class);

        PostDto postDto = postService.updatePost(id, user.getId(), postUpdateDto);

        PostRest updatedPost = mapper.map(postDto, PostRest.class);

        return updatedPost;
    }

}

     


