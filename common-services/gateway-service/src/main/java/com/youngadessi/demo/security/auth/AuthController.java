package com.youngadessi.demo.security.auth;

import com.youngadessi.demo.security.model.JWTRequestDTO;
import com.youngadessi.demo.security.model.JWTResponseDTO;
import com.youngadessi.demo.security.user.UserService;
import com.youngadessi.demo.security.util.JWTUtil;
import com.youngadessi.demo.security.util.PBKDF2Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PBKDF2Encoder passwordEncoder;

    @Autowired
    private UserService userService;




    @PostMapping("/login")
    public Mono<ResponseEntity<JWTResponseDTO>> login(@RequestBody JWTRequestDTO ar) {

//        final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());

        return userService.findByUsername(ar.getUsername())
                .filter(userDetails -> passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword()))
                .map(userDetails -> ResponseEntity.ok(new JWTResponseDTO(jwtUtil.generateToken(userDetails))))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
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
}