package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebMvc
@EnableScheduling
public class TestConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public TestConfig config(){
        return new TestConfig();
    }
}