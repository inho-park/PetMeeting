package com.daelim.petmeeting.user.domain;

import com.daelim.petmeeting.common.domain.BaseTimeEntity;
//import com.daelim.petmeeting.common.domain.BooleanToYNConverter;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbl_user")
public class User extends BaseTimeEntity implements UserDetails {
    @Id
    @Column(length = 45, nullable = false, unique = true, name = "userid")
    private String userId;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 64, unique = true, nullable = false)
    private String email;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String address;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles")
    private List<String> roles = new ArrayList<>();

//    @Convert(converter = BooleanToYNConverter.class)
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean enable;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
//        if (this.userId.equals("admin")) {
//            auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            auth.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//
//        return auth;
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
