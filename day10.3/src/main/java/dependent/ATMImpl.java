package dependent;

import dependency.HttpTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	private long cash;//mandatory dependency 
	private Transport myTransport;//optional dependency

	public ATMImpl() {
		
		System.out.println("in cnstr of " + getClass() + " " + myTransport);
	}
	
	

	public ATMImpl(long cash) {
		super();
		this.cash = cash;
		System.out.println("in cnstr of " + getClass() + " " + cash+" ");
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

	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter - " + myTransport);
	}

}
