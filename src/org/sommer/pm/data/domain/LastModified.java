package org.sommer.pm.data.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity(name="LastModified")
@Table(name="LastModified")
public class LastModified implements Serializable {

	private Long id;
	private BigInteger time;
	
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

	@Column(name="Time")
	public BigInteger getTime() {
		return time;
	}
	public void setTime(BigInteger time) {
		this.time = time;
	}
}