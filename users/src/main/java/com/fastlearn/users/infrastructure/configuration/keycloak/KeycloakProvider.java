package com.fastlearn.users.infrastructure.configuration.keycloak;

import lombok.Getter;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "keycloak")
@Getter
public class KeycloakProvider {

    private static String serverUrl;
    private static String realmName;
    private static String realmMaster;
    private static String adminCli;
    private static String userConsole;
    private static String passwordConsole;
    private static String clientSecret;


    public static RealmResource getRealmResource() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realmName)
                .clientId(adminCli)
                .username(userConsole)
                .password(passwordConsole)
                .clientSecret(clientSecret)
                .resteasyClient(new ResteasyClientBuilderImpl()
                        .connectionPoolSize(10)
                        .build())
                .build();

        return keycloak.realm(realmName);
    }

    public static UsersResource userResource() {
        RealmResource realmResource = getRealmResource();
        return realmResource.users();
    }
}
