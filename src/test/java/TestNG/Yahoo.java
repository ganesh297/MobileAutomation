package TestNG;

import org.testng.annotations.Test;

public class Yahoo {
	
	@Test(priority=0)
	public void launchBrowser(){
		System.out.println("Launching Browser");		
	}

	@Test(priority=1)
	public void loadYahoo(){
		System.out.println("Loading Yahoo");		
	}

	@Test(priority=2)
	public void composeMail(){
		System.out.println("Composing Yahoo Mail");		
	}
	
	@Test(priority=3)
	public void Logout(){
		System.out.println("Yahoo Logout");		
	}

}
