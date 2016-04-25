import java.util.Comparator;

public class CallsComparator implements Comparator<Client> {

	@Override
	public int compare(Client o1, Client o2) {
		if(o1.getCalls()-o2.getCalls()==0){
			return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
		}
		else return o1.getCalls()-o2.getCalls();
	}

}
