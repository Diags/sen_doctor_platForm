package sen_doctor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sen_doctor.model.RoleEnum;
import sen_doctor.service.DetailsServiceImpl;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DetailsServiceImpl userDetailsServiceimpl;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceimpl).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // don't create session
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are UNAUTHORIZED"))
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs/**","/v2/api-docs?group=SEN_DOCTOR_PLATFORM_SERVICE/**","/swagger-ui.html/swagger-resources/**","/swagger-ui.html/swagger-resources/configuration/ui/**","/swagger-ui.html/swagger-resources/configuration/security/**","/swagger-ui.html/swagger-resources/configuration/ui/**","/META-INF/resources/**","/META-INF/resources/webjars/**","/swagger-resources/**","/swagger-resources/configuration/ui/**","/swagger-resources/configuration/security/**","/swagger-resources/configuration/security/**","**/api/**","/swagger-resource/**","/webjars/**","/swagger-ui.html/**","/registerclient/**", "/registerprofessional/**", "/loginprofessionnal/**", "/loginclient/**", "/profesionnalimage/**", "/categories/**", "/professionnals/**","/proffesionnals/**" ,"/specialities/**", "/search/**")
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "deleteProfessional/**").hasRole(String.valueOf(RoleEnum.ADMINISTRATOR))
                .antMatchers(HttpMethod.POST, "addProfessional/**").hasRole(String.valueOf(RoleEnum.ADMINISTRATOR))
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers().cacheControl();

    }
}
