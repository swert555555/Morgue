package com.university.uch_university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private Long idUser;

    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 8, message = "Пароль должен быть не менее 8 символов")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Пароль должен содержать как минимум одну цифру, одну строчную букву, одну заглавную букву, один специальный символ и не содержать пробелов")
    private String password;
    private boolean active;
    
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public UserModel(){}

    public UserModel(Long idUser, String username, String password, boolean active, RoleEnum role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public @NotBlank(message = "Пароль не может быть пустым") @Size(min = 8, message = "Пароль должен быть не менее 8 символов") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Пароль должен содержать как минимум одну цифру, одну строчную букву, одну заглавную букву, один специальный символ и не содержать пробелов") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Пароль не может быть пустым") @Size(min = 8, message = "Пароль должен быть не менее 8 символов") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Пароль должен содержать как минимум одну цифру, одну строчную букву, одну заглавную букву, один специальный символ и не содержать пробелов") String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}

