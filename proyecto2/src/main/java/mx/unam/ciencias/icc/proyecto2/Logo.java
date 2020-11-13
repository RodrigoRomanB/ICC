package mx.unam.ciencias.icc.proyecto2;
import mx.unam.ciencias.icc.proyecto2.Parrafo;  
import mx.unam.ciencias.icc.Lista;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

  public class Logo{
    String[] logo;

    /*
     * Constructor de la clase
     */
     public Logo(String[] logo){
       this logo = logo;
     }

     /*
      * Método inicio.
      * Este método verificara si se tiene que ejecutar el programa
      * con entrada estandar o si leerá uno o más archivos.
      */
     public void inicio() throws IOException{
       if logo.length == 0){
         entradaEstandar();
         return;
       }
       boolean logoReversa = false;
       boolean logoDestructiva = false;
       String indentifica = ".txt";
       String archivoDestructivo = null;
       Lista<Parrafo> lista = new Lista<>();
       for (int i = 0;i < logo.length;i++) {
         if  logo[i].contains(indentifica))
           ManejaArchivo.carga logo[i],lista);
           if logo[i].equals("-r"))
           logoReversa = true;
           if logo[i].equals("-o")){
             logoDestructiva = true;
             try {
               archivoDestructivo = logo[i+1];
               i = i+1;
             } catch (Exception e) {
               System.out.println("No se ingreso un archivo para guardar");
               logoDestructiva = false;
             }
           }
         }
         realizaOperaciones(lista, logoReversa, logoDestructiva, archivoDestructivo);
       }

       /*
        * Método realizaOperaciones.
        * Se mandará a llamar cuando se encuentre la logoReversa o la logoDestructiva.
        */
        public void realizaOperaciones(Lista<Parrafo> lista, boolean logoReversa,
                                       boolean logoDestructiva, String archivoDestructivo) throws IOException{
        if logoReversa && logoDestructiva){
          Lista<Parrafo> listaM = lista.mergeSort(lista).reversa();
          ManejaArchivo.imprimeConsola(listaM);
          ManejaArchivo.guarda(archivoDestructivo, listaM);
        }
        else if logoReversa){
          Lista<Parrafo> listaM = lista.mergeSort(lista).reversa();
          ManejaArchivo.imprimeConsola(listaM);
        }
        else if logoDestructiva){
          Lista<Parrafo> listaM = lista.mergeSort(lista);
          ManejaArchivo.guarda(archivoDestructivo, listaM);
        }
        else {
          ManejaArchivo.imprimeConsola(lista.mergeSort(lista));
        }
     }

     /**
      * Método entradaEstandar
      * Se mandará a llamar cuando se especifique en el inicio de la ejecución
      * del programa. Leera todo lo del usuario línea por línea y después
      * realizará la ordenación.
      */
      public void entradaEstandar() throws IOException{
        Lista<Parrafo> lista = new Lista<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader((System.in), "UTF-8"))){
          String linea = br.readLine();
          while (linea != null) {
            lista.agregaFinal(new Parrafo(linea));
            linea = br.readLine();
          }
        } catch (Exception e) {
          System.out.println("Error en la entrada estándar");
          System.exit(1);
        }
        System.out.println("");
        ManejaArchivo.imprimeConsola(lista.mergeSort(lista));
      }
  }
