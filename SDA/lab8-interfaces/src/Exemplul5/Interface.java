package Exemplul5;

public class Interface{
public static void main(String[] args) {
  try {
  check t = new check() {
  public void message() {
  System.out.println("Method defined in the interface");
  }
  };
  t.message();
  } catch (Exception ex) {
  System.out.println("" + ex.getMessage());
  }
  }
 }
