package de.hsaugsburg.bpap.ss23.sellyourleftovers.repository;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
