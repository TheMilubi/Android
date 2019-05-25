package com.example.conversormonedas;

import java.security.InvalidParameterException;

enum tipoMoneda{EURO, LIBRA, DOLAR, YEN, YUAN};

public class Moneda {
    private tipoMoneda tMoneda;
    private int decimales;
    private String simbolo;
    private double cambioEuro;
    public Moneda(tipoMoneda tMoneda, int decimales, String simbolo, double cambioEuro){
        if(decimales < 0 || decimales > 4 || simbolo.equals("") || cambioEuro <= 0 ){
            throw new InvalidParameterException();
        }else {
            this.tMoneda = tMoneda;
            this.decimales = decimales;
            this.simbolo = simbolo;
            this.cambioEuro = cambioEuro;
        }
    }

    public double getCambioEuro() {
        return cambioEuro;
    }

    public int getDecimales() {
        return decimales;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public tipoMoneda gettMoneda() {
        return tMoneda;
    }

    public void setCambioEuro(double cambioEuro) {
        if(cambioEuro <= 0){
            throw new InvalidParameterException();
        }
        else {
            this.cambioEuro = cambioEuro;
        }
    }
    
}
