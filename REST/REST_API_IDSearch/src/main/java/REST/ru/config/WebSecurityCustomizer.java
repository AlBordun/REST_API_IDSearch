package REST.ru.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class WebSecurityCustomizer {
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return  (web) -> web
//                .requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and().debug(true);
//
//    }
}
