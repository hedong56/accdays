package com.accdays.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户角色表
 * @author hedong
 * @date 2013-12-6 下午2:25:04
 * @modifyNote
 * @version 1.0
 */
@Entity
@Table(name="USER_ROLE")
public class UserRole {
	private Integer id;
	private String role;
	private User user;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY：主键由"数据库"自动生成（主要是自动增长型）;注意默认AUTO主键由程序控制
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * @return the user
	 */
	@ManyToOne
	@JoinColumn(name="user_id")//@JoinColumn 在当前表这个属性要生成表字段
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
