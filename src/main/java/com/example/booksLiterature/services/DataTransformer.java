package com.example.booksLiterature.services;

import com.example.booksLiterature.exeption.DataConversionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataTransformer implements IDataTransformer{
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public <T> T getData(String json, Class<T> clase) {

        if( json == null || json.isEmpty()  ){
            throw new IllegalArgumentException("json es nullo o vacio");
        } else if(clase == null ) {
            throw new IllegalArgumentException("Clase es nullo");
        }

        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonMappingException e) {
            throw new DataConversionException("Error de mapeo al convertir JSON a objeto", e);
        } catch (JsonProcessingException e) {
            throw new DataConversionException("Error de procesamiento de JSON", e);
        }

    }
}
