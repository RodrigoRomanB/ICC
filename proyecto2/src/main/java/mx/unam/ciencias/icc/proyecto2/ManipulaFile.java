package mx.unam.ciencias.icc.proyecto2;
import mx.unam.ciencias.icc.lista;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

  public class ManipulaFile{
    private ManipulaFile(){}

      /**
       * Método guarda.
       * Guarda es un método que guardará todas las cadenas de la list en el archivo.
       * @param fileName es el nombre del archivo a guardar.
       * @param list será la list donde se sacarán todas las cadenas de texto.
       */
       public static <T> void guarda(String fileName, Lista<T> list) throws IOException {
         FileOutputStream fileOut = new FileOutputStream(fileName);
         OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
         BufferedWriter out = new BufferedWriter(osOut);
         for (T s : list) {
           out.write(s.toString() + "\n");
         }
         out.close();
       }

      /**
       * Método carga.
       * carga guardará las cadenas en una list específica.
       * @param fileName nombre del archivo dónde se leeran las cadenas.
       * @param list la list donde se guardará las cadenas de texto.
       */
       public static void carga(String fileName, Lista<Parrafo> list) throws IOException {
           FileInputStream fileIn = new FileInputStream(fileName);
           InputStreamReader isIn = new InputStreamReader(fileIn);
           BufferedReader in = new BufferedReader(isIn);
           String l = in.readLine();
           while(l != null){
             list.agregaFinal(new Parrafo(l));
             l = in.readLine();
           }
      }

      /**
      * Imprimirá todos los elementos de una list en consola.
      * @param list: la list que imprimirá.
      */
      public static <T> void imprimeConsola(Lista<T> list){
        for(T r : list){
          System.out.println(r.toString() + " ");
        }
      }

  }
