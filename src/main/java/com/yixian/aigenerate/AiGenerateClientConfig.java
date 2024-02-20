package com.yixian.aigenerate;

import com.yixian.aigenerate.client.AiGenerateClient;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ConfigurationProperties("ai.client")
@Data
@ComponentScan(basePackages = "com.yixian.aigenerate.client")
public class AiGenerateClientConfig {

    private String access_token;

    @Bean
    public AiGenerateClient aiGenerateClient() {
        return new AiGenerateClient(access_token);
    }
}
