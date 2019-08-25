import java.util.*;
import java.lang.*;
import java.text.*;

public class BuildingManager{
    Building [] buildings = new Building[1];
    int numberOfBuildings;
    String [] menu = {"Listado operadores", "Total de llamadas por piso", "Porcentaje de llamadas por piso", "Promedio de tiempo por llamada", "Generar llamada", "Salir"};
    public BuildingManager(){
        this.numberOfBuildings = Helpers.intInput("Ingrese el numero de edificios", "Ingrese un numero mayor a 0", 0);
//        this.numberOfFloors = Helpers.intInput("Ingrese el numero de pisos tiene que ser mayor a 2", "Ingrese un numero mayor a 2", 2);

        buildings = new Building[numberOfBuildings];
        for (int i = 0; i< numberOfBuildings; i++){
            System.out.println("Edificio numero " + (i + 1) + " ingrese la informacion");
            buildings[i] = new Building(i + 1);
        }
    }

    private void showAllBuildings(){
        for (int i = 0; i< this.numberOfBuildings; i++){
            System.out.println("Edificio numero " + (i + 1));
            this.buildings[i].showAllFloors();
            System.out.println("\n\n");
        }
    }

    private Building chooseBuilding(){
        int index = Helpers.intPositiveInput("Ingrese un numero de edifcio entre 1 y " + numberOfBuildings, "Ingrese un numero de edificio valido", numberOfBuildings);
        Building building = this.buildings[index-1];
        return building;
//        building.getAverageOfCallsbyFloor();
    }

    public void menu(){
        String menuC = "";
        while (!menuC.equalsIgnoreCase("Salir")){
            menuC = Helpers.selectOptions(this.menu, "Selecciona una de las siguientes opciones");
            if (menuC.equalsIgnoreCase("Listado operadores")){
                showAllBuildings();
            }else if (menuC.equalsIgnoreCase("Total de llamadas por piso")){
                Building choosen = chooseBuilding();
                choosen.getTotalCallsByFloor();
            }else if (menuC.equalsIgnoreCase("Porcentaje de llamadas por piso")){
                Building choosen = chooseBuilding();
                choosen.getAverageOfCallsbyFloor();
            }else if (menuC.equalsIgnoreCase("Promedio de tiempo por llamada")){
                Building choosen = chooseBuilding();
                choosen.getAverage();
            }else if (menuC.equalsIgnoreCase("Generar llamada")){
                Random rand = new Random();
                int index = rand.nextInt(this.numberOfBuildings);
                this.buildings[index].assignRandomFloor();
            }
        }
        System.out.println("Gracias por usar el programa");
    }
}