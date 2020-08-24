package com.epeken.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp_lic_key_tbl")
public class LicKeyTbl {
	
	@Column(name = "id")
	private long id;
	
	@Id
	@Column(name = "license_key")
	private String licenseKey;
	
	@Column(name = "max_allowed_domains")
	private long maxAllowedDomains;
	
	@Column(name = "lic_status")
	private String licStatus;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "txn_id")
	private String txnId;
	
	@Column(name = "manual_reset_count")
	private String manualResetCount;
	
	@Column(name = "date_created")
	private String dateCreated;
	
	@Column(name = "date_renewed")
	private String dateRenewed;
	
	@Column(name = "date_expiry")
	private String dateExpiry;
	
	@Column(name = "last_activated")
	private String lastActivated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public long getMaxAllowedDomains() {
		return maxAllowedDomains;
	}

	public void setMaxAllowedDomains(long maxAllowedDomains) {
		this.maxAllowedDomains = maxAllowedDomains;
	}

	public String getLicStatus() {
		return licStatus;
	}

	public void setLicStatus(String licStatus) {
		this.licStatus = licStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getManualResetCount() {
		return manualResetCount;
	}

	public void setManualResetCount(String manualResetCount) {
		this.manualResetCount = manualResetCount;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateRenewed() {
		return dateRenewed;
	}

	public void setDateRenewed(String dateRenewed) {
		this.dateRenewed = dateRenewed;
	}

	public String getDateExpiry() {
		return dateExpiry;
	}

	public void setDateExpiry(String dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public String getLastActivated() {
		return lastActivated;
	}

	public void setLastActivated(String lastActivated) {
		this.lastActivated = lastActivated;
	}
}