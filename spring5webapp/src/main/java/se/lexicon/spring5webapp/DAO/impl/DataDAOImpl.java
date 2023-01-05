package se.lexicon.spring5webapp.DAO.impl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.spring5webapp.DAO.IAuthorDAO;
import se.lexicon.spring5webapp.DAO.IBookDAO;
import se.lexicon.spring5webapp.DAO.IPublisherDAO;
import se.lexicon.spring5webapp.model.Author;
import se.lexicon.spring5webapp.model.Book;
import se.lexicon.spring5webapp.model.Publisher;

@Component
public class DataDAOImpl implements CommandLineRunner {

    private final IAuthorDAO authorDAO;
    private final IBookDAO bookDAO;
    private final IPublisherDAO publisherDAO;

    public DataDAOImpl(IAuthorDAO authorDAO, IBookDAO bookDAO, IPublisherDAO publisherDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
        this.publisherDAO = publisherDAO;
    }

    @Override
    public void run(String... args) throws Exception {

        // Creating publisher
        Publisher publisher = new Publisher("Gothenburg", "Graham press", "41808",
                "Vastra gothenburg Lan", "Tandvedersgatan 31");

        Publisher publisher1 = new Publisher("Gothenburg", "Aruba press", "41808",
                "Vastra gothenburg Lan", "OstraGatan 31");

        // Saved to H2 database
        publisherDAO.save(publisher);
        publisherDAO.save(publisher1);

        System.out.println("Publisher count : " + publisherDAO.count());

        // Creating Book and Authour objects

        Author Abraham = new Author("Silberschatz", "Abraham");
        Book os = new Book("Operating system", "12354");

        //Set Authors to book and Book to Authors
        Abraham.getBooks().add(os);
        os.getAuthors().add(Abraham);
        os.setPublisher(publisher);

        Author John = new Author("John", "Beck");
        Book SS = new Book("System Software: An Introduction To Systems Programming",
                "12367");

        John.getBooks().add(SS);
        SS.getAuthors().add(John);
        SS.setPublisher(publisher1);

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
