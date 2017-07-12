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
import org.neutrinocms.core.bo.annotation.BOViewUrl;
import org.neutrinocms.core.model.translation.Page;

@Entity
@Table(name = "category")
@BOViewUrl("/{lang.code}/{name}.html")
public class Category extends Page {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@BOField(type = ValueType.INTEGER, defaultValue = "9999")
	@Column(name = "ordered")
	private Integer ordered;
	
	@BOField(type = ValueType.COLOR)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "menu_color")
	private String menuColor;

	@BOField(type = ValueType.VARCHAR50)
	@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@Column(name = "title")
	private String title;
	
	@BOField(type = ValueType.BOOLEAN)
	@Column(name = "inmenu")
	private Boolean inMenu;
	
	@BOField(type = ValueType.NTOBJECT)
	@JoinColumn(name="icon_id")
	@OneToOne
	private Icon icon;
	
	public Category() {
		super();
		this.ordered = 9999;
	}

	public Category(String menuColor, String title, Icon icon, Boolean inMenu, Integer ordered) {
		super();
		this.menuColor = menuColor;
		this.title = title;
		this.icon = icon;
		this.ordered = ordered;
		this.inMenu = inMenu;
	}
	
	public String getMenuColor() {
		return menuColor;
	}

	public void setMenuColor(String menuColor) {
		this.menuColor = menuColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public Integer getOrdered() {
		return ordered;
	}

	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}

	public Boolean getInMenu() {
		return inMenu;
	}

	public void setInMenu(Boolean inMenu) {
		this.inMenu = inMenu;
	}

	
	
	
	
	
}
