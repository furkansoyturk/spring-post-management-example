package com.youngadessi.demo.user.api;

import com.youngadessi.demo.user.model.UserSaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Boolean> saveUser(@RequestBody UserSaveDTO userSaveDTO){
        return new ResponseEntity<>(userService.saveUser(userSaveDTO), HttpStatus.CREATED);
    }


}
