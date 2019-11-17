
import java.io.Serializable;

import Exception.IllegalAge;
import Exception.IllegalGender;
import Exception.IllegalID;
import Exception.IllegalName; 

public class Author implements Serializable{
	protected String id;
	protected String firstName;
	protected String lastName;
	protected double age;
	protected String gender;

	public Author(String id, String firstName, String lastName, double age, String gender) throws IllegalID,IllegalName,
	IllegalAge,IllegalGender{
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
		setGender(gender);
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setId(String id) throws IllegalID {
		if(id.length() == 9 && CheckId(id.toCharArray()))
			this.id = id;
		else throw new IllegalID("Id Author invalid");
	}
	
	public boolean CheckId(char[] ID) {
		for (char c : ID){
			if(!Character.isAlphabetic(c))
				return true;
		}
		return false;
	}
	
	public void setFirstName(String firstName) throws IllegalName {
		if(firstName.length()>2 && CheckString(firstName.toCharArray()))
			this.firstName = firstName;
		else throw new IllegalName("Name Author invalid");
	}

	public void setLastName(String lastName) throws IllegalName{
		if(lastName.length()>2 && CheckString(lastName.toCharArray()))
			this.lastName = lastName;
		else throw new IllegalName("Name Author invalid");
	}
	public boolean CheckString(char[] name) {
		for (char c : name) {
			if(!Character.isDigit(c))
				return true;
		}
		return false;
	}

	public void setAge(Double age) throws IllegalAge {
		if(age > 0)
			this.age = age;
		else throw new IllegalAge("Age Author invalid");
	}
	
	public void setGender(String gender) throws IllegalGender {
		if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female"))
			this.gender = gender;
		else throw new IllegalGender("Gender Author invalid");
	}
	
	public boolean equals(Object other) {
		return(other instanceof Author) && getId().equals(((Author)other).getId());
	}
	
	public String toString() {
		return("The ID of Aouter is: "+getId()+"\nThe First Name: "+getFirstName()+
				"\nThe Last Name: "+getLastName()+"\nThe Age: "+getAge()+"\nThe Gender: "+getGender()+"\n");
	}
	

	
}
