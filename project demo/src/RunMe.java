import java.util.*;
//import java.io.*;
public class RunMe {
	public static void main(String [] args){
		Scanner scann = new Scanner(System.in);
		String[] names = {"Nikos Soultanhs","Anna Kyrtsia","Dhmhtra Lurou","Vasileios Vasilopoulos","Kostas Roustas","Nikos Sxizas","Andrianos Lougia","Vaios Laskarelias","Thodoris Ntakouris","John Kranioths","Maria Georgakopoulou","Giorgos Kakkoushs","Nikos Kapentzonhs","Konstantina Katsigiannh","Vasilhs Katsampas","Polukarpos Pelekhs","Angelos Staikos","Xristos Siamas","Konstantinos Kotronhs","Giannhs Giannopoulos","Panos Haros","Panos Kakkoushs","Pegy Founda","Sofia Rammou","Georgia Vasilopoulou","Marios Tsiligiannhs","Antonhs Sakellarhs","Peny Harou","Afrodith Poluxronh","Vasoula Floropoulou","Nikos Kaklamanakhs"};
		int count = 0;
		System.out.println("Give hotel name");
		Hotel ourHotel = new Hotel(scann.next());
		int command =100;
		Random rand = new Random();
		while (command != 0 && count <= 30){
			Reservation k = new Reservation(names[count],rand.nextInt(30)+1,rand.nextInt(30)+1,rand.nextInt(6)+1);
			ourHotel.addReservation(k);
			int randnumb = rand.nextInt(4)+1;
			if (randnumb == 4){
				ourHotel.getReservationArray().removeLast();
			}	
			
			System.out.println("To continue programm type: 1\nTo add reservation type: 2\nTo cancel reservation type: 3\nTo show reservations type: 4\nTo show rooms type: 5\nTo show reservations plan type: 6\nTo show the icome of a room or the hotel's type: 7\nTo terminate the programm type: 8");
			command = scann.nextInt();
			
			switch(command){
			case 1/*"Next day"*/:
				count++;
				System.out.println("Contiued to day "+count);
				break;
			case 2/*"Add Reservation"*/:
				System.out.println("Please, give your name,arrival,duration,how many person and optionally the room code you want to be added in this order,\nif you don't want a specific room press 0,\nthe available room codes are \n101-110 type Room\n201-210 type RoomA\n301-310 type RoomB\n401-410 type RoomC\n501-510 type RoomD\n601-610 type RoomE");
				Reservation nR  = new Reservation(scann.next()+scann.next(),scann.nextInt(),scann.nextInt(),scann.nextInt());
				int rC = scann.nextInt();
				if(rC != 0){
					ourHotel.addReservationToRoom(nR,rC);
				}
				else{
					ourHotel.addReservation(nR);
				}
				break;
			case 3/*"Cancel Reservation"*/:
				System.out.println("Give the reservation code given to you with your Reservation");
				ourHotel.cancelReservation(scann.nextInt());
				break;
			case 4/*"Show Reservations"*/:
				System.out.println("Reservation Code | Client Name | Room Code");
				for(int counter=1;counter<=ourHotel.getReservationArray().size();counter++){
					System.out.println(+ourHotel.getReservationArray().get(counter).getReservationCode()+ " | "+ourHotel.getReservationArray().get(counter).getClientName()+ " | "+ourHotel.getReservationArray().get(counter).getHotelRoom().getRoomCode());
				}
				break;
			case 5/*"Show Rooms"*/:
				System.out.println("Room Code | Completness | Income");
				for(int counter=1;counter<=ourHotel.getRoomArray().length;counter++){
					System.out.println(+ourHotel.getRoomArray()[counter].getRoomCode()+" | "+ourHotel.getRoomArray()[counter].completenessQuota()+" | "+ourHotel.getRoomArray()[counter].pricing());
				}
				break;
			case 6/*"Show Reserrvations Plan"*/:
				ourHotel.reservationPlan();
				break;
			case 7/*"Show Income"*/:
				System.out.println("if you want the income for all the rooms press 0 else type the room code");
				int rC2 = scann.nextInt();
				if (rC2  == 0){
					ourHotel.calculateIncome();
				}
				else{
					ourHotel.calculateIncome(rC2);
				}
				
				break;
			case 8/*"Terminate"*/:
				command = 0;
				break;
			}
		}
	scann.close();
	System.out.println("End of month");
	}

}




