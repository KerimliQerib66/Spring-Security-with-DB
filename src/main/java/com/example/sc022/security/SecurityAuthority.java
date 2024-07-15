package com.example.sc022.security;

import com.example.sc022.entities.AuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private final AuthorityEntity authorityEntity;
    @Override
    public String getAuthority(){
        return authorityEntity.getName();
    }
}
