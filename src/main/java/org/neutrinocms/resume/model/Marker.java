package org.neutrinocms.resume.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.neutrinocms.core.bo.annotation.BOField;
import org.neutrinocms.core.bo.annotation.BOField.ValueType;
import org.neutrinocms.core.model.notranslation.NoTranslation;

@Entity
@Table(name = "marker")
public class Marker extends NoTranslation implements Serializable{

	private static final long serialVersionUID = 1L;

	@BOField(type = ValueType.DOUBLE)
	@Column(name = "longitude")
	private Double longitude;
	
	@BOField(type = ValueType.DOUBLE)
	@Column(name = "latitude")
	private Double latitude;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
	
}
