package com.university.uch_university.config;

import com.university.uch_university.model.RoleEnum;
import com.university.uch_university.model.UserModel;
import com.university.uch_university.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void createDefaultUser() {
        if (!userRepository.existsByUsername("admin")) {
            UserModel user = new UserModel();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("Qwerty_123"));
            user.setActive(true);
            user.setRole(RoleEnum.ADMIN);
            userRepository.save(user);
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            UserModel user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("Такой пользователь не существует!");
            }
            return new User(
                    user.getUsername(),
                    user.getPassword(),
                    user.isActive(),
                    true,
                    true,
                    true,
                    Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()))
            );
        }).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/api/**", "/login", "/registration").permitAll()
                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                .requestMatchers("/pathologist/**").hasAuthority("PATHOLOGIST")
                                .requestMatchers("/loader/**").hasAuthority("LOADER")
                                .anyRequest().authenticated())

                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/").permitAll())
                .logout(logout -> logout.permitAll())
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable());

        return http.build();
    }
}