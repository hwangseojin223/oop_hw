package c01.p01;

//Country.java

class Country {
 private String name;
 private String code;

 public Country(String name, String code) {
     this.name = name;
     this.code = code;
 }

 public String getCode() {
     return code;
 }
 public String getName() {
     return name; 
 }
}