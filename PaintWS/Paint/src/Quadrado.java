import java.awt.Color;
import java.awt.Graphics;
import java.util.StringTokenizer;

public class Quadrado extends Figura {
    protected int x1 [] = new int[4];
    protected int y1 [] = new int[4];
    
    protected int lado;
	
    public Quadrado (int x[], int y[]) {
        this (x, y, Color.BLACK, Color.WHITE);
    }
	
    public Quadrado (int x[], int y[], Color cor) {
        this (x, y, cor, Color.WHITE);
    }
    
    public Quadrado (int x[], int y[], Color cor, Color pr) {
        super(cor,pr);

        if(Math.abs(x[0] - x[1]) > Math.abs(y[0] - y[1]))
            this.lado = (int)(Math.abs(x[0] - x[1]));
        else 
            this.lado = (int)(Math.abs(y[0] - y[1]));
        
        this.x1[0] = x[0]; this.y1[0] = y[0]; 
        if(y[1] > y[0]){
            if(x[1] > x[0])
            {
            	
                
                this.x1[1] = x[0] + this.lado; this.y1[1] = y[0]; 
                this.x1[2] = x[0] + this.lado; this.y1[2] = y[0] + this.lado; 
                this.x1[3] = x[0];             this.y1[3] = y[0] + this.lado; 
            }
            
            else
            {
                
                this.x1[1] = x[0];             this.y1[1] = y[0] + this.lado; 
                this.x1[2] = x[0] - this.lado; this.y1[2] = y[0] + this.lado; 
                this.x1[3] = x[0] - this.lado; this.y1[3] = y[0]; 
            }
        }
        else
        {
            if(x[1] < x[0])
            {
                
                this.x1 [1] = x[0] - this.lado; this.y1 [1] = y[0]; 
                this.x1 [2] = x[0] - this.lado; this.y1 [2] = y[0] - this.lado; 
                this.x1 [3] = x[0];             this.y1 [3] = y[0] - this.lado; 
            }
            else
            {
                
                this.x1 [1] = x[0];             this.y1 [1] = y[0] - this.lado;
                this.x1 [2] = x[0] + this.lado; this.y1 [2] = y[0] - this.lado; 
                this.x1 [3] = x[0] + this.lado; this.y1 [3] = y[0]; 
            }
        }
    }

    public Quadrado (String q) {
        StringTokenizer quebrador = new StringTokenizer(q,":");

        quebrador.nextToken();
        int x[] = new int[3];
        int y[] = new int[3];

        x[0]   = Integer.parseInt(quebrador.nextToken());
        y[0]   = Integer.parseInt(quebrador.nextToken());
        x[1]   = Integer.parseInt(quebrador.nextToken());
        y[1]   = Integer.parseInt(quebrador.nextToken());
        x[2]   = Integer.parseInt(quebrador.nextToken());
        y[2]   = Integer.parseInt(quebrador.nextToken());
        x[3]   = Integer.parseInt(quebrador.nextToken());
        y[3]   = Integer.parseInt(quebrador.nextToken());

        int   lado   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        Color pr = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken()),  // B
                               Integer.parseInt(quebrador.nextToken())); // Alpha
        
        this.x1[0] = x[0]; this.x1 [1] = x[1]; this.x1 [2] = x[2]; this.x1 [3] = x[3];
        this.y1[0] = y[0]; this.y1 [1] = y[1]; this.y1 [2] = y[2]; this.y1 [3] = y[3];
        
        this.cor = cor;
        this.pr  = pr;
    }

    public void setP0 (int x, int y) {
        this.x1 [0] = x;
        this.y1 [0] = y;
    }
    
    public void setPontos (int x[], int y[]) {
        this.x1 = x;
        this.y1 = y;
    }

    public void setLado (int lado) {
        this.lado = lado;
    }
    
    public int getLado () {
        return this.lado;
    }

    public Ponto getP0 () {
        Ponto P0 = new Ponto(this.x1[0], this.y1[0]);
        return P0;
    }

    public void torneSeVisivel (Graphics g) {
        g.setColor (this.pr);
        g.fillPolygon (x1, y1, 4);
        g.setColor (this.cor);
        g.drawPolygon (x1, y1, 4);
    }

    public String toString() {
        return "q:" +
               this.x1[0] +
               ":" +
               this.y1[0] +
               ":" +
               this.x1[1] +
               ":" +
               this.y1[1] +
               ":" +
               this.x1[2] +
               ":" +
               this.y1[2] +
               ":" +
               this.x1[3] +
               ":" +
               this.y1[3] +
               ":" +
               this.lado +
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
