package com.example.adapter.controller;

import com.example.adapter.dto.JwtAuthResponse;
import com.example.adapter.dto.LoginRequestDTO;
import com.example.adapter.dto.RegisterRequestDTO;
import com.example.adapter.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")// Permet à cette classe de gérer les requêtes cross-origin depuis n'importe quelle origine (*).
@RestController // Indique que cette classe est un contrôleur REST.
@RequestMapping("/api/auth") // Toutes les requêtes commençant par "/api/auth" seront gérées par ce contrôleur.
public class AuthController {

    // Injecte automatiquement une instance d'AuthService dans cette classe.
    private AuthService authService;


    // Endpoint pour l'inscription des utilisateurs.
    @PostMapping("/register") // Cette méthode gère les requêtes POST sur "/api/auth/register".
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        // Appelle la méthode "register" de l'AuthService en passant les informations de RegisterDto.
        // Cette méthode gère le processus d'inscription et renvoie un message de réponse.
        String response = authService.register(registerRequestDTO);
        // Retourne une réponse HTTP avec le message de réponse et le code de statut "201 CREATED".
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    // Endpoint pour la connexion des utilisateurs.
    @PostMapping("/login") // Cette méthode gère les requêtes POST sur "/api/auth/login".
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        // Appelle la méthode "login" de l'AuthService en passant les informations de LoginDto.
        // Cette méthode gère le processus de connexion et renvoie le token JWT.
        String token = authService.login(loginRequestDTO);

        // Crée une instance de JwtAuthResponse pour encapsuler le token JWT.
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        // Retourne une réponse HTTP avec l'objet JwtAuthResponse contenant le token JWT et le code de statut "200 OK".
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}
