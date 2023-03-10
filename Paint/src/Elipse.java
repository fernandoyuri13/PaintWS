import java.awt.*;
import java.util.*;

public class Elipse extends Figura {
    protected int centrox, centroy, x00, y00, x01, y01;
    protected int raiox, raioy;
	
    public Elipse (int x, int y, int x1, int y1) {
        this (x, y, x1, y1, Color.BLACK, Color.WHITE);
    }
    
    public Elipse (int x, int y, int x1, int y1, Color cor) {
        this (x, y, x1, y1, cor, Color.WHITE);
    }
    
    public Elipse (int x, int y, int x1, int y1, Color cor, Color pr) {
        super (cor,pr);
        x00 = x;
        y00 = y;
        x01 = x1;
        y01 = y1;
        this.raiox = (int)Math.abs(x-x1)/2;
        this.raioy = (int)Math.abs(y-y1)/2;
        
        if(y1 > y){
            if(x1 > x){
                
            	
                this.centrox = (x+raiox);
                this.centroy = (y+raioy);
            }
            else{
            	
                this.centrox = (x-raiox);
                this.centroy = (y+raioy);
            }
        }
        else{
            if(x1 < x){
            	
                this.centrox = (x-raiox);
                this.centroy = (y-raioy);
            }
            else{
            	
                this.centrox = (x+raiox);
                this.centroy = (y-raioy);
            }
        }
    }

    public Elipse (String s) {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   raiox  = Integer.parseInt(quebrador.nextToken());
        int   raioy  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        Color pr = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken()),  // B
                               Integer.parseInt(quebrador.nextToken())); // Alpha

        this.centrox = x;
        this.centroy = y;
        this.raiox  = raiox;
        this.raioy  = raioy;
        this.cor    = cor;
        this.pr = pr;
    }

    
    public void setCentro (Ponto centro) {
        this.centrox = centro.getX();
        this.centroy = centro.getY();
    }
    
    public void setCentro (int x, int y) {
        this.centrox = x;
        this.centroy = y;
    }
    
    public void setCentroX (int x) {
        this.centrox = x;
    }
    
    public void setCentroY (int y) {
        this.centrox = y;
    }

    public void setRaioX (int raiox) {
        this.raiox = raiox;
    }

    public void setRaioY (int raioy) {
        this.raioy = raioy;
    }
    
    
    public Ponto getCentro () {
        Ponto ponto = new Ponto(this.centrox, this.centroy, this.cor);
        return ponto;
    }

    public int getRaioX () {
        return this.raiox;
    }

    public int getRaioY () {
        return this.raioy;
    }
    
    public void torneSeVisivel (Graphics g) {
        g.setColor (this.pr);
        g.fillOval (this.centrox-raiox, this.centroy-raioy, 2*raiox, 2*raioy);
        
        g.setColor (this.cor);
        g.drawOval (this.centrox-raiox, this.centroy-raioy, 2*raiox, 2*raioy);
    }

    public String toString() {
        return "e:" +
               this.x00 +
               ":" +
               this.y00 +
               ":" +
               this.x01 +
               ":" +
               this.y01 +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() +
                ":" +
               this.getPr().getRed() + 
                ":" +
               this.getPr().getGreen() + 
                ":" +
               this.getPr().getBlue() +
                ":" +
               this.getPr().getAlpha();
    }
    
  
}
