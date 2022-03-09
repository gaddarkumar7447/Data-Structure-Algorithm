package code.missiongoogle;

import java.util.HashMap;

public class Hash_table {
    static  void createHashMap(int [] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer integer = hashMap.get(arr[i]);
            if (hashMap.get(arr[i]) == null){
                hashMap.put(arr[i],1 );
            }
            else {
                hashMap.put(arr[i],++i);
            }
        }
        System.out.println(hashMap);
    }
    public static void main(String[] args) {
        int arr[] = new int[] {12,34,53,23,23,453,234};
        createHashMap(arr);
        HashMap<Integer,String> hash = new HashMap<>();
        hash.put(1,"Gaddar");
        hash.put(2,"Sumit");
        hash.put(3,"Ravi");
        hash.put(4,"RAja");
        hash.put(5,"Sanjeet");
        hash.put(6,"NItish");

        /*Hashtable<Integer,String> hash = new Hashtable<>();
        hash.put(1,"Gaddar");
        hash.put(2,"Sumit");
        hash.put(3,"Ravi");
        hash.put(4,"RAja");
        hash.put(5,"Sanjeet");
        hash.put(6,"NItish");*/

        /*Iterator<Integer> iterator = hash.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            String st = hash.get(key);
            System.out.println(""+key+"->"+st);
        }*/

//        TODO HAsh set doesn't store the duplicate value and key
//        TODO LInked hash set maintain the insertion order

        /*hash.put(10,"Saheb");

        System.out.println(hash);*/
        /*for (var entry: hash.entrySet()){
            System.out.println(entry.getKey()+""+entry.getValue());
        }*/

    }

}
