
public class RoomB extends RoomA{
	private double discountPerDay;
	//constructor
	public RoomB(int roomCode, int maxCapacity, double pricePerPerson,double pricePerDay,double discountPerDay) {
		super(roomCode, maxCapacity, pricePerPerson,pricePerDay);
		this.discountPerDay = discountPerDay;
	}
	//methods
	public double pricing(){
		double roomEarnings = 0;
		int count = 1;
		for (int i=1;i<31;i++){
			if (this.getAvailability(i)==null){
				roomEarnings += 0;
			}
			else{
				roomEarnings += (this.getPricePerDay()*getAvailability(i).getDuration()) - count * discountPerDay;
				if (this.getPricePerDay() >= (this.getPricePerDay()/2)){
					count++;
				}
			}
		}
		System.out.println("This month up until now this room is going to pay up"+roomEarnings+"money");
		return roomEarnings;
	}
	public boolean cancel(int cancelCode){
		return false;
	}
}