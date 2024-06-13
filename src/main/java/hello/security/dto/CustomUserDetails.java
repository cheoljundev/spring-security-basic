package hello.security.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {

    private final JoinDto user;

    private final List<GrantedAuthority> roles = new ArrayList<>();

    public CustomUserDetails(JoinDto user){
        this.user = user;
        roles.add(new SimpleGrantedAuthority(user.getUserRole()));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new SimpleGrantedAuthority(user.getUserRole()));
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
