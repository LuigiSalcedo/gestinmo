package com.inmobicasaventas.gestinmo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.domain.advisor.Advisor;
import com.inmobicasaventas.gestinmo.api.domain.advisor.AdvisorLoginDto;
import com.inmobicasaventas.gestinmo.api.infra.security.JWTDto;
import com.inmobicasaventas.gestinmo.api.infra.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/public/auth")
@Tag(name = "Asesores", description = "Endpoints respecto al manejo de asesores")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("login")
    public ResponseEntity<JWTDto> userLogin(@RequestBody AdvisorLoginDto loginDto) {
        var auth = new UsernamePasswordAuthenticationToken(loginDto.login(), loginDto.password());
        var authUser = authManager.authenticate(auth);
        var jwt = tokenService.generateJWT((Advisor)authUser.getPrincipal());
        return ResponseEntity.ok(new JWTDto(jwt));
    }
    
}
