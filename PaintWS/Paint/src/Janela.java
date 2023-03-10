import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import static java.awt.event.KeyEvent.VK_DELETE;


 
public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;

	public static final JButton MouseEvent = null;

    protected JButton btnPonto   = new JButton ("Ponto"),
                      btnLinha   = new JButton ("Linha"),
                      btnCirculo = new JButton ("Circulo"),
                      btnElipse  = new JButton ("Elipse"),
                      btnQuadrado  = new JButton ("Quadrado"),
                      btnRetangulo = new JButton ("Retangulo"),
                      btnPoligono = new JButton ("Poligono"),
                      btnCores   = new JButton ("Contorno"),
                      btnPr 	 = new JButton ("Preench."),
                      btnAbrir   = new JButton ("Abrir"),
                      btnSalvar  = new JButton ("Salvar"),
                      btnApagar  = new JButton ("Apagar"),
                      btnEscrita   = new JButton ("Escrita"),
                      btnSair    = new JButton ("Sair");                    
                     
    				  

    protected MeuJPanel pnlDesenho = new MeuJPanel ();
    
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),
                     statusBar2 = new JLabel ("Coordenada:");

    protected boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaCentroCirculo, esperaRaioCirculo,
    esperaInicioElipse, esperaFimElipse, desenhandoElipse,  esperaInicioQuadrado, desenhandoQuadrado, esperaFimQuadrado, esperaInicioPol, esperaFimPol, desenhandoPoligono,
    esperaInicioRetangulo, esperaFimRetangulo, desenhandoRetangulo,esperaInicioTexto, esperaFimTexto;
    

    protected String stringTexto = null, stringFont = null;
    protected Color corAtual = Color.BLACK;
    protected Color corAtualPr = new Color(0,0,0,0);
    protected Ponto p1, p2;
    int x[] = new int[90];
    int y[] = new int[90];
    int vertices, vezesverices;
    private Font  fonteTXT1 = new Font("Arial", 0, 14);
    
    
    
    protected Vector<Figura> figuras = new Vector<Figura>();

    //construtor da janela
    public Janela ()
    {
        super("Editor Gr·fico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
        /*try
        {
            Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.png"));
        btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }*/
        
        

        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
       /*try 
        {
            Image btnPrImg = ImageIO.read(getClass().getResource("resources/preenchimento.jpg"));
            btnPr.setIcon(new ImageIcon(btnPrImg));
        }
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo preenchimento.jpg n√£o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }*/

        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg n„o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        btnPonto.addActionListener   (new DesenhoDePonto());
        btnLinha.addActionListener   (new DesenhoDeReta ());
        btnCores.addActionListener   (new EscolheCor());
        btnPr.addActionListener      (new CorPreenchimento());
        btnCirculo.addActionListener (new DesenhoDeCirculo());
        btnElipse.addActionListener  (new DesenhoDeElipse());
        btnPoligono.addActionListener (new DesenhoDePoligono());
        btnQuadrado.addActionListener(new DesenhoDeQuadrado());
        btnRetangulo.addActionListener(new DesenhoDeRetangulo());
        btnEscrita.addActionListener(new EscreveTexto());


        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnPoligono);
        pnlBotoes.add (btnCores);
        pnlBotoes.add (btnPr);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);
        pnlBotoes.add(btnEscrita);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (1360,720);
        this.setVisible (true);
        this.setLocationRelativeTo(null);
        
        
    }

    protected class MeuJPanel extends    JPanel 
                              implements MouseListener,
                                         MouseMotionListener
    {
	public MeuJPanel()
        {
            super();

            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        //ao clicar sobre o botao
        public void mousePressed (MouseEvent e)
        {
           
			if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = false;
            }
            else
                if (esperaInicioReta)
                {
                    p1 = new Ponto (e.getX(), e.getY(), corAtual);
                    esperaInicioReta = false;
                    esperaFimReta = true;
                    statusBar1.setText("Mensagem: clique o ponto final da reta");    
                 }
                 else
                    if (esperaFimReta)
                    {
                        esperaInicioReta = false;
                        esperaFimReta = false;
                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        statusBar1.setText("Mensagem:");  
                        esperaInicioReta = true;
                    }
                    else
						if (esperaCentroCirculo)
						{
							p1 = new Ponto (e.getX(), e.getY(), corAtual);
							esperaCentroCirculo = false;
							esperaRaioCirculo = true;
							statusBar1.setText("Mensagem: clique no limite do circulo");    
						 }
						 else
							if (esperaRaioCirculo)
							{
								esperaCentroCirculo = false;
								esperaRaioCirculo = false;
								figuras.add (new Circulo (p1.getX(), p1.getY(), (int)Math.round(Math.sqrt(Math.pow(p1.getX()-e.getX(),2)+Math.pow(p1.getY()-e.getY(),2))), corAtual, corAtualPr));
								figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
								statusBar1.setText("Mensagem:");	
							}
							else
								if(esperaInicioElipse){
			                            esperaInicioElipse = false;			                            
			                            esperaFimElipse = true;

			                            p1 = new Ponto (e.getX(), e.getY(), corAtual);

			                            statusBar1.setText("Mensagem: click no limite da elipse");
			                        }
								else
									if(esperaFimElipse) {
											
										esperaInicioElipse = false;			                            
			                            esperaFimElipse = false;									
										figuras.add(new Elipse(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualPr));
				                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());

				                        statusBar1.setText("Mensagem:");
									}
									else
			                            if (esperaInicioQuadrado) {
			                                esperaInicioQuadrado = false;
			                                esperaFimQuadrado = true;			                               
			                                

			                                p1 = new Ponto (e.getX(), e.getY(), corAtual);
			                                x[0] = p1.getX();
			                                y[0] = p1.getY();

			                                statusBar1.setText("Mensagem: clique no limite do quadrado");    
			                            }
			                            
			                            else				                        	
				                              if (desenhandoQuadrado) {
				                                    esperaFimQuadrado = true;
				                                            
				                                    x[1] = e.getX();
				                                    y[1] = e.getY();
				                                    Quadrado quadradoDeDois = new Quadrado(x, y, corAtual, corAtualPr);
				                                    
				                                    quadradoDeDois.torneSeVisivel(pnlDesenho.getGraphics());
				                                    
				                                }            
									else
				                        if (esperaFimQuadrado) {
				                            esperaFimQuadrado = false;				                            
				                            esperaInicioQuadrado = false;				                            

				                            figuras.add (new Quadrado(x, y, corAtual, corAtualPr));
				                            figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());

				                            statusBar1.setText("Mensagem:");    
				                        }
				                        
				                        else
			                                if (esperaInicioRetangulo) {
			                                    esperaInicioRetangulo = false;
			                                    desenhandoRetangulo = true;

			                                    p1 = new Ponto (e.getX(), e.getY(), corAtual);
			                                    x[0] = p1.getX();
			                                    y[0] = p1.getY();

			                                    statusBar1.setText("Mensagem: solte o mouse no ponto final do retangulo");    
			                                }
			                                else
			                                	if (esperaFimRetangulo) {
			                                        esperaFimRetangulo = false;
			                                        desenhandoRetangulo = false;
			                                        esperaInicioRetangulo = true;
			                                        

			                                        figuras.add (new Retangulo(x, y, corAtual, corAtualPr));
			                                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());

			                                        statusBar1.setText("Mensagem:");
			                                    }
				                        else 
		                                    if(esperaInicioPol){
		                                        System.out.println("entrou poli");
		                                        esperaInicioPol = false;
		                                        desenhandoPoligono = true;
		                                        esperaFimPol = false;
		                                        p1 = new Ponto (e.getX(), e.getY(), corAtual);
		                                        stringTexto = JOptionPane.showInputDialog(null, "Nros de vertices", "Nros Vertices:", JOptionPane.PLAIN_MESSAGE);
		                                        x[0] = p1.getX();
		                                        y[0] = p1.getY();
		                                        vertices = Integer.parseInt(stringTexto);
		                                        vezesverices = 1;
		                                        statusBar1.setText("Mensagem: clique o ponto final do poligono");       
		                                    }
		                                    else
		                                        if(desenhandoPoligono){
		                                            esperaInicioPol = false;
		                                            esperaFimPol = false;
		                                            if(vezesverices < vertices){
		                                                p1 = new Ponto (e.getX(), e.getY(), corAtual);
		                                               
		                                                x[vezesverices] = p1.getX();
		                                                y[vezesverices] = p1.getY();
		                                                vezesverices++;
		                                                System.out.println("passou ponto");
		                                            }
		                                            if(vezesverices == vertices){
		                                                System.out.println("saiu poli");
		                                                esperaInicioPol = false;
		                                                figuras.add (new Poligono(x, y, vertices, corAtual, corAtualPr));
		                                                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
		                                                statusBar1.setText("Mensagem:");
		                                                desenhandoPoligono = false;
		                                                esperaInicioPol = true;
		                                                
		                                            }
		                                            else
		                                                if(esperaInicioTexto)
		                                                {
		                                                	esperaInicioTexto = true;
		                                                    p1 = new Ponto (e.getX(), e.getY(), corAtual);
		                                                    stringTexto = JOptionPane.showInputDialog(null, "Texto:", "Digite alguma coisa", JOptionPane.PLAIN_MESSAGE);
		                                                    figuras.add (new Text(p1.getX(), p1.getY(), stringTexto, corAtual, corAtualPr, fonteTXT1));
		                                                    figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
		                                                    statusBar1.setText("Mensagem: Digite o texto a ser exibido");
		                                                    String nova_string = figuras.get(figuras.size()-1).toString();
		                                                    System.out.println(nova_string);
		                                                }
		                                                
		                                        }
            				
            
       }
        
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
        }
    }

    protected class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              esperaPonto      = true;
              esperaInicioReta = false;
              esperaFimReta    = false;

              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = true;
            esperaFimReta    = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }
    
    protected class EscolheCor implements ActionListener
    {  	     	
    	
		public void actionPerformed (ActionEvent e)    
         {				
    		Color escolheCor = JColorChooser.showDialog(null, "Escolha uma Cor", Color.white);
    		corAtual = escolheCor;    		
         }		
    }
    
    private class CorPreenchimento implements ActionListener {
        public void actionPerformed (ActionEvent e) {           
            Color corPr = JColorChooser.showDialog(btnCores, "Selecione a cor", Color.yellow);
            corAtualPr = corPr;
        }
    }
    
    protected class DesenhoDeCirculo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
              esperaPonto         = false;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = true;
              esperaRaioCirculo   = false;

            statusBar1.setText("Mensagem: clique no centro do circulo");
        }
    }
    
    private class DesenhoDeElipse implements ActionListener {
        public void actionPerformed (ActionEvent e) {
           
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;       
            esperaCentroCirculo = false;
            esperaRaioCirculo   = false;
            esperaInicioElipse = true;
            esperaFimElipse = false;
            

            statusBar1.setText("Mensagem: clique o ponto central da Elipse");
        }
    }
    
    private class DesenhoDeQuadrado implements ActionListener {
        public void actionPerformed (ActionEvent e) {
           
            
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaCentroCirculo = false;
            esperaRaioCirculo   = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaFimQuadrado = false;				                            
            esperaInicioQuadrado = true;

            statusBar1.setText("Mensagem: clique o ponto central da quadrado");
        }
    }
    private class DesenhoDeRetangulo implements ActionListener {
        public void actionPerformed (ActionEvent e) {
    
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaCentroCirculo = false;
            esperaRaioCirculo = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioRetangulo = true;
            esperaFimRetangulo = false; 
            esperaInicioPol = false;
            esperaFimPol = false;
      

            statusBar1.setText("Mensagem: clique o ponto central da retangulo");
        }
    } 
	private class EscreveTexto extends JFrame implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	setCursor(new Cursor(Cursor.TEXT_CURSOR));
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaCentroCirculo = false;
            esperaRaioCirculo = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioRetangulo = false;
            esperaFimRetangulo  = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioTexto = true;
            esperaFimTexto    = false;
            esperaInicioPol   = false;
            esperaFimPol      = false;
                                    
            statusBar1.setText("Mensagem: ");
        }
    }
    private class DesenhoDePoligono implements ActionListener {
        public void actionPerformed (ActionEvent e) {
         
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioPol = true;
            esperaFimPol = false;
            

            statusBar1.setText("Mensagem: clique o ponto central da retangulo");
        }
    }

    protected class FechamentoDeJanela extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }
    

    
}
