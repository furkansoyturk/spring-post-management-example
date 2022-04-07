package com.youngadessi.demo.security.auth;

import com.youngadessi.demo.security.model.AuthRequestDTO;
import com.youngadessi.demo.security.model.AuthResponseDTO;
import com.youngadessi.demo.security.user.User;
import com.youngadessi.demo.security.user.UserService;
import com.youngadessi.demo.security.util.JWTUtil;
import com.youngadessi.demo.security.util.PBKDF2Encoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class AuthController {

    private JWTUtil jwtUtil;

    private PBKDF2Encoder passwordEncoder;

    private UserService userService;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponseDTO>> login(@RequestBody AuthRequestDTO ar) {

        Mono<User> byUsername = userService.findByUsername(ar.getUsername());
        String arPassword = ar.getPassword();


        Mono<ResponseEntity<AuthResponseDTO>> responseEntityMono = userService.findByUsername(ar.getUsername())
                .filter(userDetails -> passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword()))
                .map(userDetails -> ResponseEntity.ok(new AuthResponseDTO(jwtUtil.generateToken(userDetails))))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));

        return  responseEntityMono;
    }

}

//    @PostMapping("/test")
//    public ResponseEntity<JWTResponseDTO> createToken(@RequestBody JWTRequestDTO request) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//        final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
//        final String jwtToken = JWTManager.generateJwtToken(userDetails);
//        return ResponseEntity.ok(new JWTResponseDTO(jwtToken));
//    }
