import java.util.*;
class Book{
    String author, publisher, title;
    int id;
    double price;
    Book(int id, String title, String author, String publisher, double price){
        this.author=author;
        this.publisher = publisher;
        this.id = id;
        this.price = price;
        this.title = title;
    }
    public String toString(){
        return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + ", Publisher=" + publisher + ", Price=" + price + "]";
    }
}
public class pr{
    public static void main(String args[]){
        ArrayList<Book> books = new ArrayList<>();
        int nextId=0;
        books.add(new Book(nextId++, "The Catcher in the Rye", "J.D. Salinger","Little, Brown and Company", 299.99));
        books.add(new Book(nextId++, "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 199.99));
        books.add(new Book(nextId++, "1984", "George Orwell", "Secker & Warburg", 249.99));
        books.add(new Book(nextId++, "Pride and Prejudice", "Jane Austen", "T. Egerton", 159.99));
        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparingDouble(book -> book.price));
        System.out.println(sortedBooks.toString());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter author name");
        String author = sc.nextLine();
        ArrayList<Book> authorBooks = new ArrayList<>();
        for(Book book : books){
            if(book.author.equalsIgnoreCase(author)){
                authorBooks.add(book);
            }
        }
        System.out.println(authorBooks.toString());
        System.out.println("Enter price");
        int minPrice = sc.nextInt();
        ArrayList<Book> premiumBooks = new ArrayList<>();
        for(Book book : books){
            if(book.price > minPrice){
                premiumBooks.add(book);
            }
        }
        System.out.println(premiumBooks.toString());
    }
}