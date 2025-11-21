package dlk.wti.spring.auth.login.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthLoginSessionWebConfig implements WebMvcConfigurer {

    @Value("${front.server.url}")
    private String frontServerUrl;

    private final AuthLoginSessionInterceptor authLoginSessionInterceptor;
    public AuthLoginSessionWebConfig(AuthLoginSessionInterceptor authLoginSessionInterceptor) {this.authLoginSessionInterceptor = authLoginSessionInterceptor;}

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(frontServerUrl)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)  // 세션/쿠키 허용
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authLoginSessionInterceptor)
                .addPathPatterns("/rest/**")
                .excludePathPatterns(
                        "/rest/auth/login/session/login",
                        "/rest/auth/login/session/logout"
                );
    }

}
