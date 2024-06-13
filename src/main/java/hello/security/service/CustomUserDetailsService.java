package hello.security.service;

import hello.security.dao.JoinMapper;
import hello.security.dto.CustomUserDetails;
import hello.security.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        return new CustomUserDetails(user);
    }
}
