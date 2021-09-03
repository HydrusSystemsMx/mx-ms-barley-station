package com.icn.barleystation.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Table(name = "USER")
@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	private String name;
	@Nullable
	private String nickname;
	private String mail;
	private String phone;
	private String password;
	private String address;
	@Nullable
	private Boolean status;
	private Date createdDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USERPROFILE", joinColumns = @JoinColumn(name = "idUser"), inverseJoinColumns = @JoinColumn(name = "idProfile"))
	private List<ProfileEntity> profile;

	public void addProfile(ProfileEntity tempProfile) {
		if (profile == null) {
			profile = new LinkedList<ProfileEntity>();
		}
		profile.add(tempProfile);
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<ProfileEntity> getProfile() {
		return profile;
	}

	public void setProfile(List<ProfileEntity> profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", name=" + name + ", nickname=" + nickname + ", mail=" + mail
				+ ", phone=" + phone + ", password=" + password + ", address=" + address + ", status=" + status
				+ ", createdDate=" + createdDate + ", profile=" + profile + "]";
	}

}
