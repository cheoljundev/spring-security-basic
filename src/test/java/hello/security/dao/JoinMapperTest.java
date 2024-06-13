package hello.security.dao;

import hello.security.SecurityApplication;
import hello.security.dto.JoinDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SecurityApplication.class)
class JoinMapperTest {

    @Autowired
    private JoinMapper joinMapper;
    @Test
    void findByUsername() {
        JoinDto user = joinMapper.findByUsername("user");
        Assertions.assertThat(user.getUsername()).isEqualTo("user");
    }
}