package hello.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter @Setter @ToString
public class CustomUser extends User {
    private final String role;
    public CustomUser(JoinDto joinDto, Collection<? extends GrantedAuthority> authorities) {
        super(joinDto.getUsername(), joinDto.getPassword(), authorities);
        this.role = joinDto.getUserRole();
    }

}
