package tres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tres 
{
    int taulell[][]= new int [3][3];
    
    public void dibuja_tres_en_raya()
    {         
       int filas_tablero=0;
       int columnas_tablero;
        
        System.out.println("----------");
        for(int i=0; i<taulell.length;i++){
            for(int j=0; j<taulell.length;j++){
               
                if(taulell[i][j]==0){                    
                    System.out.print("| " + taulell[i][j] + " ");
                }
                if (taulell[i][j]==1)
                {
                     System.out.print("| " + "X" + " ");
                    
                }
                if (taulell[i][j]==3)
                {
                     System.out.print("|" + "  ");
                    
                }
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("-------------");
        
    }

    public void inicializa()
    {
    	for(int i=0; i<taulell.length;i++)
    	{
            for(int j=0; j<taulell.length;j++)
            {
            	taulell[i][j]=3;
            }
    	}
    }

    public void comenzar_a_jugar() throws NumberFormatException, IOException
    {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String introduce0;
            String introduceX;
            boolean fin=false;
           
            System.out.println("¿Cómo quieres jugar X/0?");
            String juego = teclado.readLine().toUpperCase();
            int valor_juego=0;
            if(juego.equals("0"))
            {
                valor_juego=0;
            }
            if(juego.equals("X"))
            {
                
                valor_juego=1;
                
            }
            if(juego.equals("X") || (juego.equals("0")))
            {
            	System.out.println("Comienza el 0");
            	System.out.println("");
            
            	while(fin==false)
            	{
            		dibuja_tres_en_raya();
            		if(valor_juego==1)
            		{
            			System.out.println("Te toca X");
            		}
            		if(valor_juego==0)
            		{
            			System.out.println("Te toca 0");
            		}
            		System.out.println("Introduce coordenadas de posición: (0,0) ");
            		System.out.println("Introduce la fila");
            		int fila= Integer.parseInt(teclado.readLine());
            		System.out.println("Introduce la columna");
            		int columna= Integer.parseInt(teclado.readLine());
            		if(taulell[fila][columna]==3)
            		{
            			boolean g;
            			taulell[fila][columna]=valor_juego;
            			dibuja_tres_en_raya();
            			g=guanyador(valor_juego);
                
            			if(g)
            			{
            				System.out.println("Ha ganado " + valor_juego);
            				fin=true;
            				inicializa();
            			}
            			else 
            			{
            				int estado_empate=0;
            				for(int i=0;i<=2;i++)
            				{
            					for(int j=0;j<=2;j++)
            					{
                            if((taulell[i][j]==0) || (taulell[i][j]==1))
                            {
                                estado_empate=estado_empate+1;
                            }
                        }
                    }
                    if(estado_empate==9)
                    {
                        System.out.println("Se ha empatado");
                        fin=true;
                    }
                    if(valor_juego==1)
                    {
                        valor_juego=0;
                    }
                    else
                    {
                        if(valor_juego==0)
                        {
                        	valor_juego=1;
                        }
                    }
                }
            }
            else
            {
                System.out.println("No puede jugar, ya está usado");
            }
            }
            }         
    }
    public boolean guanyador(int valor_juego)
    {
    
	    if((taulell[0][0]==valor_juego) && (taulell[0][1]==valor_juego) && (taulell[0][2]==valor_juego)){
	        return true;
	    }
	    if((taulell[1][0]==valor_juego) && (taulell[1][1]==valor_juego) && (taulell[1][2]==valor_juego)){
	        return true;
	    }
	    if((taulell[2][0]==valor_juego) && (taulell[2][1]==valor_juego) && (taulell[2][2]==valor_juego)){
	        return true;
	    }
	    if((taulell[0][0]==valor_juego) && (taulell[2][0]==valor_juego) && (taulell[3][0]==valor_juego)){
	        return true;
	    }
	    if((taulell[0][1]==valor_juego) && (taulell[1][1]==valor_juego) && (taulell[2][1]==valor_juego)){
	        return true;
	    }
	    if((taulell[0][2]==valor_juego) && (taulell[1][2]==valor_juego) && (taulell[2][2]==valor_juego)){
	        return true;
	    }
	    if((taulell[0][0]==valor_juego) && (taulell[1][1]==valor_juego) && (taulell[2][2]==valor_juego)){
	        return true;
	    }
	    if((taulell[0][2]==valor_juego) && (taulell[1][1]==valor_juego) && (taulell[2][0]==valor_juego)){
	        return true;
	    }
	    return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException 
    {
	    tres tresenraya= new tres();
	    
	    tresenraya.inicializa();
	    tresenraya.dibuja_tres_en_raya();
	  	tresenraya.comenzar_a_jugar();
    }	
}
