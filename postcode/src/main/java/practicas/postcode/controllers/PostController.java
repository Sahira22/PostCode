package practicas.postcode.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicas.postcode.models.requests.PostCreateRequestModel;

@RestController
@RequestMapping("/post") //localhost:8080/users
public class PostController {
/**Metodo del controlador, puede ser GET,POST,PUT, DELETE. El resquestbody son los datos que se traeran desde el cliente que vienen definidos por el PostModel */
    
    @PostMapping
    public String createPost(@RequestBody PostCreateRequestModel createRequestModel){
    


        return createRequestModel.getTitle();
}
}