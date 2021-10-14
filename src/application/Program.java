package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<TaxPayer>();
		
		System.out.println("Enter the number of taxpayer");
		int N = sc.nextInt();
		
		for (int i = 1; i<= N; i++) {
			System.out.println("Taxpayer #" + i +" data:");
			System.out.println("Individual or company (i/c) ? ");
			char type = sc.next().charAt(0);
			
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Anual icome: ");
			Double anualIcome = sc.nextDouble();
			
			if(type == 'i') {
				System.out.println("Health expenditures: ");
				Double he = sc.nextDouble();
				Individual x = new Individual(name, anualIcome, he);
				list.add(x);
			}else {
				System.out.println("Number of employees: ");
				Integer numberOfEmployess = sc.nextInt();
				Company comapany = new Company(name, anualIcome, numberOfEmployess);
				list.add(comapany);
			}
			
		}
		
		System.out.println("");
		System.out.println("TAXE PAID: ");
		
		double sum = 0.0;
		for(TaxPayer tp : list) {
			System.out.println(tp.getName() +": $ " +String.format("%.2f", tp.tax()));
		}
		System.out.println("");
		for(TaxPayer tp : list) {
			sum += tp.tax();
		}
		
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
				
		sc.close();
	}

}
