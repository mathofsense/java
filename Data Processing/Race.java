public class Race {
  public static void main(String[] args) {
    Thread rabbit = new Thread(new Animal("Rabbit", (int) (Math.random () * 500)));
    Thread turtle = new Thread(new Animal("Turtle", (int) (Math.random () * 500)));

    System.out.println("Race starts!");
    rabbit.start();
    turtle.start();
  }
}

class Animal implements Runnable {
  private String name;
  private int delay;

  public Animal(String name, int delay) {
    this.name = name;
    this.delay = delay;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      System.out.println(name + " ran " + i + " steps");
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        System.out.println(name + " was interrupted!");
      }
    }
    System.out.println(name + " finished the race!");
  }
}
