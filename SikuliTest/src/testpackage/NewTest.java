package testpackage;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;



public class NewTest {
	
	Screen screen = new Screen();
	
  @Test
  public void test1() throws FindFailed {
	  screen.doubleClick("C:\\Users\\Pasindu\\Documents\\Sikuli.sikuli\\chrome.png");
  }
}
