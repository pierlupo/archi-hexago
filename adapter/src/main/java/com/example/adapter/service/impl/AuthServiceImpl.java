package com.example.adapter.service.impl;

import com.example.adapter.dto.LoginRequestDTO;
import com.example.adapter.dto.RegisterRequestDTO;
import com.example.adapter.security.JwtTokenProvider;
import com.example.adapter.service.AuthService;
import com.infrastructure.exception.RestAPIException;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.port.RoleRepo;
import org.example.port.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AuthServiceImpl implements AuthService {

        // Injection de dépendance du repository UserRepository.

        private UserRepo userRepo;

        // Injection de dépendance du repository RoleRepository.
        private RoleRepo roleRepo;

        // Injection de dépendance de l'encodeur de mot de passe PasswordEncoder.
        private PasswordEncoder passwordEncoder;

        // Injection de dépendance du gestionnaire d'authentification AuthenticationManager.
        private AuthenticationManager authenticationManager;

        // Injection de dépendance du fournisseur de jeton JWT JwtTokenProvider.
        private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // Méthode pour l'inscription d'un nouvel utilisateur à partir des informations de RegisterDto.
        @Override
        public String register(RegisterRequestDTO registerRequestDTO) {
            // Vérifie si le nom d'utilisateur existe déjà dans la base de données.
            if (userRepo.existsByUsername(registerRequestDTO.getUsername())) {
                throw new RestAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
            }

            // Vérifie si l'adresse e-mail existe déjà dans la base de données.
            if (userRepo.existsByEmail(registerRequestDTO.getEmail())) {
                throw new RestAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
            }

            // Crée une nouvelle instance de l'entité User à partir des informations du RegisterDto.
            User user = new User();
            user.setName(registerRequestDTO.getName());
            user.setUsername(registerRequestDTO.getUsername());
            user.setEmail(registerRequestDTO.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));

            // Crée un ensemble de rôles pour l'utilisateur, dans ce cas, seul le rôle "ROLE_USER" est attribué.
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepo.findByName("ROLE_USER");
            roles.add(userRole);

            // Affecte les rôles à l'utilisateur.
            user.setRoles(roles);

            // Enregistre l'utilisateur dans la base de données en utilisant le UserRepository.
            userRepo.save(user);

            return "User Registered Successfully!.";
        }
        // Méthode pour la connexion d'un utilisateur à partir des informations de LoginDto.
        @Override
        public String login(LoginRequestDTO loginRequestDTO) {
            // Authentifie l'utilisateur en utilisant l'objet AuthenticationManager.
            // Il utilise les informations de connexion fournies dans le LoginDto pour effectuer l'authentification.
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDTO.getUsernameOrEmail(),
                    loginRequestDTO.getPassword()
            ));

            // Définit l'objet Authentication comme l'authentification actuelle dans le contexte de sécurité.
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Génère le jeton JWT à partir de l'authentification réussie et le renvoie.
            String token = jwtTokenProvider.generateToken(authentication);

            return token;
        }
    }
