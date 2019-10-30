package sen_doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sen_doctor.model.Professional;
import sen_doctor.model.RoleEnum;
import sen_doctor.repository.ProfessionalRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class DetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) {
        Professional user = professionalRepository.findByEmail(userEmail);
        if (user == null) throw new UsernameNotFoundException(userEmail);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleEnum role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
