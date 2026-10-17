package Exercises.Interface;

public class TestEdible {
  public static void main(String[] args) {
    Object[] objects = { new Tiger(), new Chicken(), new Apple() };
    for (Object object : objects) {
      if (object instanceof Edible) {
        System.out.println(((Edible) object).howToEat());
      }
    }
  }
}

class Animal {

}

class Chicken extends Animal implements Edible {
  @Override
  public String howToEat() {
    return "chicken: Fry it";
  }
}

class Tiger extends Animal {

}

abstract class Fruit implements Edible {
}

class Apple extends Fruit {
  @Override
  public String howToEat() {
    return "Apple: Make apple cider";
  }
}

class Orange extends Fruit {
  @Override
  public String howToEat() {
    return "Orange: Make it juice";
  }
}