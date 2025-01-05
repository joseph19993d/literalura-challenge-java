package com.example.booksLiterature.services;

public interface IDataTransformer
{
    <T> T getData(String json, Class<T> clase);
}
