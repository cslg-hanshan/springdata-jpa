package com.h2sj.springdata.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @Length(max = 15,min = 6,message = "username长度为6-15")
    @NotEmpty(message = "m_username字段不为空")
    @Column(name = "m_username")
    private String mUsername;

    @NotEmpty(message = "u_password字段不为空")
    @Column(name = "u_password")
    private String mPassword;

    @Column(name = "n_nickname")
    private String nNickname;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "r_id",referencedColumnName = "r_id")
    private Role role;
}
