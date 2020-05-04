package com.database.szte.service;

import com.database.szte.data.ApplicationUser;
import com.database.szte.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public ApplicationUser saveNewUser(ApplicationUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userMongoRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser user = userMongoRepository.findApplicationUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
