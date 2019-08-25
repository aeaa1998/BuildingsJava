import java.util.*;
import java.lang.*;
import java.text.*;
public class Worker{

    int numberOfCalls = 0;
    boolean busy = false;
    int totalTime;
    int time;
    int floorNumber;
    int floorIndex;
    int callsMade;
    int buildingNumber;
    int buildingIndex;
    int id;
    String type;

    public Worker(int buildingNumber, int floorNumber, int id, String type){
        this.floorNumber = floorNumber;
        this.buildingNumber = buildingNumber;
        this.buildingIndex = buildingNumber -1;
        this.floorNumber = floorNumber;
        this.floorIndex = floorNumber -1;
        this.id = id;
        this.type = type;
    }

    public void getInfo(){
        String text = (busy) ? "ocupado" : "libre";
        System.out.println("El trabajadro numero " + this.id + " del piso " + this.floorNumber + " del edifcio " + this.buildingNumber + "\n Y de relevancia " + this.type + " esta "+ text);
    }


    public int getTotalTime() {
        return totalTime;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void assingCall(int time){
        if (!this.busy){
            this.busy = !this.busy;
            this.time = time;
            this.numberOfCalls++;
            this.totalTime = time;
            System.out.println("El trabajadro numero " + this.id + " del piso " + this.floorNumber + " del edifcio " + this.buildingNumber + "\n Y de relevancia " + this.type + " se le asigno llamada");
        }else if(this.busy){
            Random rand = new Random();
            int n = rand.nextInt(this.time) + 1;
            if (n == this.time){
                this.time = time;
                this.numberOfCalls++;
                this.totalTime += time;
                System.out.println("El trabajadro numero " + this.id + " del piso " + this.floorNumber + " del edifcio " + this.buildingNumber + "\n Y de relevancia " + this.type + " se le asigno llamada luego de desocupar");

            }else{
                System.out.println("Sigue ocupado el trabajador");
            }
        }
    }
}
