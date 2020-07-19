package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

public class ProgramaEx {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Numero do Quarto: ");
		Integer numQuarto = sc.nextInt();
		System.out.print("Check-IN data (DD/MM/AAAA): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out data (DD/MM/AAAA): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Check-Out data maior que a data Check-In ");
		}
		else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: "+ reserva );
			
		}
		
		System.out.println();
		System.out.println("entra com dados para atualizar a reserva:");
		
		System.out.print("Check-IN data (DD/MM/AAAA): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out data (DD/MM/AAAA): ");
		checkOut = sdf.parse(sc.next());
		
		Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);		
		String error = reserva.updateDates(checkIn, checkOut);
		if(error!= null) {
			System.out.println("erro na resera: "+ error);
		}
		else {
			System.out.println("Reserva: "+ reserva );
		}
		
		
	sc.close();

	}

}
