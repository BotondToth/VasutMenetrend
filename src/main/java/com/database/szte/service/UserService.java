package com.database.szte.service;

import com.database.szte.data.ApplicationUser;
import com.database.szte.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    public ApplicationUser saveNewUser(ApplicationUser user){
        return userMongoRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("-----------------------loadUser " + s);
        ApplicationUser user = userMongoRepository.findApplicationUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        System.out.println("user found: " + user.getUsername() + " " + user.getPassword());
        return new User(user.getUsername(), user.getPassword(), emptyList());

    }
}
