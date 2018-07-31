package app.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebMvc
@EnableScheduling
public class AppConfig {

    @Bean
    public AppConfig config(){
        return new AppConfig();
    }
}