package org.neutrinocms.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.neutrinocms.core.bo.annotation.BOField;
import org.neutrinocms.core.bo.annotation.BOField.ValueType;
import org.neutrinocms.core.model.translation.Translation;

@Entity
@Table(name = "education")
public class Education extends Translation {

	private static final long serialVersionUID = 1L;
	
	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "title")
	private String title;

	@NotNull
	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "school_name")
	private String schoolName;
	
	@BOField(type = ValueType.HTML)
	@Column(name = "chapo", columnDefinition="TEXT")
	private String chapo;
	
	@NotNull
	@BOField(type = ValueType.INTEGER)
	@Column(name = "year")
	private Integer year;
	
	@BOField(type = ValueType.FILE)
	private String picture;


	public Education() {
		
	}

	public Education(String title, String schoolName, Integer year) {
		super();
		this.title = title;
		this.schoolName = schoolName;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getChapo() {
		return chapo;
	}

	public void setChapo(String chapo) {
		this.chapo = chapo;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
}
