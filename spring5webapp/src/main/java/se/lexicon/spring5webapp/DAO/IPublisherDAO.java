package se.lexicon.spring5webapp.DAO;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring5webapp.model.Publisher;

public interface IPublisherDAO extends CrudRepository<Publisher, Long> {
}
