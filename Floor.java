import java.util.*;
import java.lang.*;
import java.text.*;
public class Floor{
    Worker [] workers = new Worker[1];
    String [] types = {"Alta importancia", "Media importancia", "Baja importancia"};
    int buildingId;
    int id;
    int index;
    int numberOfWorkers;
    public Floor(int buildingId, int id){
        this.buildingId = buildingId;
        this.id = id;
        this.index = id - 3;
        this.numberOfWorkers = 1;
        while (this.numberOfWorkers % 3 != 0){
            this.numberOfWorkers = Helpers.intInput("Ingrese el numero de trabajadores tiene que ser mayor a 0", "Ingrese un numero mayor a 0", 0);
            if (numberOfWorkers % 3 != 0){
                System.out.println("El numero de trabajadores tiene que ser divisible dentro de 3");
            }
        }
        workers = new Worker[numberOfWorkers];
            for (int i = 0; i< numberOfWorkers; i++){
                String type = types[(i%3)];
                this.workers[i] = new Worker(buildingId, id, (i + 1), type);
        }
    }

    public void showAllWorkers(){
            for (int i = 0; i< this.numberOfWorkers; i++){
                this.workers[i].getInfo();
            }
    }

    public void getAverageOfCalls(){
        int average = 0;
            for (int i = 0; i< this.numberOfWorkers; i++){
                average += this.workers[i].getNumberOfCalls();
            }
        System.out.println("El procentaje ha sido " + (double)(average/numberOfWorkers) + " llamadas por trabajador");
    }
    public void getTotalCalls(){
        int average = 0;
            for (int i = 0; i< this.numberOfWorkers; i++){
                average += this.workers[i].getNumberOfCalls();
            }
        System.out.println("El total de llamadas por piso ha sido " + (average));
    }
    public void getAverageTimePerCall(){
        double totalTime = 0;
        double totalCalls = 0;
            for (int i = 0; i< this.numberOfWorkers; i++){
                totalTime += workers[i].getTotalTime();
                totalCalls += workers[i].getNumberOfCalls();
            }
        System.out.println("El numero de llamadas ha sido " + (totalCalls));
        System.out.println("El total de horas ha sido " + (totalTime));
        System.out.println("El promedio de tiempo por llamada ha sido " + (totalTime/totalCalls));
    }
    public void assignRandomWorker(){
        Random rand = new Random();
        int index = rand.nextInt(this.numberOfWorkers);
        int time = Helpers.intInput("Ingrese el tiempo de la llamada en horas mayor a 0", "Ingrese un numero mayor a 0", 0);
        this.workers[index].assingCall(time);
    }

}
