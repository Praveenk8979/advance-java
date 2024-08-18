package com.meda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="form_handle")
@ToString
public class FormHandle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Sno")
	private int sno;
	
	@Column(name="FileId")
	private String fileId;
	
	@Column(name="VolumeNo")
	private String volumeNo;
	
	@Column(name="BookNo")
	private String bookNo;
	
	@Column(name="PageFrom")
	private String pageFrom;
	
	@Column(name="PageTo")
	private String pageTo;
	
	@Column(name="DateOfRegistration")
	private String dateOfRegistration;
	
	@Column(name="DocumentType")
	private String documentType;
	
	@Column(name="RegistrationDistrict")
	private String registrationDistrict;
	
	@Column(name = "Department")
	private String department;
	
	@Column(name="Location")
	private String location;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getVolumeNo() {
		return volumeNo;
	}

	public void setVolumeNo(String volumeNo) {
		this.volumeNo = volumeNo;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getPageFrom() {
		return pageFrom;
	}

	public void setPageFrom(String pageFrom) {
		this.pageFrom = pageFrom;
	}

	public String getPageTo() {
		return pageTo;
	}

	public void setPageTo(String pageTo) {
		this.pageTo = pageTo;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getRegistrationDistrict() {
		return registrationDistrict;
	}

	public void setRegistrationDistrict(String registrationDistrict) {
		this.registrationDistrict = registrationDistrict;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}
