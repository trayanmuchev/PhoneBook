import java.util.Comparator;

public class NameComparator implements Comparator<Client>{

	@Override
	public int compare(Client o1, Client o2) {
		if(o1.getName().compareTo(o2.getName())==0){
			return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
		}
		return o1.getName().compareTo(o2.getName());
	}

}
