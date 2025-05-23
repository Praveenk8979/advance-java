package com.ak.daos;

import java.util.ArrayList;

import com.ak.modals.HR;



public interface HRDao
{

	public HR retrieveHRRecords(int snos);
	public boolean isHRExists(String petitionNo);
    public ArrayList<HR> retrieveHRRecords(String[] snos);

    public HR getHRRecord(int sno);

	public void insertOrUpdateHRRecord(HR hr);
	//public HR retrieveHRRecords(int snos);
	public ArrayList<HR> retrieveHRRecords(ArrayList<String> params);

}
