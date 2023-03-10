import java.awt.*;
import java.util.*;

public class Retangulo extends Figura {
    protected int xis[] = new int[99];
    protected int yis[] = new int[99];
    
    protected int ladox, ladoy;
	
    public Retangulo (int x[], int y[]) {
        this (x, y, Color.BLACK, Color.WHITE);
    }
	
    public Retangulo (int x[], int y[], Color cor) {
        this (x, y, cor, Color.WHITE);
    }
    
    public Retangulo (int x[], int y[], Color cor, Color preen) {
        super(cor,preen);

        this.ladox = Math.abs(x[0] - x[1]);
        this.ladoy = Math.abs(y[0] - y[1]);
        
        
        
        this.xis[0] = x[0]; this.yis[0] = y[0]; //p0 do retangulo
        if(y[1] > y[0]){
            if(x[1] > x[0]){
                //1� quadrante
                this.xis[1] = x[0] + this.ladox; this.yis[1] = y[0]; //p1
                this.xis[2] = x[0] + this.ladox; this.yis[2] = y[0] + this.ladoy; //p2
                this.xis[3] = x[0];             this.yis[3] = y[0] + this.ladoy; //p3
            }
            else{
                //2� quadrante
                this.xis[1] = x[0];             this.yis[1] = y[0] + this.ladoy; //p1
                this.xis[2] = x[0] - this.ladox; this.yis[2] = y[0] + this.ladoy; //p2
                this.xis[3] = x[0] - this.ladox; this.yis[3] = y[0]; //p3
            }
        }
        else{
            if(x[1] < x[0]){
                //3� quadrante
                this.xis[1] = x[0] - this.ladox; this.yis[1] = y[0]; //p1
                this.xis[2] = x[0] - this.ladox; this.yis[2] = y[0] - this.ladoy; //p2
                this.xis[3] = x[0];             this.yis[3] = y[0] - this.ladoy; //p3
            }
            else{
                //4� quadrante
                this.xis[1] = x[0];             this.yis[1] = y[0] - this.ladoy; //p1
                this.xis[2] = x[0] + this.ladox; this.yis[2] = y[0] - this.ladoy; //p2
                this.xis[3] = x[0] + this.ladox; this.yis[3] = y[0]; //p3
            }
        }
    }

    public Retangulo (String q) {
        StringTokenizer quebrador = new StringTokenizer(q,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   lado   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

//        this.centro = new Ponto (x,y,cor);
//        this.raio   = r;
//        this.cor    = cor;
        //aqui vamos ter que pegar tamb�m a cor do preenchimento
    }

    public void setP0 (int x, int y) {
        this.xis[0] = x;
        this.yis[0] = y;
    }
    
    public void setPontos (int x[], int y[]) {
        this.xis = x;
        this.yis = y;
    }

    public void setLadox (int ladox) {
        this.ladox = ladox;
    }
    
    public void setLadoy (int ladoy) {
        this.ladoy = ladoy;
    }
    
    public int getLadox () {
        return this.ladox;
    }
    
    public int getLadoy () {
        return this.ladoy;
    }

    public Ponto getP0 () {
        Ponto P0 = new Ponto(this.xis[0], this.yis[0]);
        return P0;
    }

    public void torneSeVisivel (Graphics g) {
        g.fillPolygon (xis, yis, 4);
        g.setColor (this.cor);
        g.drawPolygon (xis, yis, 4);
    }

    public String toString() {
        return "r:" +
               this.xis[0] +
               ":" +
               this.xis[2] +
               ":" +
               this.yis[0] +
               ":" +
               this.yis[2] +
               ":" +
               this.ladox +
               ":" +
               this.ladoy +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() + 
                ":" ;
              
    }
    
    public boolean cliquePertence (int x, int y){
        Polygon poligono_aux = new Polygon(xis, yis, 4);
        if(poligono_aux.contains((double)x, (double)y))
            return true;
        else
            return false;
    }
    
    public void move (int x, int y){
        int x1[] = new int [4];
        int y1[] = new int [4];
        
        x1[0] = x - this.ladox/2;  y1[0] = y + this.ladoy/2;
        x1[1] = x + this.ladox/2;  y1[1] = y + this.ladoy/2;
        x1[2] = x + this.ladox/2;  y1[2] = y - this.ladoy/2;
        x1[3] = x - this.ladox/2;  y1[3] = y - this.ladoy/2;
        
        
        setPontos(x1,y1);
    }
}
