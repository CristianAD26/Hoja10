/*  ALGORITMOS Y ESTRUCTURAS DE DATOS 
    CRISTIAN EDUARDO AGUIRRE DUARTE
    20231
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GrafoMain{
    public static void main(String[] args) throws FileNotFoundException{ 
        Scanner scan = new Scanner(System.in);
        String CiudadS;
        String CiudadD;
        String distancia;
        int Kilometros;
        Prints vista = new Prints();
        AlgoritmoDeFloyd grafo = new AlgoritmoDeFloyd();

        try{
            File Info= new File("guategrafo.txt");
            Scanner readFile= new Scanner(Info);

            while(readFile.hasNextLine()){
                String Lineas = readFile.nextLine();
                String[] DestinosW = Lineas.split(" ");  
                grafo.ADD(DestinosW[0], DestinosW[1], DestinosW[2]);
            }  
        }catch(Exception e){
            System.out.println("\n------------------\nOcurrio un error\n------------------\n");
        }

        System.out.println("\n----------------------------\n      Wazing Chapin\n----------------------------\n");
        grafo.Shorter_rute(); 
        boolean S1 = false;
        while (S1==false){
            int Menu = vista.menu1();
            if(Menu==1){
                boolean S3 = false;
                while(S3==false){
                    int Menu3 =vista.menu3(); 
                    if(Menu3==1){ 
                        System.out.println("Ciudad salidad >>> ");
                        CiudadS=scan.nextLine();

                        System.out.println("\nCiudad de destino >>> ");
                        CiudadD=scan.nextLine();
                        if (grafo.existe(CiudadS,CiudadD)){
                            System.out.println("Ciudades recorridas >>> ");
                            grafo.VerticesCercanos(CiudadS, CiudadD); 
                            Kilometros = grafo.DistanciaRecorrida(CiudadS, CiudadD); 
                            System.out.println( "Se recorrieron " + Kilometros + " kilometros");
                        }else{
                            System.out.println("\n------------------\nOcurrio un error\n------------------\n");
                        }
                    }if (Menu3==2){
                        S3 =true;
                    }
                }
            }if (Menu==2){
                System.out.println("Mostrando informacion del grafo.....");
                grafo.CentroDelGrafo();
            }if(Menu==3){
                boolean S2 = false;
                while(S2==false){
                    int Menu2 =vista.menu2(); 
                    if(Menu2==1){
                        System.out.println("Ingrese el nombre de la ciudad de salida");
                        CiudadS=scan.nextLine();

                        System.out.println("\nIngrese el nombre de la ciudad de destino");
                        CiudadD=scan.nextLine();
                        if (grafo.existe(CiudadS, CiudadD)){
                            grafo.ADD(CiudadS,CiudadD,"100");   
                            System.out.println("\n** El grafo se ha modificado con exito ** ");
                            System.out.println("\nLos datos modificados fueron los siguientes: ");
                            System.out.println("Ciudades Modificadas: " +"\n-"+ CiudadS + "\n-"+ CiudadD);
                        }else{
                            System.out.println("\n------------------\nOcurrio un error\n------------------\n");
                        }
                    }if(Menu2==2){
                        System.out.println("Ingrese el nombre de la ciudad de salida");
                        CiudadS=scan.nextLine(); 

                        System.out.println("\nIngrese el nombre de la ciudad de destino");
                        CiudadD=scan.nextLine();

                        System.out.println("\nIngrese la distancia entre las ciudades en km");
                        distancia=scan.nextLine();
                        if (grafo.existe(CiudadS, CiudadD)){
                            grafo.ADD(CiudadS,CiudadD,distancia); 
                            System.out.println("\nLos datos modificados fueron los siguientes: ");
                            System.out.println("Ciudades Modificadas: " +"\n-"+ CiudadS + "\n-"+ CiudadD );
                            System.out.println("La nueva distancia entre ciudades es de: "+distancia);
                        }else{
                            System.out.println("\n------------------\nOcurrio un error\n------------------\n");
                        }

                    }if (Menu2==3){
                        S2 =true;
                    }
                }
            }if (Menu==4){
                S1=true;
            }
        }
    }
}