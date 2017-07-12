package org.neutrinocms.resume.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.neutrinocms.bo.model.Link;
import org.neutrinocms.core.bo.annotation.BOField;
import org.neutrinocms.core.bo.annotation.BOField.ValueType;
import org.neutrinocms.core.model.translation.Translation;

@Entity
@Table(name = "resume")

@NamedEntityGraphs({
	@NamedEntityGraph(
		name = "Resume.allJoins", 
		attributeNodes = { 
			@NamedAttributeNode("links"),
		})
})

public class Resume extends Translation {

	private static final long serialVersionUID = 1L;

	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "first_name")
	private String firstName;
	
	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "last_name")
	private String lastName;

	@BOField(type = ValueType.VARCHAR255)
	@NotNull
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "function")
	private String function;
	
	@BOField(type = ValueType.VARCHAR50)
	@NotNull
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "email")
	private String email;
	
	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "phone")
	private String phone;
	
	@BOField(type = ValueType.DATE)
	@Column(name = "dateofbirth")
	private Date dateOfBirth;
	
	@BOField(type = ValueType.VARCHAR255)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "address")
	private String address;
	
	@BOField(type = ValueType.FILE)
	private String picture;
	
	@BOField(type = ValueType.FILE)
	private String banner;
	
	@BOField(type = ValueType.FILE)
	private String downloadableFile;

	@BOField(type = ValueType.COLLECTION, ofType = ValueType.TOBJECT)
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="resume_links", joinColumns=@JoinColumn(name="link_id"))
	@Column(name = "links")
	private Set<Link> links;

	public Resume() {
		
	}
	
	public Resume(String firstName, String lastName, String function, String email, String phone, Date dateOfBirth, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.function = function;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDownloadableFile() {
		return downloadableFile;
	}

	public void setDownloadableFile(String downloadableFile) {
		this.downloadableFile = downloadableFile;
	}

	public Set<Link> getLinks() {
		return links;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
