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
	
	public static boolean yraDalisSkaiciaus ( String simbolis ) {

		String[] dalys_skaiciaus = { ".", ",", "-", "e", "E", "+", "/", "%" };

		boolean yra_dalis_skaiciaus = false;
		
		for (int i = 0; i < dalys_skaiciaus.length; i++ ) {
		
			if ( simbolis.equals ( dalys_skaiciaus [ i ] ) ) {
			
				yra_dalis_skaiciaus = true;
			}
		}
		return yra_dalis_skaiciaus;
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
			 
				boolean pries_tai_buvo_skaitmuo = false;
				
				System.out.println( thisLine );
				
				for ( int i = 0; i < thisLine.length(); i++ ) {
					
					simb =  thisLine.substring( i, i+1 );
				
					if ( 
							yraSkaitmuo ( simb ) 
						|| 
							( 
									pries_tai_buvo_skaitmuo  
								&& 
									yraDalisSkaiciaus ( simb )
							)
					) {
						
						if ( pries_tai_buvo_skaitmuo ) {
						
							skaiciai [ kiekis_skaiciu - 1 ] += simb;
							
						} else {
							
							skaiciai [ kiekis_skaiciu ] = simb;
							kiekis_skaiciu++;
						}
					
						pries_tai_buvo_skaitmuo = true;
						
					} else {
						
						pries_tai_buvo_skaitmuo = false;
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