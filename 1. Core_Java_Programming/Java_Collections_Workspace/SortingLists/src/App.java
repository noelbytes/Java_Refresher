import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person {
	private int id;
	private String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ID : " + id + "; Name : " + name;
	}
}

/* Class to sort the animals list in the order of their string length */
class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String string1, String string2) {
		// TODO Auto-generated method stub
		// The Comparator interface only has one method, i.e. compare
		// compare is going to be supplied with the objects in your list, two at a time

		int length1 = string1.length();
		int length2 = string2.length();

		// If string1 > string2, i.e. if the first string should sort later in the list
		// than the second one, it should return one
		if (length1 > length2) {
			return 1;
		} else if (length1 < length2) {
			// If string1 < string2, i.e. if string1 should sort earlier in the list
			// then, return -1
			return -1;
		}

		// If string1 == string2, return 0
		return 0;
	}

}

/* Class to sort strings in a list in the reverse order of the alphabet */
class AlphabeticalOrderComparator implements Comparator<String> {

	@Override
	public int compare(String string1, String string2) {
		// To sort alphabetically, use the compareTo method defined under the
		// Comparable interface

		// How it works?
		// return 1 -> if string1 > string2, in other words, if it sorts alphabetically
		// later than string2

		// return -1 -> if string1 < string2, in other words, if it sorts alphabetically
		// earlier than string2
		return string1.compareTo(string2);
		
		// return 0 -> if the strings are equal
	}

}

class ReverseAlphabeticalOrderComparator implements Comparator<String> {
	
	@Override
	public int compare(String string1, String string2) {
		// To sort in the reverse order, add a - symbol infront of the existing return statement
		return -string1.compareTo(string2);
	}
	
}

public class App {
	public static void main(String[] args) {
		
		// ---------------------------------Sorting strings---------------------------------------
		List<String> animals = new ArrayList<String>();

		animals.add("tiger");
		animals.add("elephant");
		animals.add("cat");
		animals.add("lion");
		animals.add("snake");
		animals.add("mongoose");

		// Collections.sort(animals); // sorts the list in alphabetical order
		// Collections.sort(animals, new StringLengthComparator());
		// Collections.sort(animals, new AlphabeticalOrderComparator());
		
		Collections.sort(animals, new ReverseAlphabeticalOrderComparator());;
		
		for (String animal : animals) {
			System.out.println(animal);
		}

		// ---------------------------------Sorting integers---------------------------------------
		// Sorting a list of integers / doubles
		List<Integer> numbers = new ArrayList<Integer>();

		numbers.add(3);
		numbers.add(36);
		numbers.add(73);
		numbers.add(40);
		numbers.add(1);

		// Collections.sort(numbers); // Sorts in numerical order
		// Using an anonymous class instead of defining an external class that implements Comparator
		Collections.sort(numbers, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer number1, Integer number2) {
				// Sorting using reverse numerical order
				return -number1.compareTo(number2);
			}
			
		});
		
		for (Integer number : numbers) {
			System.out.println(number);
		}

		// NOTE: The order in which the collections class sorts is called the natural
		// order
		// If you want to sort other than using the natural order, you will have to
		// create a class
		// that implements the comparator interface
		// To use a Comparator, supply an instance of it to the Collections.sort method
	
		// ---------------------------------Sorting arbitrary objects ---------------------------------------
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person(1, "Joe"));
		people.add(new Person(3, "Bob"));
		people.add(new Person(4, "Clare"));
		people.add(new Person(2, "Sue"));
		
		// Collections.sort(people); // Throws an error, since the person object doesn't possess a natural order, and it doesn't implement the Comparable interface
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person person1, Person person2) {
				// Sort in the order of id
				if (person1.getId() > person2.getId()) {
					return 1;
				} else if (person1.getId() < person2.getId()) {
					return -1;
				}
				
				return 0;
			}
		});
		
		System.out.println("----------------------------------------------");
		System.out.println("Sort in the order of ID : ");
		System.out.println("----------------------------------------------");
		for (Person person : people) {
			System.out.println(person);
		}
		
		
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person person1, Person person2) {
				// Sort in the order of name
				return person1.getName().compareTo(person2.getName());
			}
		});
		
		System.out.println("----------------------------------------------");
		System.out.println("Sort in the order of name : ");
		System.out.println("----------------------------------------------");
		for (Person person : people) {
			System.out.println(person);
		}
	}
}
