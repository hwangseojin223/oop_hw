
package c01.p01;
// PhoneNumber.java

import java.io.*;
import java.util.*;

/*
 * [주석 5: 다형성(상속/인터페이스)
 * Contact interface 와 그 하위 클래스인 CompanyNumbr, PhoneNumber를 통해 다형성을 구현했습니다.
 */
public class PhoneNumber implements Contact {
	/*
	 * [주석 7: 컬렉션 프레임워크]
	 * Map은 키-값 쌍으로 데이터를 저장하는데 사용됩니다.
	 * 여기서는 국가이름(String)을 키로 하고, 해당 국가의 정보를 담고 있는 Country 객체를 값으로 저장하는 HashMap이 사용되고 있습니다. 
	 * List는 순서가 있는 데이터의 집합을 저장하는데 사용됩니다.
	 * 여기서는 저장된 연락처 정보를 String 형태로 저장하는 ArrayList가 사용되고 있습니다.
	 */
    private static Map<String, Country> countryMap = new HashMap<>();
    private static List<String> savedContacts = new ArrayList<>();  // 저장된 연락처 목록
    private static Scanner scanner = new Scanner(System.in); 

    static {
        try {
            loadCountries();
        } catch (IOException e) {
            System.err.println("국가 정보를 로드하는 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 국가 정보를 csv 파일에서 로드
    private static void loadCountries() throws IOException {
    	/*
    	 * [주석 8 : 파일 입/출력 사용]
    	 * BufferedReader와 FileReader를 통해 countries.csv 파일에서 데이터를 읽어옵니다.
    	 */
        BufferedReader reader = new BufferedReader(new FileReader("countries.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
        	/*
        	 * [주석 6 : 참조타입(배열/열거타입)
        	 * String[] parts 배열은 csv 파일에서 읽어온 한 줄의 데이터를 구분자로 나누어 저장하는데 사용됩니다.
        	 */
            String[] parts = line.split(",");  // 구분자를 기준으로 나누
            if (parts.length >= 3) {  // 국가, 국가번호, 수도가 모두 있는지 확인
                String countryName = parts[0].trim();
                String countryCode = parts[1].trim();
                String capital = parts[2].trim();

                // DisplayCountry 객체 생성하여 국가 정보 저장
                countryMap.put(countryName, new DisplayCountry(countryName, countryCode, capital));
            } else {
                System.out.println("유효하지 않은 행: " + line); 
            }
        }
        reader.close();  
    }
    /*
     * [주석 4: 예외처리]
     * 사용자의 입력을 처리하다 발생하는 예외를 처리하고 발생한 예외의 메시지를 출력합니다.
     */

    @Override
    public void saveContact(String name, String country, String phoneNumber) throws Exception {
        while (!countryMap.containsKey(country)) {
            System.out.println("오류 발생: 국가를 찾을 수 없습니다. 다시 입력하세요.");
            System.out.print("국가를 입력하세요: ");
            country = scanner.nextLine();  
        }

        DisplayCountry countryObj = (DisplayCountry) countryMap.get(country);
        String countryCode = countryObj.getCode();
        String fullPhoneNumber = "+" + countryCode + " | " + phoneNumber;  
        String contactInfo = name + " | " + country + " | " + fullPhoneNumber + " |";
        savedContacts.add(contactInfo);  
        System.out.println("저장된 연락처: " + contactInfo);
        countryObj.displayInfo();  // 수도출력 
    }

    @Override
    public void displayContacts() {
        System.out.println("| 이름 | 국가 | 국가코드 | 전화번호 |");
        for (String contact : savedContacts) {
            System.out.println("| " + contact); 
        }
    }
}