package com.aptech.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;


    @Id 
    @Column(name="username", unique=true, nullable=false)
	private String username;
    
    @Column(name="enabled", nullable=false)
	private boolean enabled;
	
	@Column(name="password", unique=true, nullable=false)
	private String password;

	//bi-directional many-to-one association to Userrole
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserRole> userRoles;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserroles() {
		return this.userRoles;
	}

	public void setUserroles(List<UserRole> userroles) {
		this.userRoles = userroles;
	}

	public UserRole addUserrole(UserRole userrole) {
		getUserroles().add(userrole);
		userrole.setUser(this);

		return userrole;
	}

	public UserRole removeUserrole(UserRole userrole) {
		getUserroles().remove(userrole);
		userrole.setUser(null);

		return userrole;
	}

}