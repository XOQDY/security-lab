package ku.kinkao.repository;

import ku.kinkao.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member,UUID> {

   // SELECT * FROM User WHERE username = ‘username’
   Member findByUsername(String username);
}
