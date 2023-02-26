package spring.training.Buoi_1;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private IOService ioService;

    public Test() {
    }

    public Test(IOService ioService) {
        this.ioService = ioService;
    }

    public IOService getIoService() {
        return ioService;
    }

    public void setIoService(IOService ioService) {
        this.ioService = ioService;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Pet tom = (Pet) context.getBean("Tom");
        Pet Jerry =(Pet) context.getBean("Jerry");

        Test test = (Test) context.getBean("Test");

        List<Pet> pets = new ArrayList<>();
        pets.add(tom);
        pets.add(Jerry);

        test.ioService.savePest(pets);

        List<Pet> getPetList = test.ioService.getPets();
        for (Pet pet : getPetList) {
            pet.makeNoise();
        }
    }
}
