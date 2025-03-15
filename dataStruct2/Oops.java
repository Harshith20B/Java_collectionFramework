package dataStruct2;
public class Oops{
    public static void main(String args[]){
        Stud s1 = new Stud();
        Stud s2 = new Stud();
        s1.rollno = 101;
        s1.name = "Sonoo";
        s1.displayInformation();
        s2.displayInformation();
    }
}
class Stud{
    int rollno;
    String name;
    void displayInformation(){
        System.out.println(this.rollno + " " + this.name);
    }
}