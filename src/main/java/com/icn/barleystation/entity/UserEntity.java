package com.icn.barleystation.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import org.springframework.lang.Nullable;

@Table(name = "USER")
@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String name;
	@Nullable
	private String profileImage;
	private String mail;
	private String phone;
	private String address;
	@Nullable
	private Boolean status;
	@Temporal(TemporalType.TIMESTAMP)
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
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

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
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
		return "UserEntity [idUser=" + idUser + ", name=" + name + ", nickname=" + profileImage + ", mail=" + mail
				+ ", phone=" + phone + ", address=" + address + ", status=" + status
				+ ", createdDate=" + createdDate + ", profile=" + profile + "]";
	}

}
