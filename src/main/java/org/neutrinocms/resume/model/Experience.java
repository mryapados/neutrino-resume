package org.neutrinocms.resume.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.neutrinocms.core.bo.annotation.BOField;
import org.neutrinocms.core.bo.annotation.BOField.ValueType;
import org.neutrinocms.core.model.translation.Translation;

@Entity
@Table(name = "experience")
public class Experience extends Translation {

	private static final long serialVersionUID = 1L;
	
	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "title")
	private String title;

	@NotNull
	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "company_name")
	private String companyName;
	
	@BOField(type = ValueType.HTML)
	@Column(name = "chapo", columnDefinition="TEXT")
	private String chapo;
	
	@NotNull
	@BOField(type = ValueType.DATE)
	@Column(name = "start")
	private Date start;
	
	@BOField(type = ValueType.DATE)
	@Column(name = "end")
	private Date end;
	
	@BOField(type = ValueType.IMAGE)
	private String picture;
	
	@BOField(type = ValueType.TOBJECT)
	@JoinColumn(name="job_id")
	@OneToOne
	private Job job;
	

	public Experience() {
		
	}

	public Experience(String title, String companyName, Date start, Date end) {
		super();
		this.title = title;
		this.companyName = companyName;
		this.start = start;
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getChapo() {
		return chapo;
	}

	public void setChapo(String chapo) {
		this.chapo = chapo;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}


	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
}
