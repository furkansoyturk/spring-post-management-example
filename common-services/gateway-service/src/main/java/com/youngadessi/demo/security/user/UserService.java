package com.youngadessi.demo.security.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
//public class UserService implements UserDetailsService {
public class UserService{

    private Map<String, User> data;

    @PostConstruct
    public void init() {
        data = new HashMap<>();

        data.put("user", new User("test", "12345678",
                new ArrayList<>()));

//        data.put("admin", new User("admin", "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true, Arrays.asList(Role.ROLE_ADMIN)));
    }

    public Mono<User> findByUsername(String username) {
        return Mono.justOrEmpty(data.get(username));
    }



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("test".equals(username)) {
//            return new User("test",
//                    "$2a$10$CYhJhCdLLGWOr3KRoea4Au8rRBChXw0CBeqhZK7fwiX.HTnnb8QJe",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
}