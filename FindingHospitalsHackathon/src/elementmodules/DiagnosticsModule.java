package elementmodules;
public class DiagnosticsModule {
	
		public static String URL = "https://www.practo.com/tests";
		
		public static String clearSearchXpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div/div/div/i";
		public static String searchBoxXpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div/div/div/input";
		
		public static String[] getCityXpaths() {
			String cityXpaths[] = new String[6];
			int j = 0;
			for(int i = 1; i< 7; i++) {
			    String str =  "/html/body/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[ " + i + " ]/div[2]";
				cityXpaths[j] = str;
				j++;
				
			}
			
			
			return cityXpaths;
		}
}
