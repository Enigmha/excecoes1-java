package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecao.DommainException;

public class Reserva {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn))  {
			throw new DommainException("Erro na reserva: Check-Out data maior que a data Check-In ");
		}
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getNumQuarto() {
		return numQuarto;
	}


	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}


	public Date getCheckIn() {
		return checkIn;
	}



	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DommainException( "As data te que ser futuras a data checkin");
		}
		if(!checkOut.after(checkIn))  {
			throw new DommainException("Erro na reserva: Check-Out data maior que a data Check-In ");
		}
		this.checkIn = checkIn;
		this.checkOut =checkOut;

	}
	
	@Override
	public String toString() {
		return "Quarto: "
				+ numQuarto
				+ ", Check-In: "
				+ sdf.format(checkIn)
				+ ", Check-Out: "
				+ sdf.format(checkOut)
				+ ","
				+ duration()
				+ " noites.";
		
	}
	
	
	
	
	
	
	

}
