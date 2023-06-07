package immutable;

import java.util.HashMap;
import java.util.Map;

public final class CustomImmutable {
    //1. The class must be declared as final so that child classes can’t be created.
    //2. Data members in the class must be declared private so that direct access is not allowed.
    //3. Data members in the class must be declared as final so that we can’t change the value of it after object creation.
    //4. A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
    //5. Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)

    /*NOTE: Please note that there is no setter method here.
            Also, note that we don’t need to perform deep copy
            or cloning of data members of wrapper types as they are already immutable.*/

    private final String name;
    private final int regNo;
    private final Map<String, String> metaData;


    public CustomImmutable(String name, int regNo, Map<String, String> metaData) {
        this.name = name;
        this.regNo = regNo;

        // Creating Map object with reference to HashMap
        // Declaring object of string type
        Map<String, String > tempMap = new HashMap<>();

        for(Map.Entry<String, String> entry: metaData.entrySet()){
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metaData = tempMap;

    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public Map<String, String> getMetaData() {
        Map<String, String > tempMap = new HashMap<>();

        for(Map.Entry<String, String> entry: metaData.entrySet()){
            tempMap.put(entry.getKey(), entry.getValue());
        }
         return tempMap;
    }

    @Override
    public String toString() {
        return "CustomImmutable{" +
                "name='" + name + '\'' +
                ", regNo=" + regNo +
                ", metaData=" + metaData +
                '}';
    }
}
