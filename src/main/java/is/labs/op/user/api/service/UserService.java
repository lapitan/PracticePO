package is.labs.op.user.api.service;

import is.labs.op.user.api.dto.FrontendUserDto;
import is.labs.op.user.api.request.UserRequest;

public interface UserService {
    FrontendUserDto addUser(UserRequest userRequest);
    FrontendUserDto updateUser(UserRequest userRequest, int cartId);
    FrontendUserDto getUser(int cartId);
    FrontendUserDto deleteUser(int cartId);
}
