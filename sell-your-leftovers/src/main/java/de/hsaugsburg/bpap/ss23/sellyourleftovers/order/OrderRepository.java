package de.hsaugsburg.bpap.ss23.sellyourleftovers.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
