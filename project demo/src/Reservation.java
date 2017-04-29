import java.util.Random;
public class Reservation {
	private String clientName;
	private int reservationCode;
	private int arrival;
	private int duration;
	private int person;
	private Room hotelRoom = null;
	//Constructor
	public Reservation(String clientName,int arrival,int duration,int person){
		this.setClientName(clientName);
		this.setArrival(arrival);
		this.setDuration(duration);
		this.setPerson(person);
		Random rand = new Random();
		this.setReservationCode(rand.nextInt(1800)+1);
	}
	//Getters Setters
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getReservationCode() {
		return reservationCode;
	}
	public void setReservationCode(int reservationCode) {
		this.reservationCode = reservationCode;
	}
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public Room getHotelRoom() {
		return hotelRoom;
		
	}
	//method
	public void setHotelRoom(Room hotelRoom) {
		this.hotelRoom = hotelRoom;
		
	}	
}