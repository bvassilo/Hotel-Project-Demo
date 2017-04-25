
public class RoomD extends Room {
	private int maxDuration ;
	//constructor
	public RoomD(int roomCode, int maxCapacity, double pricePerPerson,int maxDuration) {
		super(roomCode, maxCapacity, pricePerPerson);
		this.maxDuration=maxDuration;
	}
	//methods
	public boolean addReservation(Reservation j){
		for(int k = j.getArrival();k <= j.getDuration()+j.getArrival(); k++)
			if (this.getAvailability()[k]==null && this.getMaxCapacity()<=j.getPerson() && j.getDuration()<= maxDuration){
				this.getAvailability()[k]=j;
				j.setHotelRoom(this);
				return true;
			}
			else{
				break;
			}
		return false;
	}
	public boolean cancel(int cancelCode){
		return false;
	}
}
