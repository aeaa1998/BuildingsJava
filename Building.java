import java.util.*;
import java.lang.*;
import java.text.*;

public class Building{
    Floor [] floors = new Floor[3];
    int id;
    int indexFloors;
    int index;
    int numberOfFloors;
    public Building(int id){
        this.id = id;
        this.index = id- 1;
        this.numberOfFloors = Helpers.intInput("Ingrese el numero de pisos tiene que ser mayor a 2", "Ingrese un numero mayor a 2", 2);
        int floorsNumber = numberOfFloors - 2;
        this.indexFloors = floorsNumber;
        this.floors = new Floor[floorsNumber];
        for (int i = 0; i< floorsNumber; i++){
            System.out.println("Piso numero " + (i + 2) + " ingrese la informacion");
            this.floors[i] = new Floor(id, i+2);
        }
    }
    public void showAllFloors(){
        for (int i = 0; i< this.indexFloors; i++){
            System.out.println("Piso numero " + (i + 2));
            this.floors[i].showAllWorkers();
            System.out.println("\n");
        }
    }
    public void getAverageOfCallsbyFloor(){
        for (int i = 0; i< this.indexFloors; i++){
            System.out.println("Piso numero " + (i + 2));
            this.floors[i].getAverageOfCalls();
            System.out.println("\n");
        }
    }
    public void getTotalCallsByFloor(){
        for (int i = 0; i< this.indexFloors; i++){
            System.out.println("Piso numero " + (i + 2));
            this.floors[i].getTotalCalls();
            System.out.println("\n");
        }
    }
    public void getAverage(){
        for (int i = 0; i< this.indexFloors; i++){
            System.out.println("Piso numero " + (i + 2));
            this.floors[i].getAverageTimePerCall();
            System.out.println("\n");
        }
    }
    public void assignRandomFloor(){
        Random rand = new Random();
        int index = rand.nextInt(this.indexFloors);
        this.floors[index].assignRandomWorker();
    }
}
