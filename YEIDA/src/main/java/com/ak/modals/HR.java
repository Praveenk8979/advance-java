package com.ak.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR")
public class HR {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SNO")
	private int sno;

	@Column(name = "Date")
	private String date;

	@Column(name = "File_No")
	private String fileNo;

	@Column(name = "File_Code")
	private String fileCode;

	@Column(name = "Year")
	private String year;

	@Column(name = "File_Subject")
	private String fileSubject;

	@Column(name = "OPA_FTS")
	private String opaFts;

	@Column(name = "Employee_Code")
	private String employeeCode;

	@Column(name = "Employee_Name")
	private String employeeName;

	@Column(name = "Employee_Category")
	private String employeeCategory;

	@Column(name = "Employee_Designation")
	private String employeeDesignation;

	@Column(name = "Employee_DOB")
	private String employeeDob;

	@Column(name = "Employee_DOJ")
	private String employeeDoj;

	@Column(name = "No_Of_Noteeing")
	private String noOfNoteeing;

	@Column(name = "Nop_Of_Coss")
	private String noOfCoss;

	@Column(name = "Total_No_Of_Pages")
	private String totalPages;

	private String location;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFileSubject() {
		return fileSubject;
	}

	public void setFileSubject(String fileSubject) {
		this.fileSubject = fileSubject;
	}

	public String getOpaFts() {
		return opaFts;
	}

	public void setOpaFts(String opaFts) {
		this.opaFts = opaFts;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCategory() {
		return employeeCategory;
	}

	public void setEmployeeCategory(String employeeCategory) {
		this.employeeCategory = employeeCategory;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(String employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeDoj() {
		return employeeDoj;
	}

	public void setEmployeeDoj(String employeeDoj) {
		this.employeeDoj = employeeDoj;
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

}
