package org.brapi.test.BrAPITestServer.service;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class SecurityUtils {
    public static UUID getCurrentUserId() {
        SecurityContext context = SecurityContextHolder.getContext();
        String userId = "";
        if (context.getAuthentication().getPrincipal() != null) {
            userId = context.getAuthentication().getPrincipal().toString();
        }
        return UUID.fromString(userId);
    }
}
