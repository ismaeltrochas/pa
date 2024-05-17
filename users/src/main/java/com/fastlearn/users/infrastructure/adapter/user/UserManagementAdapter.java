package com.fastlearn.users.infrastructure.adapter.user;

import com.fastlearn.users.domain.model.UserDTO;
import com.fastlearn.users.domain.port.KeycloakManagementPort;
import com.fastlearn.users.infrastructure.configuration.keycloak.KeycloakProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
public class UserManagementAdapter implements KeycloakManagementPort {

    @Override
    public List<UserRepresentation> findAllUsers() {
        return KeycloakProvider.getRealmResource().users().list();
    }

    @Override
    public List<UserRepresentation> searchUserByUsername(String username) {
        return KeycloakProvider.getRealmResource().users().search(username, false);
    }

    public UserDTO createUser(@NonNull UserDTO userDTO) {

        UserRepresentation userRepresentation = getUserRepresentation(userDTO);

        UsersResource usersResource = getUsersResource();

        Response response = usersResource.create(userRepresentation);

        if (Objects.equals(201, response.getStatus())) {
            List<UserRepresentation> representationList = usersResource.searchByUsername(
                    userDTO.getEmail(), true);
            //         emailVerification(userRepresentation.getId());
            if (userDTO.getRoles().contains("TEACHER")) {
                assignRoleToUser(userRepresentation.getId(), "TEACHER");
            } else {
                assignRoleToUser(userRepresentation.getId(), "USER");
            }
        }

        return userDTO;
    }

    private UsersResource getUsersResource() {
        return KeycloakProvider.userResource();
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

    @Override
    public void deleteUser(String userId) {
        KeycloakProvider.userResource().delete(userId);
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {

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
}
