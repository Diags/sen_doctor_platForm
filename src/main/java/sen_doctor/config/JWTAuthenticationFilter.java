package sen_doctor.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import sen_doctor.service.JwtTokenProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // We use auth manager to validate the user credentials
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
        //By default, UsernamePasswordAuthenticationFilter listens to "/login" path.
        // In our case, we use "/signin". So, we need to override the defaults.
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/signin/**", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

      //  LoginParam user = null;
        try {
           // user = new ObjectMapper().readValue(n,null);
            System.out.println("******************************");

          //  System.out.println(user.getEmail());
            //System.out.println(user.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        null,
                        null, Collections.emptyList()
                ));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse
            response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

      //  monartisant.com.projetartisant.model.User springUser = (monartisant.com.projetartisant.model.User) authResult.getPrincipal();
        //String jwtToken = jwtTokenProvider.generateToken(springUser);
        response.addHeader(SecurityConstants.HEADER_STRING,
                SecurityConstants.TOKEN_PREFIX );
    }
}
