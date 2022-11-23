package is.labs.op.user.impl.service;

import is.labs.op.user.api.dto.FrontendUserDto;
import is.labs.op.user.api.request.UserRequest;
import is.labs.op.user.api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public FrontendUserDto addUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public FrontendUserDto updateUser(UserRequest userRequest, int cartId) {
        return null;
    }

    @Override
    public FrontendUserDto getUser(int cartId) {
        return null;
    }

    @Override
    public FrontendUserDto deleteUser(int cartId) {
        return null;
    }
}
