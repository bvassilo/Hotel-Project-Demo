import java.util.*;
public class RunMe {
	Scanner scann=new Scanner(System.in);
	Hotel ourHotel=new Hotel("Zeus",60);
	//int count = 0;
	//String[] names={"Basilis Vasilopoulos,Nikos Soultanhs,Anna Agaph Kyrtsia,Maria Palamh,Kwstas Roustas,Manos Mpoursalhs,Dimitra Lurou,Andrianos Lougia,Manos Morris,Antonis Koutsaftikis"};
	
	//int[] randArrival= {1,3,3,7,14,5,15,19,20,30};
	
	//int[] randDuration= {2,3,1,2,3,4,1,2,3,4};
	
	//int[] randPerson= {2,3,2,1,3,4,5,4,3,4};
	
	while(scann){
		System.out.println("To make a reservation please give your name,when will you arrive,how long are you gonna stay with us and how mane people are gonna be with you");
		Reservation ourReservation = new Reservation(scann.next(),scann.nextInt(),scann.nextInt(),scann.nextInt());     //names[count],randArrival[count],randDuration[count],randPerson[count]);
		
		//count++;
	}
	
	
	
	
}


