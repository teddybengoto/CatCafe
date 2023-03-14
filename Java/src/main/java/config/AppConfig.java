package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"config","model","dao","exception","api","request","response"})
public class AppConfig {
    
}
