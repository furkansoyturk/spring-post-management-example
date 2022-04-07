package com.youngadessi.demo.authservice.auth.jwt;

import com.youngadessi.demo.authservice.auth.model.JWTRequestDTO;
import com.youngadessi.demo.authservice.auth.model.JWTResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JWTController {

    @Autowired
    private JWTUserDetailsService JWTUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTManager JWTManager;


    @PostMapping("/login")
    public ResponseEntity<JWTResponseDTO> createToken(@RequestBody JWTRequestDTO request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = JWTUserDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = JWTManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JWTResponseDTO(jwtToken));
    }

}
