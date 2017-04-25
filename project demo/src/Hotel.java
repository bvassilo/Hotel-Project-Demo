import java.util.*;
public class Hotel {
	private String HotelName ;
	private Room[] roomArray ;
	private LinkedList<Reservation> reservationArray = new LinkedList<Reservation>();
	//constructor
	//TODO change constructor
	public Hotel (String HotelName,int i){		
		this.setHotelName(HotelName);
		roomArray = new Room[i];
		for (int j=0;j<=10;j++){
			roomArray[i]=new Room(100+i,2,40);
			roomArray[i+10]=new RoomA(200+i,4,40,30);
			roomArray[i+20]=new RoomB(300+i,6,40,30,10);
			roomArray[i+30]=new RoomC(400+i,5,40,2,4);
			roomArray[i+40]=new RoomD(500+i,5,40,8);
			roomArray[i+50]=new RoomE(600+i,3,40,5);
		}
	}
	//methods
	public void addRoom(Room i){
		for(int j=0;j<=roomArray.length;j++){
			if (roomArray[j]==null){
				roomArray[j]=i;
				break;
			}
		}
	}
	public Room returnRoomFromCode(int i){
		for(int j=0;j<=roomArray.length;j++){
			if (roomArray[j].getRoomCode()==i){
				return roomArray[j];
			}
		}
		return null;
	}
	public Reservation returnReservationFromCode(int i){
		for (int j=0;j<=reservationArray.size();j++){
			if (reservationArray.get(j).getReservationCode()==i){
				return reservationArray.get(j);
			}
		}
		
		return null;
	}
	public int addReservation(Reservation i){
		for(int j=0;j<=roomArray.length;j++){
			if (roomArray[j]==null){
				roomArray[j].addReservation(i);
				for(int k=0;k<=reservationArray.size();k++){
					if (reservationArray.get(k)==null){
						reservationArray.add(k,i);
						break;
					}
				}
				System.out.printf("The reservation has been made in room",roomArray[j].getRoomCode());
				return roomArray[j].getRoomCode();
			}
		}
		System.out.println("There is no room for your reservation");
		return 0;
	}
	public boolean addReservationToRoom(Reservation i,int j){
		Room k=this.returnRoomFromCode(j);
		if (k.addReservation(i)==true){
			k.addReservation(i);
			for(int x=0;x<=reservationArray.size();x++){
				if (reservationArray.get(x)==null){
					reservationArray.add(x, i);
					break;
				}
			}
			System.out.println("The reservation has been made succesfully");
			return true;
		}
		System.out.println("There is no room for your reservation");
		return false;
	}
	public void cancelReservation(int i){
		if(returnReservationFromCode(i).getHotelRoom().cancel(i)==true){
			returnReservationFromCode(i).getHotelRoom().cancel(i);
			reservationArray.remove(returnReservationFromCode(i));
		}
	}
	public double calculateIncome(int i){
		if (returnRoomFromCode(i)!=null){
		Room k = returnRoomFromCode(i);
		return k.pricing();
		}
		else{
		return 0;
		}
	}
	public double calculateIncome(){
		double totalIncome=0;
		for (int i=0;i<=roomArray.length;i++){
			totalIncome+=roomArray[i].pricing();
		}
		return totalIncome;
	}
	public void reservatioPlan(){
		char x;
		System.out.println("Room /t/t 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30");
		for (int i=0;i<=roomArray.length;i++){
			for (int j=0;j<=roomArray[i].getAvailability().length;j++){
				if (roomArray[i].getAvailability()[j]!=null){
					x = '*';
					if (j==30){
						System.out.println(x);
					}
					System.out.print(x);
				}
				else{
					x = '_';
					if(j==30){
						System.out.println(x);
					}
					System.out.print(x);
				}
			}
		}
	}
	//getters setters
   	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	public LinkedList<Reservation> getReservationArray() {
		return reservationArray;
	}
	public void setReservationArray(LinkedList<Reservation> reservationArray) {
		this.reservationArray = reservationArray;
	}
	public Room[] getRoomArray() {
		return roomArray;
	}
	public void setRoomArray(Room[] roomArray) {
		this.roomArray = roomArray;
	}
}