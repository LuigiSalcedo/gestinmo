package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.authentication.application.services.AuthService;
import com.inmobicasaventas.gestinmo.api.authentication.application.services.TokenService;
import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers.AdvisorMapper;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers.dtos.AdvisorLoginDto;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers.dtos.AdvisorRegisterDto;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers.dtos.JWTDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

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
    @Autowired
    private AuthService authService;
    @Autowired
    private AdvisorMapper advisorMapper;

    @PostMapping("login")
    public ResponseEntity<JWTDto> userLogin(@Valid @RequestBody AdvisorLoginDto loginDto) {
        var auth = new UsernamePasswordAuthenticationToken(loginDto.login(), loginDto.password());
        var authUser = authManager.authenticate(auth);
        var advisor = (Advisor)authUser.getPrincipal();
        var jwt = tokenService.generateJWT(advisor);
        return ResponseEntity.ok(new JWTDto(jwt, advisor.getName()));
    }

    @PostMapping("register")
    public ResponseEntity<?> registerAdvisor(@Valid @RequestBody AdvisorRegisterDto advisorRegisterDto) {
        var created = authService.registerAdvisor(
            advisorMapper.toAdvisor(advisorRegisterDto), advisorRegisterDto.masterPassword());
        if(!created) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.created(null).build();
    }
    
}
