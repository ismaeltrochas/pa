package com.fastlearn.users.domain.port;


import com.fastlearn.users.domain.model.UserDTO;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface KeycloakManagementPort {

    List<UserRepresentation> findAllUsers();
    List<UserRepresentation> searchUserByUsername(String username);
    UserDTO createUser(UserDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
}
