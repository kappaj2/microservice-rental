package za.co.ajk.rentcloud.authorizationserver.service;

import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.co.ajk.rentcloud.authorizationserver.model.AuthUserDetail;
import za.co.ajk.rentcloud.authorizationserver.model.User;
import za.co.ajk.rentcloud.authorizationserver.repository.UserDetailRepository;

import java.util.Optional;

@Service
@Primary
public class UserDetailServiceImpl implements UserDetailsService {

    private UserDetailRepository userDetailRepository;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> optionalUser = userDetailRepository.findByUsername(userName);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Cannot find username " + userName));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());

        //  Check for expired, etc.
        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;

    }
}
