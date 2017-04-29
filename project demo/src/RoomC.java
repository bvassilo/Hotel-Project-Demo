
public class RoomC extends Room{
	private int minCapacity;
	private int minDuration;
	//constructor
	public RoomC(int roomCode, int maxCapacity, double pricePerPerson,int minCapacity,int minDuration) {
		super(roomCode, maxCapacity, pricePerPerson);
		this.minCapacity = minCapacity;
		this.minDuration = minDuration;
		}
	//methods
	public boolean addReservation(Reservation j){
		for(int k=j.getArrival();k<=j.getDuration()+j.getArrival();k++)
			if (this.getAvailability(k)==null && this.getMaxCapacity()<=j.getPerson() && j.getPerson()>=minCapacity && j.getDuration()>=minDuration){
				this.setAvailability(j,k);
				j.setHotelRoom(this);
				return true;
			}
			else{
				break;
			}
		return false;
	}
}
