package spring.training.Buoi_1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IOService {

    public IOService() {
    }

    public void savePest(List<Pet> pets) {
        File file = new File("/Users/macbook/IdeaProjects/springboot/src/main/java/spring/training/Buoi_1/pets.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Pet pet : pets) {
                fileWriter.write(pet.getName() + " " + pet.getType() + " " +pet.getAge());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pet> getPets() {
        List<Pet> pets = new ArrayList<>();
        File file = new File("/Users/macbook/IdeaProjects/springboot/src/main/java/spring/training/Buoi_1/pets.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] array = scanner.nextLine().split(" ");
                Pet pet = new Pet(array[0], array[1], Integer.parseInt(array[2]));
                pets.add(pet);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pets;
    }
}
