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

@Entity(name="Snapshot")
@Table(name="Snapshot")
public class Snapshot implements Serializable {
	
	private Integer id;
	private String url;
	private BigInteger lastModified;

	@GeneratedValue
	@Id
	@Generated(GenerationTime.ALWAYS)
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="Url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="LastModified")
	public BigInteger getLastModified() {
		return lastModified;
	}
	public void setLastModified(BigInteger lastModified) {
		this.lastModified = lastModified;
	}
	
}
