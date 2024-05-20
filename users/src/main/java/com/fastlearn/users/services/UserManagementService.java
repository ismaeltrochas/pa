package com.fastlearn.users.services;

import com.fastlearn.users.configuration.KeycloakProvider;
import com.fastlearn.users.dao.KeycloakManagementPort;
import com.fastlearn.users.dto.UserDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserManagementService implements KeycloakManagementPort {

    @Override
    public List<UserRepresentation> findAllUsers() {
        return KeycloakProvider.getRealmResource().users().list();
    }

    @Override
    public List<UserRepresentation> searchUserByUsername(String username) {
        return KeycloakProvider.getRealmResource().users().search(username, true);
    }

    public String createUser(@NonNull UserDTO userDTO) {

        UserRepresentation userRepresentation = getUserRepresentation(userDTO);

        UsersResource usersResource = getUsersResource();

        Response response = usersResource.create(userRepresentation);

        if (Objects.equals(201, response.getStatus())) {
            List<UserRepresentation> representationList = usersResource.searchByUsername(
                    userDTO.getEmail(), true);
            //         emailVerification(userRepresentation.getId());
            userDTO.getRoles().forEach(role -> {
                assignRoleToUser(userRepresentation.getId(), role);
            });
            // emailVerification(userRepresentation.getId());
        }

        return "User created successfully!!";
    }

    private UsersResource getUsersResource() {
        return KeycloakProvider.getUserResource();
    }

    private static UserRepresentation getUserRepresentation(UserDTO userDTO) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(userDTO.getFirstName());
        userRepresentation.setLastName(userDTO.getLastName());
        userRepresentation.setEmail(userDTO.getEmail());
        userRepresentation.setUsername(userDTO.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(userDTO.getPassword());
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setTemporary(Boolean.FALSE);

        List<CredentialRepresentation> credentialRepresentationList = new ArrayList<>();
        credentialRepresentationList.add(credentialRepresentation);
        userRepresentation.setCredentials(credentialRepresentationList);
        return userRepresentation;
    }

    private void emailVerification(String userId) {
        UsersResource usersResource = getUsersResource();
        usersResource.get(userId).sendVerifyEmail();
    }

    private RoleRepresentation getRole(String role) {
        RolesResource rolesResource = getRolesResource();
        return rolesResource.get(role).toRepresentation();
    }

    private RolesResource getRolesResource() {
        return KeycloakProvider
                .getRealmResource()
                .roles();
    }

    private void assignRoleToUser(String userId, String role) {
        UsersResource usersResource = getUsersResource();
        UserResource userResource = usersResource.get(userId);
        RoleRepresentation representation = getRole(role);
        userResource.roles().realmLevel().add(Collections.singletonList(representation));
    }


    /**
     * Metodo para borrar un usuario en keycloak
     *
     * @return void
     */
    public void deleteUser(String userId) {
        KeycloakProvider.getUserResource()
                .get(userId)
                .remove();
    }


    public UserRepresentation getUserRepresentation(String email) {
        UsersResource userResource = KeycloakProvider.getUserResource();
        userResource.searchByUsername(email, true);
        return userResource.get(email).toRepresentation();
    }

    /**
     * Metodo para actualizar un usuario en keycloak
     *
     * @return non
     */
    public void updateUser(String userId, @NonNull UserDTO userDTO) {

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(OAuth2Constants.PASSWORD);
        credentialRepresentation.setValue(userDTO.getPassword());

        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setEnabled(true);
        user.setEmailVerified(true);
        user.setCredentials(Collections.singletonList(credentialRepresentation));

        UserResource usersResource = KeycloakProvider.getUserResource().get(userId);
        usersResource.update(user);
    }
}
