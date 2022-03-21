package com.youngadessi.demo.user.api;

import com.youngadessi.demo.user.model.User;
import com.youngadessi.demo.user.model.UserRepository;
import com.youngadessi.demo.user.model.UserSaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Boolean saveUser(UserSaveDTO userSaveDTO) {

        //mapstruct ----> dto <-> entity conversion

        User user=new User();
        user.setUsername(userSaveDTO.getUsername());
        user.setPassword(userSaveDTO.getPassword());

        userRepository.save(user);

        return Boolean.TRUE;

    }

}
