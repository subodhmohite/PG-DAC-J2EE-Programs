package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// = new SoapTransport();

	private ATMImpl(Transport t) {
		this.myTransport=t;
		System.out.println("in cnstr of " + getClass() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
	// Constructor based D.I
	


	// custom init method
	public void anyInit() {
		System.out.println("in init " + myTransport);
	}

	// custom destroy method
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);
	}
	
	//add a method factory method for D.i
	public static ATMImpl myFactoryMethod(Transport t12) {
		
		System.out.println("in factory Mentod");
		return new ATMImpl(t12);//partial IoC 
		}

}
