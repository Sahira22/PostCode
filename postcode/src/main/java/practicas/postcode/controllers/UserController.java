package practicas.postcode.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicas.postcode.models.requests.UserDeatailsRequestModel;
import practicas.postcode.models.responses.UserRest;
import practicas.postcode.services.UserServiceInterface;
import practicas.postcode.shared.dto.UserDto;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

@Autowired
UserServiceInterface userService;

@GetMapping    
public String getUser(){

    return "get user details";
}


@PostMapping
public UserRest createUser(@RequestBody UserDeatailsRequestModel userDetails){

UserRest userToReturn= new UserRest();

UserDto userDto= new UserDto();

BeanUtils.copyProperties(userDetails, userDto);

UserDto createdUser= userService.createUser(userDto);

BeanUtils.copyProperties(createdUser, userToReturn);

return userToReturn;
}
}
