
public class RoomE extends RoomA{
	
	//constructor
	public RoomE(int roomCode, int maxCapacity, double pricePerPerson,double pricePerDay) {
		super(roomCode, maxCapacity, pricePerPerson,pricePerDay);
	}
	//methods
	public double pricing(){
		double roomEarnings = 0;
		for (int i=1;i<31;i++){
			if (this.getAvailability()[i]==null){
				roomEarnings += 0;
			}
			else if (this.completenessQuota()<=50){
					roomEarnings += this.getPricePerDay()*getAvailability()[i].getDuration();
			}
			else{
					this.setPricePerDay(this.getPricePerDay()*2);
					roomEarnings += (this.getPricePerDay()*getAvailability()[i].getDuration()); //if completeness is more than 50% the price doubles
			}
		}
		System.out.printf("This month up until now this room is going to pay up",roomEarnings,"money");
		return roomEarnings;
		
	}
	public boolean cancel(int cancelCode){
		return false;
	}
}
