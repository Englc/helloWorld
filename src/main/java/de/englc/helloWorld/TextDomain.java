package de.englc.helloWorld;

import org.springframework.stereotype.Service;

@Service
public class TextDomain {

    public String get() {
        return "This is some text";
    }



	/*

@Repository
public interface DomainRepository extends JpaRepository<Domain, String> {
    Optional<Domain> findById(Long id);
    Optional<Domain> findByIdNot(Long id);

    List<Domain> findByIdIn(List<Long> id);
    List<Domain> findByIdAndTextIn(Long id, String text);



}


	 */
}
