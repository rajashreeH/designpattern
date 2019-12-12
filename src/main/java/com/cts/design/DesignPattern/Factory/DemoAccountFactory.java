package com.cts.design.DesignPattern.Factory;

public class DemoAccountFactory {
	public static void main(String[] args) {
		AccountFactory.getAccount("saving account").getMessage();
		AccountFactory.getAccount("current account").getMessage();
		AccountFactory.getAccount("fixed account").getMessage();
		AccountFactory.getAccount("Invalid account").getMessage();
		
	}

}
