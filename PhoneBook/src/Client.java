

public class Client{
private String name;
private String phoneNumber;
private int calls=0;

public Client(String name,String number){
	setName(name);
	setPhoneNumber(number);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneBumber) {
	this.phoneNumber = phoneBumber;
}

public int getCalls() {
	return calls;
}

public void setCalls() {
	this.calls++;
}

@Override
public String toString() {
	return "Client [name=" + name + ", phoneNumber=" + phoneNumber + "]";
}




}
