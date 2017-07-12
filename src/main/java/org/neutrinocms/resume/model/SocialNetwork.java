package org.neutrinocms.resume.model;

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
@Table(name = "social_network")
//@NamedEntityGraphs({
//	@NamedEntityGraph(
//		name = "Project.allJoins", 
//		attributeNodes = { 
//			@NamedAttributeNode("albums")
//		})
//})
public class SocialNetwork extends Translation {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@BOField(type = ValueType.INTEGER, defaultValue = "9999")
	@Column(name = "ordered")
	private Integer ordered;
	
	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "title")
	private String title;
	
	@BOField(type = ValueType.VARCHAR255)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "url")
	private String url;
		
	@BOField(type = ValueType.NTOBJECT)
	@JoinColumn(name="icon_id")
	@OneToOne
	private Icon icon;

	
	public SocialNetwork() {
		super();
		this.ordered = 9999;
	}



	public SocialNetwork(String title, String url, Icon icon, Integer ordered) {
		super();
		this.title = title;
		this.url = url;
		this.icon = icon;
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

	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	
	
}
