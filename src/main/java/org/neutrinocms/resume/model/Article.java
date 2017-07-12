package org.neutrinocms.resume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.neutrinocms.core.bo.annotation.BOField;
import org.neutrinocms.core.bo.annotation.BOField.ValueType;
import org.neutrinocms.core.bo.annotation.BOViewUrl;
import org.neutrinocms.core.model.translation.Page;

@Entity
@Table(name = "article")
@BOViewUrl("/{lang.code}/article/{name}.html")
public class Article extends Page {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@BOField(type = ValueType.INTEGER, defaultValue = "9999", inList = false)
	@Column(name = "ordered")
	private Integer ordered;

	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "title")
	private String title;
	
	@BOField(type = ValueType.HTML, inList = false)
	@Column(name = "chapo", columnDefinition="TEXT")
	private String chapo;
	
	@BOField(type = ValueType.IMAGE)
	private String picture;
	
	public Article() {
		super();
		this.ordered = 9999;
	}

	public Article(String title, String picture, Integer ordered) {
		super();
		this.title = title;
		this.picture = picture;
		this.ordered = ordered;
	}

	public Integer getOrdered() {
		return ordered;
	}

	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChapo() {
		return chapo;
	}

	public void setChapo(String chapo) {
		this.chapo = chapo;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
}
