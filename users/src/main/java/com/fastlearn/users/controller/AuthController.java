package com.fastlearn.users.controller;

import com.fastlearn.users.dao.KeycloakManagementPort;
import com.fastlearn.users.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RequestMapping("/auth-controller")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final KeycloakManagementPort keycloakManagementPort;

    @GetMapping("/search")
    public ResponseEntity<List<UserRepresentation>> findAllUsers() {
        return ResponseEntity.ok(keycloakManagementPort.findAllUsers());
    }


    @GetMapping("/search/{username}")
    public ResponseEntity<List<UserRepresentation>> searchUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(keycloakManagementPort.searchUserByUsername(username));
    }


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        String response = keycloakManagementPort.createUser(userDTO);
        return ResponseEntity.created(new URI("/keycloak/user/create")).body(userDTO.getEmail());
    }


    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        keycloakManagementPort.updateUser(userId, userDTO);
        return ResponseEntity.ok("User updated successfully");
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        keycloakManagementPort.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
