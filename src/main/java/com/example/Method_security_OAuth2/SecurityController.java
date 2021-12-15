package com.example.Method_security_OAuth2;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//аннотации @Scecured и @RolesAllowed (используется в javaEE) полностью взаимозаменяемые
@RestController
public class SecurityController {

    @GetMapping("/authorize")
    @Secured("ROLE_READ")
    public String lunohod1() {
        return "My ROLE is READ";
    }

    @GetMapping("/authorize2")
    @Secured("ROLE_WRITE")
    public String lunohod2() {
        return "My ROLE is WRITE";
    }

    @GetMapping("/authorize3")
    @Secured("ROLE_DELETE")
    public String lunohod3() {
        return "My ROLE is DELETE";
    }

    @GetMapping("/authorize4")
    @PreAuthorize("hasRole('ROLE_DELETE') or hasRole('ROLE_WRITE')")
    public String lunohod4(String username) {
        return "My ROLE is DELETE or WRITE. USERNAME хранится в SecurityContextHolder";
    }
}
