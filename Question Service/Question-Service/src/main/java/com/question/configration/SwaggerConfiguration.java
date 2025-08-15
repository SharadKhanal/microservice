package com.question.configration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Question API",
                version = "1.0",
                description = "API documentation Question appication",
                contact = @Contact(
                        name = "Sharad Khanal",
                        email = "khanelsharad.@gmail.com",
                        url = "https://yourwebsite.com"
                )
        )
)

public class SwaggerConfiguration {
}
