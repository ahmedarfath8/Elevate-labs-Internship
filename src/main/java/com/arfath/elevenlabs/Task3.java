package com.arfath.elevenlabs;

import java.util.ArrayList;
import java.util.List;

class Book{
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id,String title,String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId(){return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public boolean isAvailable() {return isAvailable;}

    public void setAvailable(boolean available){
        this.isAvailable = available;
    }


}
class User{
    private int id;
    private String name;
    List<Book> issuedBooks;

    public User(int id,String name){
        this.id = id;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public List<Book> getIssuedBooks() {return issuedBooks;}
}
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    private User findUserById(int userId){
        for(User user : users){
            if(user.getId() == userId){
                return user;
            }
        }
        return null;
    }

    private Book findBookById(int bookId){
        for (Book book : books){
            if(book.getId() == bookId){
                return book;
            }
        }
        return null;
    }

    public void issueBook(int bookId, int userId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if(!book.isAvailable()){
            System.out.println("book already  issued");
            return;
        }

        user.getIssuedBooks().add(book);
        book.setAvailable(false);
        System.out.println("book issued succesfully");

    }
    public void returnBook(int bookId, int userId){
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if(!user.getIssuedBooks().contains(book)){
            System.out.println("user was not issued that book ");
            return;
        }

        user.getIssuedBooks().remove(book);
        book.setAvailable(true);
    }
}

public class Task3 {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book(1, "Book1", "Author1");
        Book b2 = new Book(2, "Book2", "Author2");
        library.addBook(b1);
        library.addBook(b2);

        User u1 = new User(101, "Arfath");
        User u2 = new User(102, "Ahmed");
        library.addUser(u1);
        library.addUser(u2);

        //testing code her
        library.issueBook(1, 101);
        library.issueBook(1, 102);
        library.returnBook(1, 101);
        library.returnBook(1, 101);
        library.issueBook(1, 102);

        //output
        /*
"C:\Program Files\Java\jdk-24\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2025.1\lib\idea_rt.jar=58025" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\arfat\OneDrive\Desktop\internship codes\ElevenLabsInternship\target\classes" com.arfath.elevenlabs.Task3
book issued succesfully
book already  issued
user was not issued that book
book issued succesfully
*/

    }
}
