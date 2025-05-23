package com.ak.services;
import java.util.ArrayList;

import com.ak.modals.HR;



public interface HRService{

	public HR retrieveLawRecords(int snos);
	public boolean isHRExists(String petitionNo);
    public ArrayList<HR> retrieveHRRecords(String[] snos);
    public void insertOrUpdateHRRecord(HR hr);
	//public HR retrieveHRRecords(int snos);
	public ArrayList<HR> retrieveHRRecords(ArrayList<String> params);
	public HR retrieveHRRecords(int snos);
	public HR getHRRecord(int sno);
}
