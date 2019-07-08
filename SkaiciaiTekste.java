import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SkaiciaiTekste {
	
	public static boolean yraSkaitmuo ( String simbolis ) {
		
		String[] skaitmenys = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		
		boolean yra_skaitmuo = false;
		
		for (int i = 0; i < 10; i++ ) {
		
			if ( simbolis.equals ( skaitmenys [ i ] ) ) {
			
				yra_skaitmuo = true;
			}
		}
		return yra_skaitmuo;
	}
	
	public static void main(String[] args) throws Exception {
	   
		String thisLine = null;
		
		try {
																									// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader( new FileReader( "tekstas.txt" ) );
			
			System.out.println ( "duomenų failo turinys:" );
			
			String simb;
			String[] skaiciai = new String [ 1000 ];
			
																									// double[] skaiciai = new double[1000];
			int kiekis_skaitmenu = 0;
		 
			while ( ( thisLine = br.readLine() ) != null ) {
			 
				
				System.out.println( thisLine );
				
				for ( int i = 0; i < thisLine.length(); i++ ) {
					
					simb =  thisLine.substring( i, i+1 );
				
					if ( yraSkaitmuo ( simb ) ) {
						
						skaiciai [ kiekis_skaitmenu ] = simb;
						
						kiekis_skaitmenu++;
					}
				}
			} 
			System.out.println ( "viso skaitmenu: " + kiekis_skaitmenu );
			
			for ( int i = 0; i < kiekis_skaitmenu; i++ ) {
			
				System.out.print ( " " + skaiciai [ i ] );
			}
			System.out.println();
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}