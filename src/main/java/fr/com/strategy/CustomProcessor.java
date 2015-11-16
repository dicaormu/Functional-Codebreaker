package fr.com.strategy;

@FunctionalInterface
public interface CustomProcessor<T> {

    public static final String FINALIZER ="";

    public T nextLine();


}
