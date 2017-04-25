package com.aptech.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userrole database table.
 * 
 */
@Entity
@Table(name="UserRole")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userRoleId",
		unique = true, nullable = false)
	private int userRoleId;

	@Column(name="role", nullable=false)
	private String role;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	private User user;

	public UserRole() {
	}

	public int getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}