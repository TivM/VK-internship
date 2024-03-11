package com.example.demo.service.audit;

import com.example.demo.audit.Status;
import com.example.demo.entity.Audit;
import com.example.demo.entity.User;
import com.example.demo.repository.AuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;

    public void saveAudit(Status status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userPrincipal = null;
        if (authentication != null && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)) {
            userPrincipal = (User) authentication.getPrincipal();
        }

        var request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        String method = request.getMethod();
        String userEmail = userPrincipal == null ? "-" : userPrincipal.getEmail();

        Audit audit = Audit.builder()
                .status(status)
                .userEmail(userEmail)
                .timestamp(LocalDateTime.now())
                .requestUrl(url)
                .method(method)
                .build();

        auditRepository.save(audit);

    }
}
