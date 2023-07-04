package list;

public class Human implements Comparable<Human> {
	// Lista Proprietà
	String name;
	String surname;
	int age;
	int id;

	// Lista Costruttori
	public Human(String name, String surname, int age, int id) {
		this.name = name;
		this.surname = surname;
		this.setAge(age);
		this.setId(id);

	}

	public Human(String name) {
		this.name = name;
	}

	// Lista Metodi
	void sayHello() {
		System.out.println("Ciao sono " + this.name + " " + this.surname + ". Ho " + this.age + " anni");
	}

	// attributi e metodi static -> possiamo accedere a metodi e attributi static
	// senza creare un oggetto.

	static void staticMethod() {
		System.out.println("Ciao sono un metodo statico");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Sovrascrivere metodi nativi

	@Override
	public boolean equals(Object obj) {

		Human s = (Human) obj;
		if (this.name == s.name && this.surname == s.surname) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", surname=" + surname + "]";
	}

	// implementare Comparable nella classe
	@Override
	public int compareTo(Human s) {

		return s.getAge() - this.age;
	}

}
