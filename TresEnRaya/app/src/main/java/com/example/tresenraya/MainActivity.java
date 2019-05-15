package com.example.tresenraya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    List<Button> botones;
    TresEnRaya ter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ter = new TresEnRaya();
        ter.iniciar();
        botones = new LinkedList<>();
        for(int i = 1; i <= 9; i++) {
            int id = getResources().getIdentifier("button"+i,"id",getPackageName());
            botones.add((Button) findViewById(id));
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mueveJugador(v);
                }
            });
        }
        findViewById(R.id.reiniciar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciar();
            }
        });

    }
    public void reiniciar(){
        ter = new TresEnRaya();
        ter.iniciar();
        for (int i = 0; i < 9; i++) {
            botones.get(i).setText("");
            botones.get(i).setEnabled(true);
        }
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("");
    }
    public void mueveJugador(View v){
        if(ter.quedanMovimientos()&&!ter.ganaJugador1()&&!ter.ganaJugador2()){
            Button b = (Button)v;
            int pos = Integer.valueOf(b.getTag().toString());
            ter.mueveJugador1(pos);
            b.setText("X");
            b.setEnabled(false);
            if(ter.quedanMovimientos()&&!ter.ganaJugador1()&&!ter.ganaJugador2()){
                mueveMaquina();
            }
            else {
                muestraMensaje();

            }
        }else {
            muestraMensaje();
        }
    }
    public void muestraMensaje(){
        TextView tv = (TextView) findViewById(R.id.textView);
        if (ter.ganaJugador1()){
            tv.setText("Has ganado!!");
        }
        else if (ter.ganaJugador2()){
            tv.setText("Has perdido!!");
        }
        else if(!ter.quedanMovimientos()){
            tv.setText("Empate!!");
        }
        for (int i = 0; i < 9; i++) {
            botones.get(i).setEnabled(false);
        }
    }
    public void mueveMaquina(){
        int pos = ter.mueveOrdernador2();
        Button b = botones.get(pos-1);
        b.setEnabled(false);
        b.setText("O");
        if(!ter.quedanMovimientos()||ter.ganaJugador1()||ter.ganaJugador2()){
            muestraMensaje();
        }
    }
    public class TresEnRaya {
        private int[] tablero;//0: vacio; 1: jugador 1; 2: jugador 2
        public TresEnRaya(){
            tablero = new int[9];
        }
        public void mueveJugador1(int pos){//pos 1 a 9
            if(movimientoValido(pos)){
                tablero[pos-1]=1;
            }else {
                throw new InvalidParameterException("Movimiento no valido");
            }
        }
        public void mueveJugador2(int pos){//pos 1 a 9
            if(movimientoValido(pos)){
                tablero[pos-1]=2;
            }else {
                throw new InvalidParameterException("Movimiento no valido");
            }
        }
        public void mueveOrdernador1(){
            Random r = new Random();
            int pos = r.nextInt(9)+1;
            while (!movimientoValido(pos)){
                pos = r.nextInt(9)+1;
            }
            this.mueveJugador1(pos);
        }
        public int mueveOrdernador2(){
            Random r = new Random();
            int pos = r.nextInt(9)+1;
            while (!movimientoValido(pos)){
                pos = r.nextInt(9)+1;
            }
            this.mueveJugador2(pos);
            return pos;
        }
        public boolean movimientoValido(int pos){
            boolean valido;
            valido = pos >=1 && pos <=9;
            if (valido) {
                valido = tablero[pos-1]==0;
            }
            return valido;
        }
        public void iniciar(){
            tablero = new int[9];
        }
        public boolean quedanMovimientos(){
            boolean quedanM = false;
            int i = 0;
            while (!quedanM&&i<9){
                quedanM = tablero[i]==0;
                i++;
            }
            return quedanM;
        }
        public boolean ganaJugador1(){
            boolean ganaJ1 = false;
            ganaJ1 = tablero[0]==1&&tablero[0]==tablero[1]&&tablero[1]==tablero[2];
            ganaJ1 = ganaJ1 || tablero[3]==1&&tablero[3]==tablero[4]&&tablero[4]==tablero[5];
            ganaJ1 = ganaJ1 || tablero[6]==1&&tablero[6]==tablero[7]&&tablero[7]==tablero[8];
            ganaJ1 = ganaJ1 || tablero[0]==1&&tablero[0]==tablero[3]&&tablero[3]==tablero[6];
            ganaJ1 = ganaJ1 || tablero[1]==1&&tablero[1]==tablero[4]&&tablero[4]==tablero[7];
            ganaJ1 = ganaJ1 || tablero[2]==1&&tablero[2]==tablero[5]&&tablero[5]==tablero[8];
            ganaJ1 = ganaJ1 || tablero[0]==1&&tablero[0]==tablero[4]&&tablero[4]==tablero[8];
            ganaJ1 = ganaJ1 || tablero[6]==1&&tablero[6]==tablero[4]&&tablero[4]==tablero[2];
            return ganaJ1;
        }
        public boolean ganaJugador2(){
            boolean ganaJ2 = false;
            ganaJ2 = tablero[0]==2&&tablero[0]==tablero[1]&&tablero[1]==tablero[2];
            ganaJ2 = ganaJ2 || tablero[3]==2&&tablero[3]==tablero[4]&&tablero[4]==tablero[5];
            ganaJ2 = ganaJ2 || tablero[6]==2&&tablero[6]==tablero[7]&&tablero[7]==tablero[8];
            ganaJ2 = ganaJ2 || tablero[0]==2&&tablero[0]==tablero[3]&&tablero[3]==tablero[6];
            ganaJ2 = ganaJ2 || tablero[1]==2&&tablero[1]==tablero[4]&&tablero[4]==tablero[7];
            ganaJ2 = ganaJ2 || tablero[2]==2&&tablero[2]==tablero[5]&&tablero[5]==tablero[8];
            ganaJ2 = ganaJ2 || tablero[0]==2&&tablero[0]==tablero[4]&&tablero[4]==tablero[8];
            ganaJ2 = ganaJ2 || tablero[6]==2&&tablero[6]==tablero[4]&&tablero[4]==tablero[2];
            return ganaJ2;
        }
        public void dibujaTablero(){
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[i]==0){
                    System.out.print("   ");
                }
                else if (tablero[i]==1){
                    System.out.print(" X ");
                }
                else if(tablero[i]==2){
                    System.out.print(" O ");
                }
                if (!(i == 2||i==5||i==8)){
                    System.out.print("|");
                }
                if (i == 2||i==5){
                    System.out.println();
                    System.out.println("-----------");
                }
            }
            System.out.println();
        }
    }
    /*public void jugadorVsOrdenador(){
        Scanner sc = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        int turno = 0;
        while (tresEnRaya.quedanMovimientos()&&!tresEnRaya.ganaJugador1()&&!tresEnRaya.ganaJugador2()){
            tresEnRaya.dibujaTablero();
            if(turno == 0){
                System.out.print("¿Posicion?(1-9): ");
                int pos = sc.nextInt();
                while (!tresEnRaya.movimientoValido(pos)){
                    System.out.print("¿Posicion?(1-9): ");
                    pos = sc.nextInt();
                }
                try {
                    tresEnRaya.mueveJugador1(pos);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            else {
                try {
                    tresEnRaya.mueveOrdernador2();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            turno = (turno+1)%2;
        }
        tresEnRaya.dibujaTablero();
        if(tresEnRaya.ganaJugador1()){
            System.out.println("GANA JUGADOR 1!!");
        }
        else if(tresEnRaya.ganaJugador2()){
            System.out.println("GANA LA MAQUINA!!");
        }
        else {
            System.out.println("EMPATE!!");
        }
        tresEnRaya.iniciar();
    }*/
}
