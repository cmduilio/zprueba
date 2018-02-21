package com.samit.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
    private Long id;
	
    @Column(name = "NAME")
	private String name;
	
    @ManyToMany(mappedBy = "roles")
	private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
