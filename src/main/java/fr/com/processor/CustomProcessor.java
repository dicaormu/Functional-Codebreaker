package fr.com.processor;


public interface CustomProcessor<T> {
    T nextLine();

    Boolean hasNext();
}
