package transacao.entities.transaction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import transacao.entities.transaction.entities.Transaction;
import transacao.entities.transaction.repositories.TransactionRepository;
import transacao.entities.transaction.responses.TransactionRes;

@RestController
@RequestMapping("/api/transactions")
public class GetTransactions {

    @Autowired
    private TransactionRepository repository;

    @GetMapping("/{idCard}")
    public ResponseEntity<?> getTransactionsByCard(@PathVariable String idCard,
                                                   @PageableDefault(page = 0, size = 10, sort = "id",
                                                           direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Transaction> transactionPage = repository.findAllByCardId(idCard, pageable);
        if (transactionPage.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transactionPage.map(TransactionRes::new));
    }

}