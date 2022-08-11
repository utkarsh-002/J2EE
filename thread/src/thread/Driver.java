package thread;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		GetNumber t1 = new GetNumber();
		GetVowel t2 = new GetVowel();
		
		t1.start();
		Thread.sleep(6000);
		t2.start();

	}

}
