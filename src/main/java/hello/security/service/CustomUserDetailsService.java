package hello.security.service;

import hello.security.dao.JoinMapper;
import hello.security.dto.CustomUser;
import hello.security.dto.CustomUserDetails;
import hello.security.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final JoinMapper joinMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        JoinDto user = joinMapper.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("회원 찾을 수 없음");
        }


        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(user.getUserRole()));
//        return  new CustomUser(user, authorityList);
//        return new User(user.getUsername(),
//                user.getPassword(),
//                authorityList);
        return new CustomUserDetails(user);
    }
}
