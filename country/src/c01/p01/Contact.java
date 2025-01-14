package c01.p01;

//Contact.java

/*
 * [주석 3: 인터페이스]
 * saveContact와 displayContacts 메소드 선언 
 */
interface Contact {
 void saveContact(String name, String country, String phoneNumber) throws Exception; // 전화번호 저장 
 void displayContacts();  //전화번호 출력
}
