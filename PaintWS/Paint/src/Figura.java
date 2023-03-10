import java.awt.*;

public abstract class Figura
{
    protected Color cor;
    protected Color pr;
	  
    protected Figura ()
    {
        this (Color.BLACK);
    }
    
    protected Figura (Color cor) {
        this (cor, Color.WHITE);
    }
	  
    protected Figura (Color cor, Color pr) {
        this.setCor (cor, pr);
    }
	  
    public void setCor (Color cor, Color pr) {
        this.cor = cor;
        this.pr = pr;
    }
	  
    public Color getCor()
    {
    	return this.cor;
    }
    
    public Color getPr() {
        return this.pr;
    }

  //public abstract boolean equals         (Object obj);
  //public abstract int     hashCode       ();
  //public abstract Object  clone          ();
    public abstract String  toString       ();
    public abstract void    torneSeVisivel (Graphics g);
}
