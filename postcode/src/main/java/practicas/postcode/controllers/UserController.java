package practicas.postcode.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicas.postcode.models.requests.UserDeatailsRequestModel;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

@GetMapping    
public String getUser(){

    return "get user details";
}


@PostMapping
public String createUser(@RequestBody UserDeatailsRequestModel userDetails){

    return "creating users";
}
}
