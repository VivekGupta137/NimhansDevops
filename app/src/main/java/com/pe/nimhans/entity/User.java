package com.pe.nimhans.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users_auth")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String username;
	
	@Column 
	private String password;
	
	@Column
	private String role;
	
	@Column
	private boolean enabled=true;
	
	@OneToOne(mappedBy = "username")
	private Doctor doctor;
	
//	Collection<? extends GrantedAuthority> authorities;
	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public User() {
		
	}
	
//	public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.authorities = authorities;
//		Iterator it = authorities.iterator();
//		this.role = it.next().toString();
//	}
//	public User(String username, String password, String role) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.role = role;
//		
////		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
////	    authorities.add(new SimpleGrantedAuthority(role));
////		this.authorities = authorities;
////		
//	}
	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
//		Collection<SimpleGrantedAuthority> oldAuthorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
//		List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
//		updatedAuthorities.add(authority);
//		updatedAuthorities.addAll(oldAuthorities);
//		this.authorities = updatedAuthorities;
//		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//	    authorities.add(new SimpleGrantedAuthority(role));
//		this.authorities = authorities;
//		
	}
	
	public Collection<? extends SimpleGrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role);
		List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		updatedAuthorities.add(authority);
        return updatedAuthorities;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
//	@JsonProperty("enabled")
//	public boolean isEnabled() {
//		return enabled;
//	}
//	
//	@JsonProperty("enabled")
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}



//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//	    authorities.add(new SimpleGrantedAuthority(role));
//		this.authorities = authorities;
//		return authorities;
//	}
//
//	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}
	

}
