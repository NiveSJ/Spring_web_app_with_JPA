package se.lexicon.spring5webapp.DAO;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring5webapp.model.Book;

public interface IBookDAO extends CrudRepository<Book, Long> {
}
