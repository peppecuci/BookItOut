package com.bruxelles.bookitout.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.enabled;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "\"User\"")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = List.of("CLIENT");

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private List<Reservation> reservation;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map((role) -> new SimpleGrantedAuthority("ROLE" + role))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }


    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
