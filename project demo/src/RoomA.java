
public class RoomA extends Room {
	private double pricePerDay;
	//costructor
	public RoomA(int roomCode, int maxCapacity, double pricePerPerson,double pricePerDay) {
		super(roomCode, maxCapacity, pricePerPerson);
		this.pricePerDay = pricePerDay;
	}
	//methods
	public double pricing(){
		double roomEarnings = 0;
		for (int i=1;i<31;i++){
			if (this.getAvailability(i)==null){
				roomEarnings += 0;
			}
			else{
				roomEarnings += this.getPricePerDay()*getAvailability(i).getDuration();
			}
		}
		//System.out.println("This month up until now this room is going to pay up"+roomEarnings+"money");
		return roomEarnings;
		
	}
	//getters setters
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
}