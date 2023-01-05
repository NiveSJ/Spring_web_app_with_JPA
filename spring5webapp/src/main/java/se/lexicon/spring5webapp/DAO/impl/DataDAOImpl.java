package se.lexicon.spring5webapp.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.spring5webapp.DAO.IAuthorDAO;
import se.lexicon.spring5webapp.DAO.IBookDAO;
import se.lexicon.spring5webapp.model.Author;
import se.lexicon.spring5webapp.model.Book;

@Component
public class DataDAOImpl implements CommandLineRunner {

    private final IAuthorDAO authorDAO;
    private final IBookDAO bookDAO;

    public DataDAOImpl(IAuthorDAO authorDAO, IBookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Abraham = new Author("Silberschatz", "Abraham");
        Book os = new Book("Operating system", "12354", "Scheme press");
        //Set Authors to book and Book to Authors
        Abraham.getBooks().add(os);
        os.getAuthors().add(Abraham);

        Author John = new Author("John", "Beck");
        Book SS = new Book("System Software: An Introduction To Systems Programming",
                "12367", "Pearson Education");
        John.getBooks().add(SS);
        SS.getAuthors().add(John);
        // Performing Crud Operations

        authorDAO.save(Abraham);
        authorDAO.save(John);
        bookDAO.save(os);
        bookDAO.save(SS);
        System.out.println("In DAO with JPA");
        System.out.println("Number of books added \t" + bookDAO.count());
        System.out.println("Number o authors added \t" + authorDAO.count());


    }
}
