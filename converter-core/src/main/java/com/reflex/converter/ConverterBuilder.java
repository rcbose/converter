package com.reflex.converter;

/**
 * Created by rcbose on 2/7/2015.
 */
public interface ConverterBuilder<F, T> {
    Converter<F,T> build();
}
