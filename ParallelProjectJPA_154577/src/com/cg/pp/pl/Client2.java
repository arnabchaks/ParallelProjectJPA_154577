package com.cg.pp.pl;

import java.util.Scanner;

import com.cg.pp.entities.Transactions;
import com.cg.pp.entities.Wallet;
import com.cg.pp.exceptions.WalletExceptions;
import com.cg.pp.service.WalletService;
import com.cg.pp.service.WalletServiceImpl;

public class Client2 {

	public static void main(String[] args) {
		WalletService service = new WalletServiceImpl();
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {

			System.out.println();
			System.out.println("Menu");
			System.out.println("1. Create New Account");
			System.out.println("2. Display Balance");
			System.out.println("3. Deposit Amount");
			System.out.println("4. Withdraw Amount");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Show Transaction History");
			System.out.println("7. Exit");
			System.out.println("Enter your choice");

			if (sc.hasNextInt()) {
				choice = sc.nextInt();
				System.out.println();

				switch (choice) {

				case 1:
					System.out.println("Enter Mobile Number: ");
					String mobileno = sc.next();
					System.out.println("Enter Name: ");
					String name = sc.next();
					System.out.println("Enter Opening Balance: ");
					double balance = sc.nextFloat();
					Wallet wallet = new Wallet();
					wallet.setBalance(balance);
					wallet.setMobileno(mobileno);
					wallet.setName(name);

					try {
						if (service.validateWallet(wallet)) {
							service.create(wallet);
							System.out.println("Wallet created successfully for " + mobileno);
							break;
						}
					} catch (WalletExceptions e) {
						System.err.println(e.getMessage());
						break;
					}
				case 2:
					System.out.println("Enter Mobile Number: ");
					String mobileno1 = sc.next();
					try {
						System.out.println("Your balance is" + service.showBalance(mobileno1));
						break;
					} catch (WalletExceptions e) {
						System.err.println(e.getMessage());
						break;
					}

				case 3:
					System.out.println("Enter Mobile Number: ");
					String mobileno2 = sc.next();
					System.out.println("Enter amount to be added: ");
					double amount = sc.nextDouble();
					try {
						System.out.println("Rs. " + amount + " deposited. Your new balance is: "
								+ service.deposit(mobileno2, amount));
						break;
					} catch (WalletExceptions e) {
						System.err.println(e.getMessage());
						break;
					}

				case 4:
					System.out.println("Enter Mobile Number: ");
					String mobileno3 = sc.next();
					System.out.println("Enter amount to be withdrawn: ");
					double amount1 = sc.nextDouble();
					try {
						System.out.println("Rs. " + amount1 + " withdrawn. Your new balance is: "
								+ service.withdraw(mobileno3, amount1));
						break;
					} catch (WalletExceptions e) {
						System.err.println(e.getMessage());
						break;
					}

				case 5:
					System.out.println("Enter the mobile number to transfer funds FROM: ");
					String mob_from = sc.next();
					System.out.println("Enter the mobile number to transfer funds TO: ");
					String mob_to = sc.next();
					System.out.println("Please enter the amount you wish to transfer: ");
					double amount2 = sc.nextDouble();
					try {
						System.out.println("Rs. " + amount2 + " transferred. Your new balance is: "
								+ service.transfer(mob_from, mob_to, amount2).getBalance());
						System.out.println("Successfully transferred.");

					} catch (Exception e) {
						System.err.println(e.getMessage());
						break;
					}

				case 6:
					System.out.println("Enter Mobile Number: ");
					String mobileno4 = sc.next();

					try {
						for (Transactions transaction : service.printTransactions(mobileno4)) {
							System.out.println(transaction);
						}

					} catch (Exception e6) {
						System.err.println(e6.getMessage());
						System.out.println("Please try again!");
						break;
					}

				case 7:
					break;
				default:
					System.out.println("Please enter a valid input!");
				}
			} else {
				System.out.println("Please enter a valid input!");
				break;
			}
		} while (choice != 7);
		sc.close();

	}

}