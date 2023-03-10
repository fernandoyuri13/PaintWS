import java.awt.*;
import java.util.*;
 
public class Circulo extends Figura
{
    protected Ponto centro;
    protected int   raio;
    
    public Circulo (int x, int y, int raio)
    {
        this (x, y, raio, Color.BLACK, Color.WHITE);
    }
	
    public Circulo (int x, int y, int raio, Color cor, Color pr)
    {
        super (cor, pr);

        this.centro = new Ponto (x,y,cor);
        this.raio   = raio;
    }

    public Circulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x  = Integer.parseInt(quebrador.nextToken());
        int   y  = Integer.parseInt(quebrador.nextToken());

        int   raio = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        Color pr = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				 Integer.parseInt(quebrador.nextToken()),  // G
                				 Integer.parseInt(quebrador.nextToken()));  // B
                

        this.centro = new Ponto (x,y,cor);
        this.raio   = raio;
        this.cor    = cor;
        this.pr = pr;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setRaio (int raio)
    {
        this.raio = raio;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaio ()
    {
        return this.raio;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor(this.cor);
        g.drawOval(this.centro.getX()-this.raio, this.centro.getY()-this.raio,  // canto superior esquerdo de um quadrado imaginario que contem o circulo
                   2*this.raio, 2*this.raio);  // largura e altura
        
        g.setColor(this.pr);
        g.fillOval(this.centro.getX()-this.raio, this.centro.getY()-this.raio,  // canto superior esquerdo de um quadrado imaginario que contem o circulo
                2*this.raio, 2*this.raio); 
    }

    public String toString()
    {
        return "c:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio +
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
        	   this.getPr().getBlue();
        		
        		
    }
    
}
