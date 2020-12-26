package com.mmc.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", indexes = {
        @Index(name = "username", columnList = "user_name")
})
public class User {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String tableName;

    static {
        Table t = User.class.getAnnotation(Table.class);
        tableName = t.name();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
