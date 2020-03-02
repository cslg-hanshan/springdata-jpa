# springdata-jpa
JPA框架学习
## 数据表说明

### Member 成员表

```sql
CREATE TABLE `db_member` (
  `m_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `m_username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `r_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `FKl6wp8e0b9oxr4rlgtbc2kt05h` (`r_id`),
  CONSTRAINT `FKl6wp8e0b9oxr4rlgtbc2kt05h` FOREIGN KEY (`r_id`) REFERENCES `db_role` (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```

### Role 角色表

```sql
CREATE TABLE `db_role` (
  `r_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```

### Permission 授权表

```sql
CREATE TABLE `db_permission` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `p_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `p_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `p_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```

## 使用的库

### lombok

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
</dependency>
```

### fastjson

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.62</version>
</dependency>
```

## 使用的技术

`hibernate ORM框架的实现`
`validation 数据校验`
`fastjson 对象转json`