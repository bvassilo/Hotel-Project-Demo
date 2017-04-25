public class Room {
	private static int roomCode;
	private int maxCapacity;
	private Reservation[] availability = new Reservation[30];
	private double pricePerPerson;
	//constructor
	public Room(int roomCode,int maxCapacity, double pricePerPerson){
		Room.setRoomCode(roomCode);
		this.setMaxCapacity(maxCapacity);
		this.pricePerPerson = pricePerPerson;
		for (int i=1;i<31;i++){
			getAvailability()[i]= null; 
		}
	}
	//Methods
	public boolean addReservation(Reservation j){
		for(int k = j.getArrival();k <= j.getDuration()+j.getArrival(); k++)
			if (this.getAvailability()[k]==null && this.getMaxCapacity()<=j.getPerson()){
				this.getAvailability()[k]=j;
				j.setHotelRoom(this);
				return true;
			}
			else{
				break;
			}
		return false;		
	}
	public double pricing(){
			double roomEarnings = 0;
			for (int i=1;i<31;i++){
				if (this.getAvailability()[i]==null){
					roomEarnings += 0;
				}
				else{
					roomEarnings += this.pricePerPerson*getAvailability()[i].getPerson();
				}
			}
			System.out.printf("This month up until now this room is going to pay up",roomEarnings,"money");
			return roomEarnings;
		}
	public boolean cancel(int cancelCode){
			for(int i=1;i<31;i++){
				if(getAvailability()[i].getReservationCode()==cancelCode){
					getAvailability()[i]=null;
					return true;
				}
			}
			return false;
		}
	public double completenessQuota(){
			double completenessQuota = 0;
			int completeness = 0;
			for (int i=1;i<31;i++){
				if (getAvailability()[i] != null){
					completeness += 1;
				}
			}
			completenessQuota = (completeness/30)*100;
			System.out.printf("The completeness quota of the room for the month is",completenessQuota,"%");
			return completenessQuota ;
		}
	//getters setters
	public int getRoomCode() {
		return roomCode;
	}
	public static void setRoomCode(int roomCode) {
		Room.roomCode = roomCode;
	}
	public Reservation[] getAvailability() {
		return availability;
	}
	public void setAvailability(Reservation[] availability) {
		this.availability = availability;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}