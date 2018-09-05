import java.util.LinkedList;

public class cache {

    public static void main(String[] args) {
        System.out.println( solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}) == 50);
        System.out.println( solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}) == 21);
        System.out.println( solution(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}) == 60);
        System.out.println( solution(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}) == 52);
        System.out.println( solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}) == 16);
        System.out.println( solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}) == 25);
    }

    /**
     * @param cachesize
     * @param cities
     * @return
     */
    private static int solution(int cachesize, String[] cities) {
        int runtime = 0;
        LinkedList<String> LRUcache = new LinkedList<String>(); //arrayList가 빠름

        for (String city: cities) {
            city = city.toUpperCase();
            if(LRUcache.contains(city)) {
                LRUcache.remove(city);
                runtime += 1;
            } else {
                if ( LRUcache.size() > cachesize )
                    LRUcache.remove(0);
                runtime += 5;
            }
            LRUcache.add(city);
        }
        
        return runtime;
    }


}