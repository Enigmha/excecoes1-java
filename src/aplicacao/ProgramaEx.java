package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;
import model.excecao.DommainException;

public class ProgramaEx {

	public static void main(String[] args) {
		
		

			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		
		try {

			System.out.print("Numero do Quarto: ");
			Integer numQuarto = sc.nextInt();
			System.out.print("Check-IN data (DD/MM/AAAA): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out data (DD/MM/AAAA): ");
			Date checkOut = sdf.parse(sc.next());


			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: "+ reserva );



			System.out.println();
			System.out.println("entra com dados para atualizar a reserva:");

			System.out.print("Check-IN data (DD/MM/AAAA): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out data (DD/MM/AAAA): ");
			checkOut = sdf.parse(sc.next());

			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
		}
		catch(ParseException e) {
			System.out.println("Invalida forma da Data");
		}
		catch(DommainException e) {
			System.out.println("Erro na reserva "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro Inesperado");
		}
		
		
	sc.close();

	}

}
