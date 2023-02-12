package com.daelim.petmeeting.user.domain;

import com.daelim.petmeeting.common.domain.BaseTimeEntity;
import com.daelim.petmeeting.common.domain.BooleanToYNConverter;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(length = 64, unique = true, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 45, nullable = false)
    private String username;

    @Column(length = 45, nullable = false)
    private String userid;

//    @Convert(converter = BooleanToYNConverter.class)
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean enable;


}