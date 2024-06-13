package hello.security.service;

import hello.security.dao.JoinMapper;
import hello.security.dto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinMapper joinMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public void join(JoinDto joinDto) {

        joinDto.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));

        joinMapper.join(joinDto, "ROLE_USER");
        System.out.println("회원가입 서비스 호출");
    }
}
