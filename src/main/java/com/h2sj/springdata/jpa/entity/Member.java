package com.h2sj.springdata.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "db_member")
@Setter
@Getter
public class Member implements Serializable {
    private static final long serialVersionUID = -2001016857847442892L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Long mId;

    @Column(name = "m_username")
    private String mUsername;

    @Column(name = "u_password")
    private String mPassword;

    @Column(name = "n_nickname")
    private String nNickname;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "r_id",referencedColumnName = "r_id")
    private Role role;
}
