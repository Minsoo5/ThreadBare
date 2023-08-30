import java.util.ArrayList;

public class Playground extends Thread {


    @Override
    public void run() {
        for (int i = 1; i <=10; i ++) {
            System.out.println(getName() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("An exception has occurred!");
            }

        }
    }







    public static void main(String[] args) {

        Playground threadOne = new Playground();
        Playground threadTwo = new Playground();
        Playground threadThree = new Playground();


/*
        //Array List Threads
        ArrayList<Playground> threadList = new ArrayList<>();
        threadList.add(threadOne);
        threadList.add(threadTwo);
        threadList.add(threadThree);

        for (int i = 0; i < threadList.size(); i++) {
            threadList.get(i).start();
        }
        */






    }

}
