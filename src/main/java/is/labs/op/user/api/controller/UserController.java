package is.labs.op.user.api.controller;

import is.labs.op.user.api.dto.FrontendUserDto;
import is.labs.op.user.api.request.UserRequest;
import is.labs.op.user.api.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public FrontendUserDto addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @PutMapping(value = "/{userId}")
    public FrontendUserDto updateUser(@RequestBody UserRequest userRequest, @PathVariable int userId){
        return userService.updateUser(userRequest,userId);
    }

    @GetMapping(value = "/{userId}")
    public FrontendUserDto getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }

    @DeleteMapping(value = "/{userId}")
    public FrontendUserDto deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }

}
