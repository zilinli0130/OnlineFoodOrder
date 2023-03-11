//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of SecurityConfig class.
//**********************************************************************************************************************

package com.zilinli.onlineorder;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Framework includes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

// System includes
import javax.sql.DataSource;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .formLogin()
            .failureForwardUrl("/login?error=true");
        http
            .authorizeRequests()
            .antMatchers("/order/*", "/cart", "/checkout").hasAuthority("ROLE_USER")
            .anyRequest().permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder)
            .usersByUsernameQuery("SELECT email, password, enabled FROM customer WHERE email=?")
            .authoritiesByUsernameQuery("SELECT email, authorities FROM authorities WHERE email=?");
    }

//**********************************************************************************************************************
// * Private attributes
//**********************************************************************************************************************
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PasswordEncoder passwordEncoder;

}

