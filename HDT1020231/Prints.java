import java.util.Scanner;

public class Prints {  
    Scanner scan;
    boolean control;
    public Prints(){
        scan = new Scanner(System.in);
    }
    public int menu1(){
        int OpcionValidada = 4;
        String Opcion = "";
        control = true;
        System.out.println("\n----------------------------\nQue desea hacer?\n----------------------------\n");
            System.out.println("1.Ruta mas corta");
            System.out.println("2.Centro de grafo");
            System.out.println("3.Modificar grafo");
            System.out.println("4.Salir\n");

        while(control == true){
            System.out.print(">>> ");
            Opcion = scan.next();
            OpcionValidada = Verificacion(Opcion);
            if(OpcionValidada != -1){
                control = false;
            } else {}
        } return OpcionValidada;
    }
    public int menu2(){
        int OpcionValidada = 3;
        String Opcion = "";
        control = true;
        System.out.println("\n----------------------------\nQue desea modificar?\n----------------------------\n");
            System.out.println("1.Transito");
            System.out.println("2.Distancia");
            System.out.println("3.Regresar\n");

        while(control == true){
            System.out.print(">>> ");
            Opcion = scan.next();
            OpcionValidada = Verificacion(Opcion);
            if(OpcionValidada != -1){
                control = false;
            } else {}
        } return OpcionValidada;
    }
    public int menu3(){
        int OpcionValidada = 2;
        String Opcion = "";
        control = true;
        System.out.println("\n----------------------------\nQue ruta quiere encontrar?\n----------------------------\n");
            System.out.println("1.Ingresar ciudades");
            System.out.println("2.Salir\n");

        while(control == true){
            System.out.print(">>> ");
            Opcion = scan.next();
            OpcionValidada = Verificacion(Opcion);
            if(OpcionValidada != -1){
                control = false;
            } else {}
        } return OpcionValidada;
    }
    public int Verificacion (String RNum) {
        int Num = -1;
        try {
            Num = Integer.parseInt(RNum);
        }catch (NumberFormatException e){
           System.out.println( "\n----------------------------\nOpcion invalida\n----------------------------\n" );
        }
        return Num;
      }

}