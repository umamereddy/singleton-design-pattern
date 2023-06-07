package immutable;

import java.util.HashMap;
import java.util.Map;

public class DriverClass {

    public static void main(String[] args) {
        // Creating Map object with reference to HashMap
        Map<String, String> map = new HashMap<>();


        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");

        CustomImmutable s = new CustomImmutable("ABC", 101, map);

        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetaData());

        // Uncommenting below line causes error
        // s.regNo = 102;

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getMetaData());
        s.getMetaData().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getMetaData());
    }


}
