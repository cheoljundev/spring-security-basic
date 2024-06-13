package hello.security.controller;

import hello.security.dto.JoinDto;
import hello.security.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;
    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(JoinDto joinDto) {
        System.out.println("joinDto = " + joinDto);
        
        joinService.join(joinDto); 
        
        return "redirect:/login";
    }
}
