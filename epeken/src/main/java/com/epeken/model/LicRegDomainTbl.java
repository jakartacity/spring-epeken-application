package com.epeken.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp_lic_reg_domain_tbl")
public class LicRegDomainTbl {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "lic_key_id")
	private long licKeyId;
	
	@Id
	@Column(name = "lic_key")
	private String licKey;
	
	@Column(name = "registered_domain")
	private String registeredDomain;
	
	@Column(name = "item_reference")
	private String itemReference;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLickeyId() {
		return licKeyId;
	}

	public void setLicKeyId(long licKeyId) {
		this.licKeyId = licKeyId;
	}

	public String getLicKey() {
		return licKey;
	}

	public void setLicKey(String licKey) {
		this.licKey = licKey;
	}

	public String getRegisteredDomain() {
		return registeredDomain;
	}

	public void setRegisteredDomain(String registeredDomain) {
		this.registeredDomain = registeredDomain;
	}

	public String getItemReference() {
		return itemReference;
	}

	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
	}
}
