package Problems2;
class backtracking{
    static void permutations(String str, String perm, int idx){
        if(str.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currString = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            permutations(newStr,perm+currString,idx+1);
        }
    }
    public static void main(String args[]){
        String str = "ABCD";
        permutations(str,"",0);
    }
}