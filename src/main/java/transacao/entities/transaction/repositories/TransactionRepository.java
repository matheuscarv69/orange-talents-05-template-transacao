package transacao.entities.transaction.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import transacao.entities.transaction.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {


    Page<Transaction> findAllByCardId(String idCard, Pageable pageable);

}
