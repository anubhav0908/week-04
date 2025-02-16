package reflection.intermediatelevel;

// Apply the @Author annotation to the Book class
@Author(name = "Om Prakash")
public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println("Book Title: " + title);
    }
}

