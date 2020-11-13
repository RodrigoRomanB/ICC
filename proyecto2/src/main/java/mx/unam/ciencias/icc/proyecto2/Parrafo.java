package mx.unam.ciencias.icc.proyecto2;

import java.text.Collator;

public class Parrafo implements Comparable<Parrafo>{

  String parrafo;
  /**
  * Constructor de la clase.
  * @param parrafo El parrafo
  */
  public Parrafo(String parrafo){
    this.parrafo = parrafo;
  }
  @Override public String toString(){
    return parrafo;
  }
  /**
  * Criterio de comparacion entre dos parrafo.
  * @param parrafo El nombre del archivo en el cual se guardará.
  */
  @Override public int compareTo(Parrafo p){
      Collator collator = Collator.getInstance();
      collator.setStrength(Collator.PRIMARY);
      return collator.compare(parrafo.replaceAll("\\P{L}+",""), p.toString().replaceAll("\\P{L}+",""));
  }
}
