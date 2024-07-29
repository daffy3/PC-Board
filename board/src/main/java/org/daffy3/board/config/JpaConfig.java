package org.daffy3.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {
    // 유저이름 정보 주입
    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("admin"); // 임의의 유저이름 주입 TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때, 수정하자.
    }
}
