package se.lexicon.spring5webapp.DAO;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring5webapp.model.Author;

public interface IAuthorDAO extends CrudRepository<Author,Long> {
}
