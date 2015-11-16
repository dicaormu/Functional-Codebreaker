package fr.com.strategy;


public interface CustomProcessor<T> {

    String FINALIZER = "";
    String EXACT_MATCH="+";
    String MATCH="-";


    T nextLine();

    Boolean hasNext();


}
