package amp.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private List<String> roles;

    public LoginResponse(String token,List<String> roles){
        this.roles = roles;
        this.token = token;
    }
}
