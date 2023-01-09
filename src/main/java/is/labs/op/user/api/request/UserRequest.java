package is.labs.op.user.api.request;


import lombok.Data;

@Data
public class UserRequest {

    String login;

    String email;

    String phoneNumber;

}
