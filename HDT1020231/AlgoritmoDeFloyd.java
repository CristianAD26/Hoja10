import java.util.*;
import java.util.Vector;

public class AlgoritmoDeFloyd {
    
    private Vector<String> Ubicacion;
    private int[][] distancia;
    private int[][] ruta;
    private int Kilometros1;
    private int Kilometros2;
    
    public AlgoritmoDeFloyd(){
        Ubicacion= new  Vector<String>();
        distancia= new int [35][35];
        ruta= new int [35][35];
        
        for (int i =0; i<35; i++){
            for (int j =0; j<35; j++){
                ruta [i][j]=100;
                if (i==j){
                    distancia[i][j]=0;
                }else{
                    distancia [i][j]=100;
                }
            }
        }
    }
    
    public void ADD(String A1, String A2, String A3){
        
        if (!Ubicacion.contains(A1) || !Ubicacion.contains(A2)){
            Ubicacion.add(A1); 
            Ubicacion.add(A2); 
        }
        Kilometros1=Ubicacion.indexOf(A1);
        Kilometros2=Ubicacion.indexOf(A2);
        distancia[Kilometros1][Kilometros2]= Integer.parseInt(A3);
        if (A3=="100"){
            ruta[Kilometros1][Kilometros2]=100;
        }else{
            ruta[Kilometros1][Kilometros2]= Kilometros2;
        }
    }

    public boolean existe(String A1,String A2){
        boolean esta= false; 
        if(Ubicacion.contains(A1) && Ubicacion.contains(A2)){
            esta=true;
        }return esta;
    }

    public void Shorter_rute(){
        for (int i=0; i<Ubicacion.size();i++){
               for (int j = 0; j<Ubicacion.size(); j++){
                   for (int k = 0; k<Ubicacion.size(); k++){
                    if (distancia[j][i]==100 || distancia[i][k]==100)
                    continue; 
                    if (distancia[j][i] + distancia[i][k]<distancia[j][k]){
                        distancia[j][k]=distancia[j][i] + distancia[i][k];
                        ruta[j][k]= ruta [j][i];
                    }
                }
            }
        }
    }
    public void CentroDelGrafo(){
        int max=0;
        Vector<Integer> centro = new  Vector<Integer>();
        
        for (int i =0; i<Ubicacion.size();i++){
            for (int j =0; j<Ubicacion.size();j++){
                if( distancia[i][j]>0){
                    max = distancia[i][j];
                }
            }
        centro.add(max); 
        }
        int Temp = Collections.min(centro); 
        int Temp2= centro.indexOf(Temp); 
        String Temp3= Ubicacion.get(Temp2); 
        System.out.println("\nDistancia minima >>> "+ Temp );
        System.out.println("Centro >>>" + Temp3);
    }

    public void VerticesCercanos(String A1, String A2){
        int Val1= Ubicacion.indexOf(A1); 
        int Val2= Ubicacion.indexOf(A2); 
        Vista(Val1, Val2);
    }

    public int DistanciaRecorrida(String A1, String A2){
      
        int recorrio= distancia[Ubicacion.indexOf(A1)][Ubicacion.indexOf(A2)];
        return recorrio;
    }


    public void Vista(int V1, int V2){
        Vector<String> camino = new Vector<String>();
        camino.add("\n--"+Ubicacion.get(V1));
        
        if (distancia[V1][V2] == 100 || distancia[V1][V2] == 0){
            System.out.println("\n****No existe una conección entre ciudades****\n"); 
        }else{
            while (V1!= V2){
                V1 = ruta[V1][V2];
                camino.add(Ubicacion.get(V1));
            }
        }
        int SIZE = camino.size(); 
        for(int i = 0; i < SIZE - 1; i++)
        System.out.print(camino.get(i) + " \n - ");
        System.out.print(camino.get(SIZE - 1) + "\n");
    }
}
