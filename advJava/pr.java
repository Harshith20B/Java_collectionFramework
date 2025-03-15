package advJava;
class pr{

 		int rollno;  
 		String name;  
 		String city;  
 	pr(int rollno, String name, String city)
		{  
	 this.rollno=rollno;  
 		this.name=name;  
 		this.city=city;  
		}  
 	public String toString()
		{//overriding the toString() method  
 		 return rollno+" "+name+" "+city;  
 		}  
 	public static void main(String args[]){  
   		pr s1=new pr(101,"Raj","lucknow");  
  		pr s2=new pr(102,"Vijay","ghaziabad");  
   		System.out.println(s1.toString() );//compiler writes here s1.toString()  
   		System.out.println(s2);//compiler writes here s2.toString()  
 }  
} 
