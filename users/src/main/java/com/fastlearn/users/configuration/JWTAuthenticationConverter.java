package com.fastlearn.users.configuration;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JWTAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {


    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter =
            new JwtGrantedAuthoritiesConverter();

    @Value("${jwt.auth.converter.principle-attribute}")
    private String principleAttribute;

    @Override
    @NonNull
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        Collection<GrantedAuthority> authorities =
                Stream.concat(jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                        extractResourcesRoles(jwt).stream()).toList();

        return new JwtAuthenticationToken(jwt, authorities, getPrincipalClaimName(jwt));
    }

    @SuppressWarnings("unchecked")
    private Collection<? extends GrantedAuthority> extractResourcesRoles(Jwt jwt) {
        Collection<String> resourceRoles;

        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
        Map<String, Object> keys = (Map<String, Object>) resourceAccess.get("spring-course-client");
        resourceRoles = (Collection<String>) keys.get("roles");

        return resourceRoles
                .stream()
                .map(role ->
                        new SimpleGrantedAuthority("ROLE_" + resourceRoles))
                .collect(Collectors.toList());
    }

    private String getPrincipalClaimName(Jwt jwt) {
        String claimName = JwtClaimNames.SUB;
        if (principleAttribute != null) {
            claimName = principleAttribute;
        }
        return jwt.getClaim(claimName);
    }
}
