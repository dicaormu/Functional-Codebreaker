package fr.com.strategy;


public interface CustomProcessor<T> {
    T nextLine();

    Boolean hasNext();


}
