package ku.review.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


   @Value("${auth0.audience}")
   private String audience;


   @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
   private String issuer;


   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .authorizeRequests()
               .anyRequest()
               .authenticated()


       .and()
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)


               // use oauth as a resource server to do jwt validation
       .and()
               .oauth2ResourceServer()
               .jwt()
               .decoder(jwtDecoder());


       return http.build();
   }


   private JwtDecoder jwtDecoder() {
       OAuth2TokenValidator<Jwt> withAudience =
               new AudienceValidator(audience);


       OAuth2TokenValidator<Jwt> withIssuer =
               JwtValidators.createDefaultWithIssuer(issuer);


       OAuth2TokenValidator<Jwt> validator =
               new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);


       NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
               JwtDecoders.fromOidcIssuerLocation(issuer);


       jwtDecoder.setJwtValidator(validator);


       return jwtDecoder;
   }


}
