package com.h2sj.springdata.jpa.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
* 角色表
* */

@Entity
@Table(name = "db_role")
@Setter
@Getter
public class Role implements Serializable {
    private static final long serialVersionUID = 2418412205887074069L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long rId;

    @NotEmpty(message = "r_name字段不为空")
    @Column(name = "r_name")
    private String rName;

    @JSONField(serialize = false)
    @OneToMany(targetEntity = Member.class,mappedBy = "role")
    private List<Member> members = new ArrayList<>();

    @JSONField(serialize = false)
    @ManyToMany(targetEntity = Permission.class)
    @JoinTable(
            name = "db_role_to_permission",
            joinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "r_id")},
            inverseJoinColumns = {@JoinColumn(name = "p_id",referencedColumnName = "p_id")}
    )
    private List<Permission> permissions = new ArrayList<>();
}
