package c01.p01;

// DisplayCountry.java

/*
 * [주석 2: 클래스 상속]
 * DisplayCountry 클래스는 Country 클래스를 상속받고 있습니다.
 */
class DisplayCountry extends Country {
	private String capital;
	
    public DisplayCountry(String name, String code, String capital) {
        super(name, code);
        this.capital = capital;
    }
    public void displayInfo() {
        System.out.println("국가: " + getName() + ", 코드: " + getCode() + ", 수도: " + capital);
    }
}
