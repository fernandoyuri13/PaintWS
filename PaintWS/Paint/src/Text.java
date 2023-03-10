import java.awt.*;
import java.util.*;
 
public class Text extends Figura {
    protected Ponto inicio;
    protected String   string;
    protected  Font fonte;
   
    protected int xi, yi;
       
    public Text (int x, int y,String texto, Font fonte) {
        this (x, y, texto, Color.BLACK, Color.white, fonte);
    }
       
    public Text (int x, int y, String texto, Color cor, Color cor2, Font ft) {
        super (cor, cor2);
       
        this.xi = x;
        this.yi = y;
 
        this.inicio  = new Ponto (x,y);
        this.string   = texto;
        this.fonte    = ft;
    }
 
    public Text (String s) {
        StringTokenizer quebrador = new StringTokenizer(s,":");
 
        quebrador.nextToken();
 
        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());
 
        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
         
        
 
        this.inicio   = new Ponto (x,y,cor);
        this.cor      = cor;
    }
 
    public void setInicio (int x, int y) {
        this.inicio = new Ponto (x,y,this.getCor());
    }
 
    public void setText (String texto) {
        this.string = texto;
    }
       
    public Ponto getInicio () {
        return this.inicio;
    }
 
    public String setText () {
        return this.string;
    }
 
    public void torneSeVisivel (Graphics g) {                          
            g.setColor (this.cor);
            g.setFont(this.fonte);
            g.drawString(this.string, this.inicio.getX(), this.inicio.getY());            
    }
 
    public String toString() {
        return "t:" +
               this.xi +
               ":" +
               this.yi +
               ":" +
               this.string +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() +
                ":" +
               this.fonte.getSize() +
               ":" +
               this.fonte.getFamily() +
               ":" +
               this.fonte.getStyle();
    }
   
}