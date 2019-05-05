package br.edu.ifma.dcomp.lpweb.bookstore.utils;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectAtributes {

    public static String[] getNullAttributesOf(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);

        return Stream
                .of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> 
                        wrappedSource.getPropertyValue(propertyName) == null 
                                || propertyName.equals("id"))
                .toArray(String[]::new);
    }

}
