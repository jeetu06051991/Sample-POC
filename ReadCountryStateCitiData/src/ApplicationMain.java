import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * It is main class to load Country,State,City data
 * 
 * @since 08-Sep-2015 2:34:25 pm IST
 * @author Ranjeet Kharade
 */
public class ApplicationMain {

	public static void main(String[] args) throws IOException {

		Map<String, City> cityMap = new HashMap<>();
		List<City> cityList = new ArrayList<>();
		List<State> stateList = new ArrayList<>();
		List<Country> countryList = new ArrayList<>();
		Map<String, List<String>> stateMap = new HashMap<>();
		Map<String, List<String>> countryMap = new HashMap<>();
		BufferedReader countryReader = new BufferedReader(new FileReader("resources/countries.txt"));
		BufferedReader stateReader = new BufferedReader(new FileReader("resources/states.txt"));
		BufferedReader cityReader = new BufferedReader(new FileReader("resources/cities.txt"));
		
		/*BufferedReader countryReader = new BufferedReader(new FileReader("C:/Users/kharade/Desktop/countries.sql"));
		BufferedReader stateReader = new BufferedReader(new FileReader("C:/Users/kharade/Desktop/states.sql"));
		BufferedReader cityReader = new BufferedReader(new FileReader("C:/Users/kharade/Desktop/cities.sql"));
		*/
		
		String countryLine = countryReader.readLine();
		String cityLine = cityReader.readLine();
		String stateLine = stateReader.readLine();

		try {

			while ((countryLine = countryReader.readLine()) != null) {
				Country country = new Country();
				country.setCountryId(countryLine.split(",")[0].replace("(", "").trim());
				country.setCountryCode(countryLine.split(",")[1].trim());
				country.setCountryName(countryLine.split(",")[2].replace(")", "").trim());
				countryList.add(country);
			}

			while ((stateLine = stateReader.readLine()) != null) {
				State state = new State();
				state.setStateId(stateLine.split(",")[0].replace("(", "").trim());
				state.setStateName(stateLine.split(",")[1].trim());
				state.setCountryId(stateLine.split(",")[2].replace(")", "").trim());
				stateList.add(state);

			}

			while ((cityLine = cityReader.readLine()) != null) {
				City city = new City();
				city.setName(cityLine.split(",")[1].trim());
				city.setStateId(cityLine.split(",")[2].replace(")", "").trim());
				cityList.add(city);
			}

			for (int stateIndex = 0; stateIndex < stateList.size(); stateIndex++) {
				List<String> cityArray = new ArrayList<>();
				for (int cityIndex = 0; cityIndex < cityList.size(); cityIndex++) {
					if (stateList.get(stateIndex).getStateId().trim()
							.equals(cityList.get(cityIndex).getStateId().trim())) {
						cityArray.add(cityList.get(cityIndex).getName());
					}
				}
				stateMap.put(stateList.get(stateIndex).getStateName(), cityArray);

			}

			for (int countryIndex = 0; countryIndex < countryList.size(); countryIndex++) {
				List<String> stateArray = new ArrayList<>();
				for (int stateIndex = 0; stateIndex < stateList.size(); stateIndex++) {
					if (countryList.get(countryIndex).getCountryId().trim()
							.equals(stateList.get(stateIndex).getCountryId().trim())) {
						stateArray.add(stateList.get(stateIndex).getStateName());
					}
				}

				countryMap.put(countryList.get(countryIndex).getCountryName(), stateArray);
			}
			System.out.println("+++++++++++++++++++++" + stateMap.toString());
			System.out.println("+++++++++++++++++++++" + countryMap.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
