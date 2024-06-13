package hello.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "join").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/my/**").hasAnyRole(  "USER", "ADMIN")
                .anyRequest().authenticated()
        );

        http.formLogin(form -> form
                .loginPage("/login") //  로그인 페이지
                .loginProcessingUrl("/login") // 로그인 처리 페이지
                .permitAll() // 로그인 페이지는 누구나 접근 가능
        );

//        http.csrf(csrf -> csrf.disable()); // CSRF 보안 비활성화, 개발 중에는 비활성화

        http.sessionManagement(session -> session
                .maximumSessions(1) // 최대 세션 수
                .maxSessionsPreventsLogin(true) // 동시 로그인 차단
        );

        http.sessionManagement(session -> session
                .sessionFixation().newSession() // 세션 고정 보호
        );

        return http.build();
    }
}
