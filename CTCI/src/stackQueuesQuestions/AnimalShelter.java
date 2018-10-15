package stackQueuesQuestions;

import java.util.LinkedList;

public class AnimalShelter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cats("Callie"));
		animals.enqueue(new Cats("Kiki"));
		animals.enqueue(new Dogs("Fido"));
		animals.enqueue(new Dogs("Dora"));
		animals.enqueue(new Cats("Kari"));
		animals.enqueue(new Dogs("Dexter"));
		animals.enqueue(new Dogs("Dobo"));
		animals.enqueue(new Cats("Copa"));
		
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dogs("Dapa"));
		animals.enqueue(new Cats("Kilo"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}

	}
	
	

}

abstract class Animal
{
	private int order;
	protected String name;
	public Animal(String n)
	{
		name=n;
	}
	public void setOrder(int ord)
	{
		order=ord;
	}
	
	public abstract String name();
	public int getOrder()
	{
		return order;
	}
	
	//Compare orders of animals to return the older item
	public boolean isOlderThan(Animal a)
	{
		return this.order<a.getOrder();
	}
}

class AnimalQueue
{
	LinkedList<Dogs> dogs=new LinkedList<Dogs>();
	LinkedList<Cats> cats=new LinkedList<Cats>();
	
	private int order=0; // acts as time stamp
	
	public void enqueue(Animal a)
	{
		//order is used as a times tamp, so we can compare insertion order of dog to a cat
		a.setOrder(order);
		order++;
		
		if(a instanceof Dogs)
		{
			dogs.addLast((Dogs)a);
		}
		
		if(a instanceof Cats)
		{
			cats.addLast((Cats)a);
		}
	}
	
	public int size() {
		return dogs.size() + cats.size();
	}
	
	public Animal dequeueAny()
	{
		//Looks at tops of dogs and cats queues, and pop the queue with the oldest value
		if(dogs.size()==0)
		{
			return dequeueCats();
		}
		else if(cats.size()==0)
		{
			return dequeueDogs();
		}
		
		Dogs dog=dogs.peek();
		Cats cat=cats.peek();
		
		if(dog.isOlderThan(cat))
		{
			return dequeueDogs();
		}
		else {
			return dequeueCats();
		}
	}
	public Dogs dequeueDogs()
	{
		return dogs.poll();
	}
	
	public Cats dequeueCats()
	{
		return cats.poll();
	}
}

class Dogs extends Animal
{
	public Dogs(String n)
	{
		super(n);
	}
	public String name() {
		return "Dog: " + name;
	}
}

class Cats extends Animal
{
	public Cats(String n)
	{
		super(n);
	}
	public String name() {
		return "Cat: " + name;
	}
}