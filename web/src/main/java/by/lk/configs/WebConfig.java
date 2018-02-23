package by.lk.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Vinty on 25.06.2017.
 */
@Configuration
@ComponentScan(basePackages = "by.lk.controller")
@Import({
        InternationalizationConfig.class,
        ThymeleafConfig.class,
        MvcConfig.class
})
public class WebConfig {

}
