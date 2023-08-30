import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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


    public static void createAndStartThreadsInHashMap(int numOfThreads, int milliDelay) {
        HashMap<String, Thread> threadHashMap = new HashMap<>();    //make the thread map

        for (int i = 1; i <= numOfThreads; i++) {            //make as many threads as the input
            threadHashMap.put("Thread " + i, new Playground());
        }

        Set<String> threadKeySet = threadHashMap.keySet();   // Grab all the keys

        for (String s : threadKeySet) {
            threadHashMap.get(s).start();
            try {
                Thread.sleep(milliDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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

        createAndStartThreadsInHashMap(5, 1000);



    }

}
