package java_sample.lesson13;

import java.util.Date;

public class JamaikaHall {
	
	public static void main(String[] args) {
		class InputOperator{
			public void greeting() {
				System.out.println("ようこそ！ジャマイカホールへ！");
			}
		}
		class Seat<User>{
			int number ;
			boolean isReserved;
			User reserveUser ;
			
			@Override
			public String toString() {
				String str = "number\t\t"+number;
				str += "\nisReserved\t\t" + isReserved;
				str += "\nreserveUser\t" + reserveUser;
				str += "\n---------------------------------------";
				return str;
			}
		}
		class User{
			String email;
			String name;
			Date reservedDate ;
			Date cancelDate;
			
			@Override
			public String toString() {
				String str = "\n\temail\t\t" + email;
				str += "\n\tname\t\t" + name;
				str += "\n\treservedDate\t\t" + reservedDate;
				str += "\n\tcancelDate\t\t" + cancelDate;
				return str;
			}
		}
		
		class Reserve{
			User user;
		}
		Seat[] seatArray = new Seat[30];
		
		for(int i = 0 ; i < 30 ;i++) {
			Seat seat = new Seat();
			seat.number = i + 1;
			if(i % 2 == 0) {
				User user =new User();
				seat.isReserved = true;
				seat.reserveUser = user;
			}
			seatArray[i] = seat;
			System.out.println(seat);
		}
		
		InputOperator io = new InputOperator();
		io.greeting();
	}

}
