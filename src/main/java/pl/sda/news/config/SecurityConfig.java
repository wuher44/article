package pl.sda.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails tom = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password"))
                .roles("PUBLISHER", "ADMIN")
                .build();

        UserDetails jim = User.builder()
                .username("jim")
                .password(passwordEncoder.encode("password"))
                .roles("MODERATOR")
                .build();



        return new InMemoryUserDetailsManager(tom, jim);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/article").permitAll()
                .mvcMatchers("/comment/**").permitAll()
                .mvcMatchers("/viewStatistics").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin();

        http.headers().frameOptions().disable();

    }
}
