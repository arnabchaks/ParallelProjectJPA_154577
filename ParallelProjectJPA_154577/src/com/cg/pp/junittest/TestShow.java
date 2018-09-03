package com.cg.pp.junittest;

import static org.junit.Assert.assertEquals;

import com.cg.pp.exceptions.WalletExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class TestShow {
	WalletService wser = new WalletServiceImpl();

	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testCorrect() {
		System.out.println("From test show correct");
		String mobileno = "9649861046";
		try {
			assertEquals(2750.0, wser.showBalance(mobileno));
		} catch (WalletExceptions e) {
			System.err.println(e.getMessage());
		}

	}

	@org.junit.Test
	public void testWrong() {
		System.out.println("From test show correct");
		String mobileno = "9649861045";
		try {
			assertEquals(new WalletExceptions(), wser.showBalance(mobileno));
		} catch (WalletExceptions e) {
			System.err.println(e.getMessage());
		}

	}
}
