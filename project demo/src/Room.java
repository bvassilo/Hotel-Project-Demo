public class Room {
	private int roomCode;
	private int maxCapacity;
	private Reservation[] availability = new Reservation[31];
	private double pricePerPerson;
	//constructor
	public Room(int roomCode,int maxCapacity, double pricePerPerson){
		this.setRoomCode(roomCode);
		this.setMaxCapacity(maxCapacity);
		this.pricePerPerson = pricePerPerson;
		Reservation nr = new Reservation("",0,0,0);
		for (int i=1;i<=30;i++){//TODO SEE IF THIS WORS
			setAvailability(nr,i); 
		}
	}
	//Methods
	public boolean addReservation(Reservation j){
		for(int k = j.getArrival();k <= j.getDuration()+j.getArrival(); k++)
			if (this.getAvailability(k)==null && this.getMaxCapacity()<=j.getPerson()){
				this.setAvailability(j,k);
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
				if (this.getAvailability(i)==null){
					roomEarnings += 0;
				}
				else{
					roomEarnings += this.pricePerPerson*getAvailability(i).getPerson();
				}
			}
			System.out.println("This month up until now this room is going to pay up"+roomEarnings+"money");
			return roomEarnings;
		}
	public boolean cancel(int cancelCode){
			for(int i=1;i<31;i++){
				if(getAvailability(i).getReservationCode()==cancelCode){
					setAvailability(null,i);
					return true;
				}
			}
			return false;
		}
	public double completenessQuota(){
			double completenessQuota = 0;
			int completeness = 0;
			for (int i=1;i<31;i++){
				if (getAvailability(i) != null){
					completeness += 1;
				}
			}
			completenessQuota = (completeness/30)*100;
			System.out.println("The completeness quota of the room for the month is"+completenessQuota+"%");
			return completenessQuota ;
		}
	//getters setters
	public int getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}
	public Reservation getAvailability(int day) {
		return availability[day];
	}
	public Reservation[] getAvailabilityArray(){
		return availability;
	}
	public void setAvailability(Reservation availability,int day) {
		this.availability[day] = availability;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}