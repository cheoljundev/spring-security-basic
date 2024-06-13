package hello.security.dao;

import hello.security.dto.JoinDto;
import org.apache.ibatis.annotations.Param;

public interface JoinMapper {
    void join(@Param("joinDto") JoinDto joinDto, String userRole);
    JoinDto findByUsername(String username);
}
