package com.S5_DA_02.GestaoUtilizadores.Controllers;

import com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO.*;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    @PostMapping("/api/auth/login")
    public ResponseEntity<LoggedUserDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO) {
        LoggedUserDTO loggedUserDTO = userService.loginUser(loginUserDTO);

        return loggedUserDTO != null ? ResponseEntity.ok().body(loggedUserDTO) : ResponseEntity.status(401).body(null);
    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<RegisteredUserDTO> registerUser(@RequestBody UserDTO userDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/auth/register").toUriString());
        RegisteredUserDTO registerUserDTO = userService.saveEntity(userDTO);

        return registerUserDTO != null ? ResponseEntity.created(uri).body(registerUserDTO) : ResponseEntity.internalServerError().body(null);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<RegisteredUserDTO> registerUserByAdmin(@RequestBody DefaultUserDTO userDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/admin/register").toUriString());

        RegisteredUserDTO registerUserDTO = userService.saveUserByAdmin(userDTO);

        return registerUserDTO != null ? ResponseEntity.created(uri).body(registerUserDTO) : ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("/")
    public ResponseEntity<LoggedUserDTO> checkUserAuthorization(OAuth2AuthenticationToken oauth2Token) {
        LoggedUserDTO loggedUserDTO = userService.checkUserAuthorization(oauth2Token.getPrincipal().getAttribute("email"));

        return loggedUserDTO != null ? ResponseEntity.ok(loggedUserDTO) : ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("/Hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok().body("Hello World");
    }
}
