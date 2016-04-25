import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
private static final int MIN_COUNT = 1;
private static final int MAX_COUNT = 5;
private TreeSet<Client> phoneBook;
private Scanner reader;

public PhoneBook(File phoneBook) {
	NameComparator comparator=new NameComparator();
	this.phoneBook=new TreeSet<Client>(comparator);
	makeNewPhoneBook(phoneBook);
}

public void makeNewPhoneBook(File phoneBook) {
	try {
		reader=new Scanner(phoneBook);
		 while (reader.hasNextLine()) {
			 String line=reader.nextLine();
			 String name=line.substring(0,line.lastIndexOf(" "));
			 String number=line.substring(line.lastIndexOf(" ")+1);
			 String regex1="/\\+359 [8[789]] [2-9]{1} [0-9]{6}/";
			 String regex2="/0 [8[789]] [2-9]{1} [0-9]{6}/";
			 String regex3="/00359 [8[789]] [2-9]{1} [0-9]{6}/";
			 if(number.matches(regex1)||number.matches(regex2)||number.matches(regex3)){
				 if(number.matches(regex2)){
					 number="+359"+number.substring(1, number.length());
				 }
				 if(number.matches(regex3)){
					 number="+359"+number.substring(5, number.length());
				 }
				 this.phoneBook.add(new Client(name, number));
			 }
		 }
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("File not found");
	}
	
}

public void addClient(Client client){
	synchronized (this.phoneBook) {
		this.phoneBook.add(client);
	}
}

public void removeClient(Client client){
	synchronized (this.phoneBook) {
		this.phoneBook.remove(client);
	}
}

public List<Client> takeNumbers(String name){
	List<Client> forReturn=new ArrayList<Client>();
	for(Client client:this.phoneBook){
		if(client.getName().equals(name)){
			client.setCalls();
			forReturn.add(client);
		}
	}
	return forReturn;
}

public void PrintInfo(){
	for(Client client:this.phoneBook){
		System.out.println(client.toString());
	}
}

public void FiveMostSearchedPhones(){
	CallsComparator comp=new CallsComparator();
	Set<Client> mostSearchedPeople=new TreeSet<Client>(comp);
	mostSearchedPeople.addAll(this.phoneBook);
	int count=MIN_COUNT;
	for(Client client:mostSearchedPeople){
		System.out.println(client.toString());
		if(count==MAX_COUNT){
			break;
		}
		count++;
	}
	
}

}
