package hello.security.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class JoinDto {
    private String username;
    private String password;
    private String userRole;
}
