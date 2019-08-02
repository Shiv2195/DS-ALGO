package com.Ch03.StackAndQueue;

import java.util.LinkedList;

//Solution 6
class Animal {
    private int order;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}


public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();

    private int order;

    void add(Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeAny() {

        if (dogs.size() == 0) {
            return dequeCat();
        } else if (cats.size() == 0) {
            return dequeDog();
        }

        Cat cat = cats.peek();
        Dog dog = dogs.peek();

        if (dog.isOlderThan(cat)) {
            return dequeDog();
        } else {
            return dequeCat();
        }
    }

    public Animal dequeDog() {
        return dogs.poll();
    }

    public Animal dequeCat() {
        return cats.poll();
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("BullDog");
        Dog d2 = new Dog("Pug");

        Cat c1 = new Cat("Rag Doll");
        Cat c2 = new Cat("Persian Cat");

        AnimalQueue animalQueue = new AnimalQueue();
        animalQueue.add(d1);
        animalQueue.add(c1);
        animalQueue.add(c2);
        animalQueue.add(d2);


        System.out.println(animalQueue.dequeAny().getName());

    }

}
