package com.ak.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *	@Author
 *	Swapril Tyagi
*/

@Entity
@Table(name="Law")
public class Law
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Sno")
	private int sno;

	@Column(name="Department")
	private String department;
	
	@Column(name="CourtName")
	private String courtName;
	
	@Column(name="WritPatitionNumber")
	private String writPatitionNumber;
	
	@Column(name="Year")
	private String year;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="AdvocateName")
	private String advocateName;
	
	@Column(name="RelatedDepartment")
	private String relatedDepartment;
	
	@Column(name="Sector")
	private String sector;
	
	@Column(name="OPA_FTS")
	private String opaFTS;
	
	@Column(name="No_Of_Noteeing")
	private String noOfNoteeing;
	
	@Column(name = "Nop_Of_Coss")
	private String noOfCoss;
	
	@Column(name = "Total_No_Of_Pages")
	private String totalPages;
	
	@Column(name="Location")
	private String location;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getWritPatitionNumber() {
		return writPatitionNumber;
	}

	public void setWritPatitionNumber(String writPatitionNumber) {
		this.writPatitionNumber = writPatitionNumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAdvocateName() {
		return advocateName;
	}

	public void setAdvocateName(String advocateName) {
		this.advocateName = advocateName;
	}

	public String getRelatedDepartment() {
		return relatedDepartment;
	}

	public void setRelatedDepartment(String relatedDepartment) {
		this.relatedDepartment = relatedDepartment;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getOpaFTS() {
		return opaFTS;
	}

	public void setOpaFTS(String opaFTS) {
		this.opaFTS = opaFTS;
	}

	public String getNoOfNoteeing() {
		return noOfNoteeing;
	}

	public void setNoOfNoteeing(String noOfNoteeing) {
		this.noOfNoteeing = noOfNoteeing;
	}

	public String getNoOfCoss() {
		return noOfCoss;
	}

	public void setNoOfCoss(String noOfCoss) {
		this.noOfCoss = noOfCoss;
	}

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}