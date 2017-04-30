import java.util.*;
public class Hotel {
	private String HotelName ;
	private Room[] roomArray = new Room[200];
	private LinkedList<Reservation> reservationArray = new LinkedList<Reservation>();
	//constructor that creates an object type hotel 
	
	public Hotel (String HotelName){		
		this.setHotelName(HotelName); //takes HotelName and with the for loop it creates all kinds of rooms and gives them seperate characteristics.
		for (int j=1;j<=10;j++){
			roomArray[j]=new Room(100+j,2,40);
			roomArray[j+10]=new RoomA(200+j,4,40,30);
			roomArray[j+20]=new RoomB(300+j,6,40,30,10);
			roomArray[j+30]=new RoomC(400+j,5,40,2,4);
			roomArray[j+40]=new RoomD(500+j,5,40,8);
			roomArray[j+50]=new RoomE(600+j,3,40,5);
		}
	}
	//methods
	public void addRoom(Room i){
		for(int j=0;j<=roomArray.length;j++){
			if (roomArray[j]==null){
				roomArray[j]=i; 
				System.out.println("The room has been added succesfully"); //this method uses a for loop and scans the roomArray and when it finds the first null roomArray[j]  it saves it.
				break; //break ends the loop.
			}
		}
	}
	public Room returnRoomFromCode(int i){
		for(int j=1;j<=roomArray.length;j++){
			if (roomArray[j].getRoomCode()==i){
				return roomArray[j]; //this method takes an integer argument,scans the roomArray and when it finds the room with the argument it gives back the room.
			}
		}
		return null;
	}
	public Reservation returnReservationFromCode(int i){
		for (int j=0;j<=reservationArray.size();j++){
			Reservation nr = reservationArray.get(j);
			if (nr.getReservationCode()==i){
				return nr; //this method takes an integer argument, scans the reservationArray and  when it finds the reservation with the argument it gives back the reservation.
			}
		}
		
		return null;
	}
	public int addReservation(Reservation i){ //this method takes an argument type Reservation.
		int x = i.getPerson(); //then  it saves in a variable x the number of persons in the reservation.
		int initial;
		int end;
		int j=0;
		switch (x){ //the switch calculates in which room type the reservation will be placed.
		case 1:
			initial = 1;
			end = 10;
			break;
		case 2:
			initial = 1;
			end = 10;
			break;
		case 3:
			initial = 51;
			end = 60;
			break;
		case 4:
			initial = 11;
			end = 20;
			break;
		case 5:
			initial = 31;
			end = 50;
			break;
		case 6:
			initial = 21;
			end = 30;
			break;
		default:
			System.out.println("I can not have that many people in a room"); 
			return 0;			
		}
		Reservation nr = new Reservation("",0,0,0);
		for(j = initial;j<=end;j++){ //using a for loop we scan roomArray and if it finds a reservation same as nr then it places the reservation to the roomArray and to the reservationArray and it finally prints the appropriate message and returns the code of the room in which we placed the reservation. In any other case it returns 0.
	if (roomArray[j].getAvailability(i.getArrival())!=nr){
					roomArray[j].addReservation(i);
					reservationArray.add(i);
							
					System.out.println("The reservation has been made in room "+roomArray[j].getRoomCode()+" with code "+i.getReservationCode()+"\n");
					return roomArray[j].getRoomCode();
				}
			
		}
		System.out.println("There is no room for your reservation or the room is not available \n");
		return 0;
	}
	public boolean addReservationToRoom(Reservation i,int j){ 
		Room k=this.returnRoomFromCode(j);
		if (k.addReservation(i)==true){
			k.addReservation(i);
			reservationArray.add(i);
			System.out.println("The reservation has been made succesfully in room with code "+k.getRoomCode()+" as asked and has Reservation code "+i.getReservationCode()+"\n");
			return true; //this method takes two arguments; the first one is a Reservation and the second one is a roomCode. Then it saves in the variable k the room that we are going to place the reservation in and if the reservation can be put there then it saves the reservation in the reservationArray and prints the appropriate message. In any other case it returns false.
		}
			System.out.println("The room you asked for does not  match your inputs,try again with another room \n");
		return false;
	}
	public void cancelReservation(int i){
		if(returnReservationFromCode(i).getHotelRoom().cancel(i)==true){ //this method takes a roomCode argument. If the cancel method of room class returns true then the reservation is being calncelled and it deletes it from the reservationArray and it prints the appropriate message.
			returnReservationFromCode(i).getHotelRoom().cancel(i);
			reservationArray.remove(returnReservationFromCode(i));
			System.out.println("The reservation exists and has been cancelled");
		}
		else {
			System.out.println("There is no reservation with that code");
		}
	}
	public double calculateIncome(int i){ //this method finds  the room from the argument and it saves the room in the variable k and finally prints the appropriate message and prints the room income.
		if (returnRoomFromCode(i)!=null){
		Room k = returnRoomFromCode(i);
		return k.pricing();
		}
		else{
		return 0;
		}
	}
	public double calculateIncome(){
		double totalIncome=0; //this method returns the income of the whole hotel.
		for (int i=1;i<=roomArray.length;i++){
			totalIncome+=roomArray[i].pricing();
		}
		return totalIncome;
	}
	public void reservationPlan(){
		char x; //this method prints a room with its reservations.
		System.out.println("Room  01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30");
		for (int i=1;i<=roomArray.length;i++){
			for (int j=1;j<=roomArray[i].getAvailabilityArray().length;j++){
				if (roomArray[i].getAvailability(j)!=null){
					x = '*';
					if(j==1){
						System.out.print(+roomArray[i].getRoomCode()+" ");						
					}
					if (j==30){
						System.out.println("  "+x);
					}
					else{
						System.out.print("  "+x);
					}	
				}
				else{
					x = '_';
					if(j==1){
						System.out.println(+roomArray[i].getRoomCode());
					}
					if(j==30){
						System.out.println(x);
					}
					else{
						System.out.print(x);
					}
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