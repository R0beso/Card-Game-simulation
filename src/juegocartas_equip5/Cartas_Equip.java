package juegocartas_equip5;


// Author: R0beso - Raymundo Obeso


import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Cartas_Equip {
    
    static int Turno = 1, NJuegos=0;
    static int ContJuegos =0,Ganador=0;
    static int[] Ganadas = new int [4], JGanadas = new int [4];
    static JFrameJuegoCartas J = new JFrameJuegoCartas();
    static boolean NoRepite[][]= new boolean [10][10];
    static DefaultPieDataset dataset = new DefaultPieDataset();
    static JFreeChart chart;
    static ChartPanel panel;
    static JFrame ventana;
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Número de Juegos: ");
        NJuegos = leer.nextInt();
        new Cartas_Equip();
    }
    
    public Cartas_Equip (){
        int velocidad=750;
        Timer timer;
        TimerTask tarea;
        J.setVisible(true);
        System.out.println("\n >> Juego: "+(ContJuegos+1));
        
        tarea = new TimerTask(){
            @Override
            public void run() {
                if(ContJuegos<NJuegos){
                    if(Turno<=10){
                        System.out.println("Mano "+Turno+" la ganó el jugador: "+((Ganador=MostrarCarta())+1));
                        Ganadas[Ganador]++;
                        Turno++;
                    }
                    else if(Turno<=11){
                        System.out.println("\nGanó el jugador:"+Ganadores());
                        Turno++;
                    }
                    else if(Turno<=13){
                        Turno++;
                    }
                    else{
                        if(ContJuegos<NJuegos){ 
                            Reiniciar();
                            if(ContJuegos==NJuegos){
                                Grafica();
                            }
                        }
                    }
                }else{
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velocidad,velocidad);
    }
    
    
    public int MostrarCarta(){
        Icon icono = new ImageIcon(getClass().getResource("/Imagenes/Hnull.png"));
        Icon icono2 = new ImageIcon(getClass().getResource("/Imagenes/Vnull.png"));
        
        switch (Turno){
            case 1:
                J.Lab1J1.setIcon(icono);
                J.Lab1J2.setIcon(icono2);
                J.Lab1J3.setIcon(icono);
                J.Lab1J4.setIcon(icono2);
                break;
            case 2:
                J.Lab2J1.setIcon(icono);
                J.Lab2J2.setIcon(icono2);
                J.Lab2J3.setIcon(icono);
                J.Lab2J4.setIcon(icono2);
                break;
            case 3:
                J.Lab3J1.setIcon(icono);
                J.Lab3J2.setIcon(icono2);
                J.Lab3J3.setIcon(icono);
                J.Lab3J4.setIcon(icono2);
                break;
            case 4:
                J.Lab4J1.setIcon(icono);
                J.Lab4J2.setIcon(icono2);
                J.Lab4J3.setIcon(icono);
                J.Lab4J4.setIcon(icono2);
                break;
            case 5:
                J.Lab5J1.setIcon(icono);
                J.Lab5J2.setIcon(icono2);
                J.Lab5J3.setIcon(icono);
                J.Lab5J4.setIcon(icono2);
                break;
            case 6:
                J.Lab6J1.setIcon(icono);
                J.Lab6J2.setIcon(icono2);
                J.Lab6J3.setIcon(icono);
                J.Lab6J4.setIcon(icono2);
                break;
            case 7:
                J.Lab7J1.setIcon(icono);
                J.Lab7J2.setIcon(icono2);
                J.Lab7J3.setIcon(icono);
                J.Lab7J4.setIcon(icono2);
                break;
            case 8:
                J.Lab8J1.setIcon(icono);
                J.Lab8J2.setIcon(icono2);
                J.Lab8J3.setIcon(icono);
                J.Lab8J4.setIcon(icono2);
                break;
            case 9:
                J.Lab9J1.setIcon(icono);
                J.Lab9J2.setIcon(icono2);
                J.Lab9J3.setIcon(icono);
                J.Lab9J4.setIcon(icono2);
                break;
            case 10:
                J.Lab10J1.setIcon(icono);
                J.Lab10J2.setIcon(icono2);
                J.Lab10J3.setIcon(icono);
                J.Lab10J4.setIcon(icono2);
                break;
                
        }
        return GenerarCartasCentro();
    }
    
    public int GenerarCartasCentro(){
        Icon icono[][]={
            {
            new ImageIcon(getClass().getResource("/Imagenes/M1.png")),new ImageIcon(getClass().getResource("/Imagenes/M2.png")),
            new ImageIcon(getClass().getResource("/Imagenes/M3.png")),new ImageIcon(getClass().getResource("/Imagenes/M4.png")),
            new ImageIcon(getClass().getResource("/Imagenes/M5.png")),new ImageIcon(getClass().getResource("/Imagenes/M6.png")),
            new ImageIcon(getClass().getResource("/Imagenes/M7.png")),new ImageIcon(getClass().getResource("/Imagenes/M8.png")),
            new ImageIcon(getClass().getResource("/Imagenes/M9.png")),new ImageIcon(getClass().getResource("/Imagenes/M10.png"))
            },
            {
            new ImageIcon(getClass().getResource("/Imagenes/C1.png")),new ImageIcon(getClass().getResource("/Imagenes/C2.png")),
            new ImageIcon(getClass().getResource("/Imagenes/C3.png")),new ImageIcon(getClass().getResource("/Imagenes/C4.png")),
            new ImageIcon(getClass().getResource("/Imagenes/C5.png")),new ImageIcon(getClass().getResource("/Imagenes/C6.png")),
            new ImageIcon(getClass().getResource("/Imagenes/C7.png")),new ImageIcon(getClass().getResource("/Imagenes/C8.png")),
            new ImageIcon(getClass().getResource("/Imagenes/C9.png")),new ImageIcon(getClass().getResource("/Imagenes/C10.png"))
            },
            {
            new ImageIcon(getClass().getResource("/Imagenes/E1.png")),new ImageIcon(getClass().getResource("/Imagenes/E2.png")),
            new ImageIcon(getClass().getResource("/Imagenes/E3.png")),new ImageIcon(getClass().getResource("/Imagenes/E4.png")),
            new ImageIcon(getClass().getResource("/Imagenes/E5.png")),new ImageIcon(getClass().getResource("/Imagenes/E6.png")),
            new ImageIcon(getClass().getResource("/Imagenes/E7.png")),new ImageIcon(getClass().getResource("/Imagenes/E8.png")),
            new ImageIcon(getClass().getResource("/Imagenes/E9.png")),new ImageIcon(getClass().getResource("/Imagenes/E10.png"))
            },
            {
            new ImageIcon(getClass().getResource("/Imagenes/B1.png")),new ImageIcon(getClass().getResource("/Imagenes/B2.png")),
            new ImageIcon(getClass().getResource("/Imagenes/B3.png")),new ImageIcon(getClass().getResource("/Imagenes/B4.png")),
            new ImageIcon(getClass().getResource("/Imagenes/B5.png")),new ImageIcon(getClass().getResource("/Imagenes/B6.png")),
            new ImageIcon(getClass().getResource("/Imagenes/B7.png")),new ImageIcon(getClass().getResource("/Imagenes/B8.png")),
            new ImageIcon(getClass().getResource("/Imagenes/B9.png")),new ImageIcon(getClass().getResource("/Imagenes/B10.png"))
            }
        };
        int CartasCentro[][]=new int[4][2];
        int a=0,b=0;
        for(int i=0;i<4;i++){
        do{
            a=Aleatorio1();
            b=Aleatorio2();
        }while(NoRepite[a][b]);
            switch (i){
                case 0:
                    J.LabCJ1.setIcon(icono[a][b]);
                    break;
                case 1:
                    J.LabCJ2.setIcon(icono[a][b]);
                    break;
                case 2:
                    J.LabCJ3.setIcon(icono[a][b]);
                    break;
                case 3:
                    J.LabCJ4.setIcon(icono[a][b]);
                    break;
            }
            CartasCentro[i][0]=a;
            CartasCentro[i][1]=b;
            NoRepite[a][b]=true;
        }
        return GanadorMano(CartasCentro);
    }
    
    
    public int GanadorMano(int[][] Pos){
        int Mayor=0,cont=0;
        int JugGanador=0,j=0;
        for(int i=0;i<4;i++)
            if(Pos[i][1]==0)
                Pos[i][1]=12;
        
        for(int i=0;i<4;i++){
            if(Pos[i][1]>Mayor){
                Mayor=Pos[i][1];
                JugGanador=i;
            }
        }
        
        for(int i=0;i<4;i++){
            if(Pos[i][1]==Mayor)
                cont++;
        }
        if (cont>1) return JugGanador;
        else{
            int PosibleGanador[]= new int[cont];
            for(int i=0;i<4;i++){
                if(Pos[i][1]==Mayor){
                    PosibleGanador[j]=i;
                    j++;
                }
            }
            Mayor=4;
            for(int i=0;i<PosibleGanador.length;i++){
                if(Pos[PosibleGanador[i]][0]<Mayor){
                    Mayor=Pos[PosibleGanador[i]][0];
                    JugGanador=PosibleGanador[i];
                }
            }
            return JugGanador;
        }
    }
    
    public int Aleatorio1(){
        double alea = new Random().nextDouble();
        if (alea <= 0.25) alea=0;
        else if (alea > 0.25 && alea <=0.5) alea=1;
        else if (alea > 0.5 && alea <=0.75) alea=2;
        else alea=3;
        return (int) alea;
    }
    
    public int Aleatorio2(){
        double alea = new Random().nextDouble();
        if (alea <= 0.1) alea=0;
        else if (alea > 0.1 && alea <=0.2) alea=1;
        else if (alea > 0.2 && alea <=0.3) alea=2;
        else if (alea > 0.3 && alea <=0.4) alea=3;
        else if (alea > 0.4 && alea <=0.5) alea=4;
        else if (alea > 0.5 && alea <=0.6) alea=5;
        else if (alea > 0.6 && alea <=0.7) alea=6;
        else if (alea > 0.7 && alea <=0.8) alea=7;
        else if (alea > 0.8 && alea <=0.9) alea=8;
        else alea=9;
        return (int) alea;
    }
    
    public void Reiniciar(){
        ContJuegos++;
        Turno=1;
        NoRepite=new boolean [10][10];
        
        Icon icono =new ImageIcon(getClass().getResource("/Imagenes/RH.png"));
        Icon icono2 =new ImageIcon(getClass().getResource("/Imagenes/RV.png"));
        
        J.Lab1J1.setIcon(icono);
        J.Lab1J2.setIcon(icono2);
        J.Lab1J3.setIcon(icono);
        J.Lab1J4.setIcon(icono2);
                
        J.Lab2J1.setIcon(icono);
        J.Lab2J2.setIcon(icono2);
        J.Lab2J3.setIcon(icono);
        J.Lab2J4.setIcon(icono2);
                
        J.Lab3J1.setIcon(icono);
        J.Lab3J2.setIcon(icono2);
        J.Lab3J3.setIcon(icono);
        J.Lab3J4.setIcon(icono2);
                
        J.Lab4J1.setIcon(icono);
        J.Lab4J2.setIcon(icono2);
        J.Lab4J3.setIcon(icono);
        J.Lab4J4.setIcon(icono2);
                
        J.Lab5J1.setIcon(icono);
        J.Lab5J2.setIcon(icono2);
        J.Lab5J3.setIcon(icono);
        J.Lab5J4.setIcon(icono2);
                
        J.Lab6J1.setIcon(icono);
        J.Lab6J2.setIcon(icono2);
        J.Lab6J3.setIcon(icono);
        J.Lab6J4.setIcon(icono2);
                
        J.Lab7J1.setIcon(icono);
        J.Lab7J2.setIcon(icono2);
        J.Lab7J3.setIcon(icono);
        J.Lab7J4.setIcon(icono2);
                
        J.Lab8J1.setIcon(icono);
        J.Lab8J2.setIcon(icono2);
        J.Lab8J3.setIcon(icono);
        J.Lab8J4.setIcon(icono2);
                
        J.Lab9J1.setIcon(icono);
        J.Lab9J2.setIcon(icono2);
        J.Lab9J3.setIcon(icono);
        J.Lab9J4.setIcon(icono2);
                
        J.Lab10J1.setIcon(icono);
        J.Lab10J2.setIcon(icono2);
        J.Lab10J3.setIcon(icono);
        J.Lab10J4.setIcon(icono2);
        
        if(ContJuegos<NJuegos)
            System.out.println("\n\n >> Juego: "+(ContJuegos+1));
    }
    
    public String Ganadores(){
        String S="";
        int Mayor=0;
        for(int i=0;i<4;i++){
            if(Ganadas[i]>Mayor){
                Mayor=Ganadas[i];
            }
        }
        for(int i=0;i<4;i++){
            if(Ganadas[i]==Mayor){
                S+=" "+(i+1);
                JGanadas[i]++;
            }
        }
        Ganadas = new int [4];
        return S;
    }
    
    public void Grafica(){
        for(int i=0;i<4;i++)
        dataset.setValue("Jugador "+(i+1)+": '"+JGanadas[i]+"'", (int) JGanadas[i]);
        chart = ChartFactory.createPieChart("Juegos ganados", dataset, true, true, false);
        panel = new ChartPanel(chart);
        ventana = new JFrame("Gráfica");
        ventana.setVisible(true);
        ventana.setSize(500,500);
        ventana.add(panel);
    }
}
