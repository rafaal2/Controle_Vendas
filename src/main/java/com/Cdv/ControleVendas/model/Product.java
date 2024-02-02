package com.Cdv.ControleVendas.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @Column(name = "first_name", nullable = false, length = 80)
    private String name;
    @Column(name = "last_name", nullable = false, length = 80)
    private long price;
    @Column(nullable = false, length = 80)
    private long quantity;
    @Column( length = 80)
    private Date timestamp;

}
