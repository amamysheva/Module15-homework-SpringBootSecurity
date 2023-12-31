package springbootsecurity.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springbootsecurity.model.entity.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
