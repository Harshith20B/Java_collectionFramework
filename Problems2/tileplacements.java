package Problems2;

public class tileplacements {
    public static int placeTiles(int n,int m){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        int verticalTiles = placeTiles(n-m,m);
        int horizontalTiles = placeTiles(n-1,m);
        return verticalTiles+horizontalTiles;
    }
    public static void main(String args[]){
        int n=4,m=2;
        System.out.println(placeTiles(n,m));
    }
}
