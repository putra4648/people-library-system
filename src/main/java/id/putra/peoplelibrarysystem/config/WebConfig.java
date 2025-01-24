package id.putra.peoplelibrarysystem.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(Customizer.withDefaults());
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.logout(Customizer.withDefaults());
        return http.build();
    }

    @Profile("!dev")
    @Bean
    FilterRegistrationBean<UsernamePasswordAuthenticationFilter> prodRegistrationFilter() {
        FilterRegistrationBean<UsernamePasswordAuthenticationFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new UsernamePasswordAuthenticationFilter() {
        });
        return filter;
    }

    @Profile("dev")
    @Bean
    FilterRegistrationBean<AnonymousAuthenticationFilter> defaultRegistrationFilter() {
        FilterRegistrationBean<AnonymousAuthenticationFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new AnonymousAuthenticationFilter("dev"));
        return filter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder().username("admin").password(passwordEncoder.encode("admin123")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(admin);
    }
}
