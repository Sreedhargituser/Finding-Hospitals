package elementmodules;

public class HospitalFilterModule {
	
	//all the locators for the elements in the hospitals page
	public static String URL  ="https://www.practo.com/bangalore/hospitals";
	public static String xpath24x7 = "//div[@data-qa-id='Open_24X7_checkbox']";
	public static String xpathAllFilters = "//i[@data-qa-id='all_filters_icon']";
	public static String xpathHasParking = "//div[@data-qa-id='Has_Parking_checkbox']";
	
	
	
	//xpaths for the dynamically generated web elements which repeated
	public static String[] getXpathsOfRatings(int num) {
		String[] ratingXpaths = new String[num];
		int j = 0;
		for(int i =2; i < num+1; i++) {
			ratingXpaths[j] = ("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/div/div[3]/div[" + i +  "]/div/div[1]/div[2]/div/div[1]/div/div/span[1]");
//			System.out.println(ratingXpaths[j]);
			j++;
			
			
			
		}
		return ratingXpaths;
	}
	
	
	public static String[] getXpathsOfNames(int num) {
		String[] nameXpaths = new String[num];
		int j = 0;
		for(int i = 2; i < num+1; i++) {
			nameXpaths[j] = ("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/div/div[3]/div[" + i + "]/div/div[1]/div[1]/div/div[2]/div/a/h2");
			j++;
		}
		
		return nameXpaths;
	}
	
	
	
}
