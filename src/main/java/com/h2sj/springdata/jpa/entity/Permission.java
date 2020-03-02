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
* 授权表
* */

@Entity
@Table(name = "db_permission")
@Setter
@Getter
public class Permission implements Serializable {
    private static final long serialVersionUID = 640226083102926805L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long pId;

    @NotEmpty(message = "p_name字段不为空")
    @Column(name = "p_name")
    private String pName;

    @Column(name = "p_description")
    private String pDescription;

    @NotEmpty(message = "p_url字段不为空")
    @Column(name = "p_url")
    private String pUrl;

    @JSONField(serialize = false)
    @ManyToMany(targetEntity = Role.class,mappedBy = "permissions")
    private List<Role> roles = new ArrayList<>();
}
