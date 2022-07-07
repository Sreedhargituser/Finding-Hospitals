package outputs;

import java.util.List;
import common.*;
import connectors.*;
import elementmodules.*;
import findinghospitals.*;

public class HospitalsLists {
	public static List<String> hospitals;
	public static List<String> topCities;
	
	public static void printList(List<String> list) {
		for(String ele : list) {
			System.out.println(ele);
		}
	}
	public static void setLists(List cityList, List HospitalList) {
		hospitals = HospitalList;
		topCities = cityList;
	}
}



