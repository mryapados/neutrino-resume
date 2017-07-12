package org.neutrinocms.resume.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.neutrinocms.core.bo.annotation.BOField;
import org.neutrinocms.core.bo.annotation.BOField.ValueType;
import org.neutrinocms.core.bo.annotation.BOResource;
import org.neutrinocms.core.model.notranslation.NoTranslation;


@Entity
@Table(name = "icon")
@BOResource("https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css")
@BOResource("/resources/src/resume/samuel/vendor/flaticons/flaticon.min.css?v=29022016")
public class Icon extends NoTranslation implements Serializable{

	private static final long serialVersionUID = 1L;

	@BOField(type = ValueType.ICON)
	private String flatIcon;

	@BOField(type = ValueType.ICON)
	private String fontAwesome;
	
	@BOField(type = ValueType.ICON)
	private String glyphIcon;

	public Icon() {

	}
	
	public Icon(String name, String flatIcon, String fontAwesome, String glyphIcon) {
		super();
		this.setName(name);
		this.flatIcon = flatIcon;
		this.fontAwesome = fontAwesome;
		this.glyphIcon = glyphIcon;
	}

	public String getFlatIcon() {
		return flatIcon;
	}

	public void setFlatIcon(String flatIcon) {
		this.flatIcon = flatIcon;
	}

	public String getFontAwesome() {
		return fontAwesome;
	}

	public void setFontAwesome(String fontAwesome) {
		this.fontAwesome = fontAwesome;
	}

	public String getGlyphIcon() {
		return glyphIcon;
	}

	public void setGlyphIcon(String glyphIcon) {
		this.glyphIcon = glyphIcon;
	}
	
	
}
