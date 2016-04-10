package com.accdays.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUD_GROUP")//注意GROUP表明可能被mysql占用必须用另外的名字
public class Group implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Set<User> users=new HashSet<User>(0);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	/**
	 * cascade=CascadeType.ALL不用两边都配置,配置在哪方，表示哪方的操作将会级联引起另一方的操作，
	 * 且一般配置在one这方，因为删除一方时，可以方便的删除many方；如果配置在many方，删除一个子对象时级联删除父对象，这是如果父对象还被其他子对象引用，程序将报错
	 * @Description
	 * @author hedong
	 * @date 2013-7-23 下午11:21:32
	 * @modifyNote 
	 * @return
	 */
	@OneToMany(cascade=CascadeType.ALL,mappedBy="group")//不生成字段的表，加mappedBy属性进行映射
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
