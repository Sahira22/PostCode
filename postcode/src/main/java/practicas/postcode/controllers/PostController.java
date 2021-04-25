package practicas.postcode.controllers;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicas.postcode.models.requests.PostCreateRequestModel;
import practicas.postcode.models.responses.PostRest;
import practicas.postcode.services.PostServiceInterface;
import practicas.postcode.shared.dto.PostCreationDto;
import practicas.postcode.shared.dto.PostDto;

@RestController
@RequestMapping("/post") //localhost:8080/users
public class PostController {
/**Metodo del controlador, puede ser GET,POST,PUT, DELETE. El resquestbody son los datos que se traeran desde el cliente que vienen definidos por el PostModel */
    @Autowired
    PostServiceInterface postService;
    
    @Autowired
    ModelMapper  mapper; //Aqui se cre una instancia global por lo cual no hay que instanciar en cada metodo, esto se define como Bean en el POSTCODE//
   
   
    @PostMapping
    public PostRest createPost(@RequestBody PostCreateRequestModel createRequestModel){
    
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
}
