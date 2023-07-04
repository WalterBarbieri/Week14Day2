package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class AppList {

	public static void main(String[] args) {
		// Generics -> annotazione <>

		Random rnd = new Random();

		Human aldo = new Human("Aldo", "Baglio", 20, rnd.nextInt());
		Human giovanni = new Human("Giovanni", "Storti", 30, rnd.nextInt());
		Human giacomo = new Human("Giacomo", "Poretti", 40, rnd.nextInt());

		Human[] humanArray = { aldo, giovanni, giacomo };
		// Le List sono Collection -> LinkedList, ArrayList
		List<Human> lista = new ArrayList<>(Arrays.asList(humanArray)); // Upcasting

//		Human[] humanArray2 = (Human[]) lista.toArray(); 
//		System.out.println(humanArray2);

		System.out.println("La lista ha " + lista.size() + " elementi");

//		lista.add(giacomo);
//		lista.add(giovanni);
//		lista.add(aldo);
//		System.out.println("La lista ha " + lista.size() + " elementi");

		lista.add(0, new Human("Salta", "Lacorda", 15, rnd.nextInt()));

		for (Human human : lista) {
			System.out.println(human);
		}

		Human found = lista.get(0);
		System.out.println(found);

		lista.remove(giacomo);

		System.out.println("--------------Contains--------------");
		if (lista.contains(aldo)) {
			System.out.println("La lista contiene Aldo");
		} else {
			System.out.println("La lista non contiene Aldo");
		}

		System.out.println("--------------Remove--------------");
		for (Human human : lista) {
			System.out.println(human);
		}

		System.out.println("La lista è vuota? " + lista.isEmpty());

		System.out.println("--------------Clear--------------");

		lista.clear();

		System.out.println("La lista è vuota? " + lista.isEmpty());

		System.out.println("-------------LISTE E TIPI PRIMITIVI-----------------");

		List<Integer> interi = new ArrayList<>(); // Integer è la wrapper class degli interi -> ogni tipo primitivo ha
													// la sua wrapper class -> wrapper class è la rappresentazione come
													// oggetti del tipo primitivo

		interi.add(2);
		interi.add(8);
		interi.add(61);
		for (Integer numb : interi) {
			System.out.println(numb);
		}

		System.out.println("-----------Iterators------------------");
		ArrayList<String> lettere = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		for (String lettera : lettere) {
			if (lettera.equals("c")) {
				lettere.remove(lettera);
			}
			System.out.println(lettere);
		}
// Una modifica concorrente con la lettura della lista genera un errore, è necessario usare un iteratore	
//		
//		lettere.forEach(lettera -> {
//			if (lettera.equals("a")) {
//				lettere.remove(lettera);
//			}
//			System.out.println(lettere);
//		});
//		
//Tramite i metodi dell'iteratore possiamo applicare remove direttamente all'iteratore
		System.out.println("-----------metodo iteratore------------");
		Iterator<String> i = lettere.iterator();
		while (i.hasNext()) {
			String current = i.next();
			if (current.equals("b")) {

				i.remove();
			}
			System.out.println(lettere);
		}

		System.out.println("-------------SET-----------------");
		// i Set sono Collection -> HashSet, LinkedHashSet, TreeSet
		Set<Human> humanSet = new HashSet<>();
		// Set<Human> humanSet = new LinkedHashSet<>();
		// Set<Human> humanSet = new TreeSet<>();
		humanSet.add(aldo);
		humanSet.add(giovanni);
		humanSet.add(giacomo);
		humanSet.add(aldo); // nei set gli oggetti non vengono ripetuti
		humanSet.add(null); // non possibile nel treeSet
		// HashSet l'ordine è di lettura
		// LinkedHashSet l'ordine è in base all'inserimento
		// TreeSet
		for (Human human : humanSet) {
			System.out.println(human);
		}

		System.out.println("---------Maps--------------");
		// Le Maps non sono collection -> HashMap, LinkedHashMap, TreeMap
		Map<Integer, Human> humans = new HashMap<>();

		humans.put(aldo.getId(), aldo);
		humans.put(giovanni.getId(), giovanni);
		humans.put(giacomo.getId(), giacomo);
		System.out.println("-------Map con Set-------");
		Set<Integer> ids = humans.keySet();

		for (Integer id : ids) {

			System.out.println(humans.get(id));
		}
		System.out.println("-------Map con Collection-------");
		Collection<Human> humanValues = humans.values();

		for (Human human : humanValues) {
			System.out.println(human);
		}

		Set<Map.Entry<Integer, Human>> keyValue = humans.entrySet();
		Iterator it = keyValue.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
