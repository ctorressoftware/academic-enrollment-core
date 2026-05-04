package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
@ConfigurationProperties(prefix = "security.jwt")
public class JwtConfig {
    private String secretKey;
    private String issuer;
    private int accessMinutes;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getAccessMinutes() {
        return accessMinutes;
    }

    public void setAccessMinutes(int accessMinutes) {
        this.accessMinutes = accessMinutes;
    }
}
