package com.ArthurSilva.investAPI.InvestAPI.ExeptionHandler.Exeptions;

public class ResourceNotFoundExeption extends RuntimeException
{
    public ResourceNotFoundExeption(String message)
    {
        super(message);
    }
}
