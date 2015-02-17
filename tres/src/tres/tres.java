package tres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tres 
{
    int taulell[][]= new int [3][3];
    
    public void dibuixa()
    {         
       int filas_tablero=0;
       int columnas_tablero=0;
        
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

    public void inici()
    {
    	for(int i=0; i<taulell.length;i++)
    	{
            for(int j=0; j<taulell.length;j++)
            {
            	taulell[i][j]=3;
            }
    	}
    }

    public void joc() throws NumberFormatException, IOException
    {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String int0;
            String intx;
            boolean fin=false;
           
            System.out.println("COM VOLS JUGAR: X/0?");
            String joc = teclado.readLine().toUpperCase();
            int valor_joc=0;
            if(joc.equals("0"))
            {
                valor_joc=0;
            }
            if(joc.equals("X"))
            {
                
                valor_joc=1;
                
            }
            if(joc.equals("X") || (joc.equals("0")))
            {
            	System.out.println("Comienza el 0");
            	System.out.println("");
            
            	while(fin==false)
            	{
            		dibuixa();
            		if(valor_joc==1)
            		{
            			System.out.println("Te toca X");
            		}
            		if(valor_joc==0)
            		{
            			System.out.println("Te toca 0");
            		}
            		System.out.println("INTRODUEIX LES COORDENADES: (0,0) ");
            		System.out.println("INTRODUEIX LA FILA:");
            		int fila= Integer.parseInt(teclado.readLine());
            		System.out.println("INTRODUEIX LA COLUMNA:");
            		int columna= Integer.parseInt(teclado.readLine());
            		if(taulell[fila][columna]==3)
            		{
            			boolean g;
            			taulell[fila][columna]=valor_joc;
            			dibuixa();
            			g=guanyador(valor_joc);
                
            			if(g)
            			{
            				System.out.println("HHA GUANYAT: " + valor_joc);
            				fin=true;
            				inici();
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
                        System.out.println("EMPAT!");
                        fin=true;
                    }
                    if(valor_joc==1)
                    {
                        valor_joc=0;
                    }
                    else
                    {
                        if(valor_joc==0)
                        {
                        	valor_joc=1;
                        }
                    }
                }
            }
            else
            {
                System.out.println("NO POTS JUGAR, YA ESTA USAT");
            }
            }
            }         
    }
    public boolean guanyador(int valor_joc)
    {
    
	    if((taulell[0][0]==valor_joc) && (taulell[0][1]==valor_joc) && (taulell[0][2]==valor_joc)){
	        return true;
	    }
	    if((taulell[1][0]==valor_joc) && (taulell[1][1]==valor_joc) && (taulell[1][2]==valor_joc)){
	        return true;
	    }
	    if((taulell[2][0]==valor_joc) && (taulell[2][1]==valor_joc) && (taulell[2][2]==valor_joc)){
	        return true;
	    }
	    if((taulell[0][0]==valor_joc) && (taulell[2][0]==valor_joc) && (taulell[3][0]==valor_joc)){
	        return true;
	    }
	    if((taulell[0][1]==valor_joc) && (taulell[1][1]==valor_joc) && (taulell[2][1]==valor_joc)){
	        return true;
	    }
	    if((taulell[0][2]==valor_joc) && (taulell[1][2]==valor_joc) && (taulell[2][2]==valor_joc)){
	        return true;
	    }
	    if((taulell[0][0]==valor_joc) && (taulell[1][1]==valor_joc) && (taulell[2][2]==valor_joc)){
	        return true;
	    }
	    if((taulell[0][2]==valor_joc) && (taulell[1][1]==valor_joc) && (taulell[2][0]==valor_joc)){
	        return true;
	    }
	    return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException 
    {
	    tres tresenraya= new tres();
	    
	    tresenraya.inici();
	    tresenraya.dibuixa();
	  	tresenraya.joc();
    }	
}
