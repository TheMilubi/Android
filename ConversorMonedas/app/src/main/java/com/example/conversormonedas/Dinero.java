package com.example.conversormonedas;

import java.security.InvalidParameterException;
import java.util.*;

public class Dinero {
    private tipoMoneda tMoneda;
    private double cantidad;
    static private List<Moneda> listaMonedas;
    static {
        listaMonedas = new LinkedList<>();
        listaMonedas.add(new Moneda(tipoMoneda.EURO, 2, "€", 1));
        listaMonedas.add(new Moneda(tipoMoneda.DOLAR, 2, "$", 1.14));
        listaMonedas.add(new Moneda(tipoMoneda.YEN, 0, "¥", 126.58));
        listaMonedas.add(new Moneda(tipoMoneda.YUAN, 2, "¥", 7.6));
        listaMonedas.add(new Moneda(tipoMoneda.LIBRA, 2, "£", 0.86));
    }
    public static void actualizaCambio(tipoMoneda t, double cambioEuro){
        Moneda m = buscaMoneda(t);
        m.setCambioEuro(cambioEuro);
    }
    public static Moneda buscaMoneda(tipoMoneda t){
        Moneda m = null;
        int i = 0;
        while (i < listaMonedas.size() && m == null){
            if(listaMonedas.get(i).gettMoneda() == t){
                m = listaMonedas.get(i);
            }
            i++;
        }
        return m;
    }
    public Dinero(tipoMoneda tMoneda, double cantidad){
        this.tMoneda = tMoneda;
        this.cantidad = cantidad;
    }
    public Dinero(tipoMoneda tMoneda, int cantidad){
        this.tMoneda = tMoneda;
        this.cantidad = cantidad;
    }

    public tipoMoneda gettMoneda() {
        return tMoneda;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void settMoneda(tipoMoneda tMoneda) {
        this.tMoneda = tMoneda;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        String s = "%."+ buscaMoneda(tMoneda).getDecimales()+"f" + buscaMoneda(tMoneda).getSimbolo();
        return String.format(s,cantidad);
    }
    public double valorEn(tipoMoneda t){
        double valorEuros,valor;
        valorEuros = cantidad / buscaMoneda(tMoneda).getCambioEuro();
        valor = valorEuros * buscaMoneda(t).getCambioEuro();
        return valor;
    }
    public Dinero convierteEn(tipoMoneda t){
        double valorEuros,valor;
        valorEuros = cantidad / buscaMoneda(tMoneda).getCambioEuro();
        valor = valorEuros * buscaMoneda(t).getCambioEuro();
        return new Dinero(t,valor);
    }
    public String toString(tipoMoneda t){
        return convierteEn(t).toString();
    }
    public Dinero add(Dinero d){
        double valor = d.valorEn(tMoneda);
        double cantidad = this.cantidad + valor;
        return new Dinero(tMoneda,cantidad);
    }
    public Dinero substract(Dinero d){
        double valor = d.valorEn(tMoneda);
        double cantidad = this.cantidad - valor;
        return new Dinero(tMoneda,cantidad);
    }
    public Dinero multiply(double d){
        double cantidad = this.cantidad * d;
        return new Dinero(tMoneda,cantidad);
    }
    public Dinero divide(double d){
        double cantidad = 0;
        if (d == 0){
            throw new InvalidParameterException();
        }
        else {
            cantidad = this.cantidad / d;
        }
        return new Dinero(tMoneda,cantidad);
    }
    public Dinero negate(){
        return new Dinero(tMoneda,-cantidad);
    }

    public boolean equals(Dinero d) {
        double valor = d.valorEn(tMoneda);
        boolean igual = this.cantidad == valor;
        return igual;
    }

    public int compareTo(Dinero d){
        int igual;
        double valor = d.valorEn(tMoneda);
        if(this.cantidad == valor) {
            igual = 0;
        }
        else if (this.cantidad>valor){
            igual = 1;
        }
        else {
            igual = -1;
        }
        return igual;
    }
}
