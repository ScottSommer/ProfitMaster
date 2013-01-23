package org.sommer.pm.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.sommer.pm.application.Util;

@Entity(name="TimeLeft")
@Table(name="TimeLeft")
public class TimeLeft implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7443262119653998006L;
	
	private Long id;
	private String description;
	
	@GeneratedValue
	@Id
	@Generated(GenerationTime.ALWAYS)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TimeLeft [id=" + id + ", description=" + description + "]";
	}
	
}