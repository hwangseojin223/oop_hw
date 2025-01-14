package c01.p01;

//CountryPhoneSystem.java

/*[주석 1 : 과제 설명]
 * // 202003800 컴퓨터전자시스템공학부 황서진 
 * 국가별 전화번호를 관리하는 시스템으로, 개인 혹은 회사의 연락처를 추가하고 저장된 연락처를 출력하는 기능을 제공합니다.
 * 연락처를 추가할 때, 국가 코드를 모르더라도 국가를 입력하면 자동으로 전화번호부에 국가 코드를 붙여서 저장해줍니다.
 */

import java.util.Scanner;

public class CountryPhoneSystem {
    public static void main(String[] args) {
        /*
         * [주석 4: 예외처리]
         * 사용자의 입력을 처리하다 발생하는 예외를 처리하고 발생한 예외의 메시지를 출력합니다.
         */

        try {
            PhoneNumber phoneNumberManager = new PhoneNumber(); // 개인 번호 관리 객체 
            CompanyNumber companyNumberManager = new CompanyNumber(); // 회사 번호 관리 객체 
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // 메뉴 선택
                System.out.println("1. 개인 연락처 추가");
                System.out.println("2. 회사 연락처 추가");
                System.out.println("3. 보기");
                System.out.print("원하는 기능을 선택하세요 (1/2/3): ");
                String option = scanner.nextLine();

                if (option.equals("1")) {
                    // 개인 연락처 추가
                    System.out.print("이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    System.out.print("국가를 입력하세요: ");
                    String country = scanner.nextLine();
                    System.out.print("전화번호를 입력하세요 (국가 코드 제외): ");
                    String phoneNumber = scanner.nextLine();

                    phoneNumberManager.saveContact(name, country, phoneNumber);
                } else if (option.equals("2")) {
                    // 회사 연락처 추가
                    System.out.print("회사명을 입력하세요: ");
                    String companyName = scanner.nextLine();
                    System.out.print("국가를 입력하세요: ");
                    String country = scanner.nextLine();
                    System.out.print("전화번호를 입력하세요 (국가 코드 제외): ");
                    String phoneNumber = scanner.nextLine();

                    companyNumberManager.saveContact(companyName, country, phoneNumber);
                } else if (option.equals("3")) {
                    // 보기 기능
                    System.out.println("|저장된 개인 전화번호들|");
                    phoneNumberManager.displayContacts();
                    System.out.println();
                    System.out.println("|저장된 회사 전화번호들|");
                    companyNumberManager.displayContacts();
                } else {
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                }

                System.out.print("다시 메뉴로 돌아가시겠습니까? (예/아니오): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("아니오")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("오류 발생: " + e.getMessage());
        }
        
    }
}
