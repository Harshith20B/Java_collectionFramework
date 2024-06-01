package Problems;

public class prac {
    public static int frequency( String source, String part ) {
        if ( source == null || source.isEmpty() || part == null || part.isEmpty() )
        return 0;
        int count = 0;
        for ( int pos = 0; (pos = source.indexOf( part, pos )) != -1; count++ )
        pos += part.length();
        return count;
        }
        public static void main( String[] args ) {
        System.out.println( frequency( "chschs", "sch" ) );  // 2
        System.out.println( frequency( "cherry schnaps, schnitzel", "zel" ) );  // 1
        System.out.println( frequency( "cherry schnaps, schnitzel", "" ) );    
       }
} 

