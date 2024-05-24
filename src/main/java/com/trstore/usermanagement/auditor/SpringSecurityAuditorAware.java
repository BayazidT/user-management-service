package com.trstore.usermanagement.auditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;

@Slf4j
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            // No authentication present, return "System" as the default value
            return Optional.of("System");
        }

        Object principal = authentication.getPrincipal();

        return Optional.ofNullable(principal)
                .filter(Jwt.class::isInstance)
                .map(Jwt.class::cast)
                .map(jwtPrincipal -> jwtPrincipal.getClaimAsString("sub"));
    }


}
