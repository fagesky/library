package org.fogsky.library.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="user")
public class User implements Serializable{
	int id;
	@NotNull
	@Size(min=3,max=10)
	@Pattern(regexp="^\\w+$")
	private String name;
	private byte gender;
	@NotNull
	@Size(min=6,max=25)
	@Pattern(regexp ="^(?![0-9]+$)(?![a-zA-Z]+$)\\w+$")
	 
	private String password;
	private String role;
	private LocalDateTime createdTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createTime) {
		this.createdTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", password=" + password + ", role=" + role
				+ ", createdTime=" + createdTime + "]";
	}
	
	
}
