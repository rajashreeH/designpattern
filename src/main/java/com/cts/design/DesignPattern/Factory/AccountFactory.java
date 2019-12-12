package com.cts.design.DesignPattern.Factory;

public class AccountFactory {
	public static Account getAccount(String accountType){
		if(accountType.equalsIgnoreCase("saving account")){
			return new SavingAccount();
		}
		else if(accountType.equalsIgnoreCase("current account")){
			return new CurrentAccount();
		}
		else if(accountType.equalsIgnoreCase("fixed account")){
			return new FixedAccount();
		}
		else{
			System.out.println("Please select proper account Type 1. Saving Accont 2. Current Account 3. Fixed Account");
			return null;
		}
	}

}
