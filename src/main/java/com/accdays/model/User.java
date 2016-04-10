package com.accdays.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="USER")
public class User implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String password;
	private Date bithday;
	private String address;
	private Group group;
	private Integer enabled;
	private Set<UserRole> userRoles;
	
//	TABLE：使用一个特定的数据库表格来保存主键。 
//	SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。 
//	IDENTITY：主键由数据库自动生成（主要是自动增长型） 
//	AUTO：主键由程序控制。
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY：主键由"数据库"自动生成（主要是自动增长型）;注意默认AUTO主键由程序控制
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
	
	public Date getBithday() {
		return bithday;
	}
	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}
	@Column(columnDefinition="varchar(100)")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@XmlTransient //解除webservice中对group的循环引用
	@ManyToOne
	@JoinColumn(name="group_id")//@JoinColumn 在当前表这个属性要生成表字段
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	/**
	 * @return the password
	 */
	@Column(columnDefinition="varchar(100)")
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the enabled
	 */
	@Column(columnDefinition="int(1)")
	public Integer getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * @return the userRoles
	 */
	@XmlTransient //解除webservice中对group的循环引用
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")//不生成字段的表，加mappedBy属性进行映射
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
}
