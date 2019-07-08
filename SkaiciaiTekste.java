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
	
	public static String excludeSh ( String with_sh ) {
		
		String excluded_sh = "";
		
		for ( int i = 0; i < ( with_sh.length() - 1 ); i++ ) {
			
			String simb2 = with_sh.substring( i, i + 2 );
			String simb1 = with_sh.substring( i, i + 1 );
		
			if ( simb2.equals( "š" ) ) {
				
				excluded_sh  += 's';
				
			} else {
			
				excluded_sh += simb1;
			}
		}
		return excluded_sh;
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
			int kiekis_skaiciu = 0; 

			while ( ( thisLine = br.readLine() ) != null ) {
			 
				boolean skaitmuo = false;
				
				System.out.println( excludeSh ( thisLine ) );
				
				for ( int i = 0; i < thisLine.length(); i++ ) {
					
					simb =  thisLine.substring( i, i+1 );
				
					if ( yraSkaitmuo ( simb ) ) {
						
						if ( skaitmuo ) {
						
							skaiciai [ kiekis_skaiciu - 1 ] += simb;
							
						} else {
							
							skaiciai [ kiekis_skaiciu ] = simb;
							kiekis_skaiciu++;
						}
						skaitmuo = true;
						
					} else {
						
						skaitmuo = false;
					}
				}
			} 
			System.out.println ( "viso skaiciu: " + kiekis_skaiciu );
			
			for ( int i = 0; i < kiekis_skaiciu; i++ ) {
			
				System.out.println ( " " + skaiciai [ i ] );
			}
			System.out.println();
			
		} catch( Exception e ) {
			
			e.printStackTrace();
		}
	}
}