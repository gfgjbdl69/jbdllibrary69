package com.gfg.library69.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@Configuration
public class SecurityConfiguration {



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.authorizeHttpRequests( authorize ->
               authorize
                       .requestMatchers("**").permitAll()
                       .requestMatchers("/csrf").permitAll()
                       .requestMatchers("/admin/**").hasAuthority("ADMIN")
                       .requestMatchers("/greet/**").hasAuthority("USER")
                       .requestMatchers("/register").permitAll()
                       .requestMatchers("/login").permitAll()
                       .requestMatchers("/error").permitAll()
                       .anyRequest().authenticated()

               ).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).oauth2Login(Customizer.withDefaults());
       return httpSecurity.build();

    }



    /**
     * Encode -> transform of data into one from another format. which can be reversible easily
     *
     * hashing -> transform of data into non-consumable format which is non reversible and it ensures that same hash
     *              will be generated for same values always until the under-laying logic changes.
     *              algorithm  -> SHA-256
     *
     * encryption -> transform of data into non-consumable format and can be converted to original via decryption process.

     *
     *
     *
     * Secure our APIs
     *
     * 1. Onboard the user with credentials. -> user object -> UserDetail.
     * 2. accept username and password from user. -> AuthenticationProvider -> Authentication object
     * 3. Fetch the user from the databases -> UserDetailService Implementation
     * 4. Compare the password hash of the user. -> AuthenticationProvider -> PasswordEncoder.
     * 5. Check if the user has authority on API. -> SecurityFilterChain
     * 6. Let the user use the API.-> AuthenticationProvider
     *
     *
     *
     * CoRs -> Cross-Origin Resource Sharing
     *
     * CSRF-> Cross - Site Request Forgery
     * -> XSS attacks
     *
     *
     *
     * */
}
