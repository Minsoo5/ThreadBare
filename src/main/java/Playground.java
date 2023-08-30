import java.util.*;

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

        //HashMaps != Thread Safe
        //Even if one thread blows up, the rest can still go through about their day....
        //createAndStartThreadsInHashMap(5, 1000);

        //ArrayList vs Vector

        List<Integer> arrayList = new ArrayList<>();

        long arrayStart = System.currentTimeMillis();
        for (int i = 1; i <= 1_000_000; i++) {
            arrayList.add(i);
        }
        long arrayEnd = System.currentTimeMillis();
        System.out.println("Time for Array List to add " + arrayList.size() + " elements: " + (arrayEnd - arrayStart));



        List<Integer> vectorList = new Vector<>();

        long vecStart = System.currentTimeMillis();
        for (int i = 1; i <= 1_000_000; i++) {
            vectorList.add(i);
        }
        long vecEnd = System.currentTimeMillis();
        System.out.println("Time for Vector to add " + vectorList.size() + " elements: " + (vecEnd - vecStart));




    }

}
