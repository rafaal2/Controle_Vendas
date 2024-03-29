package com.Cdv.ControleVendas.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "product")

public class Product implements Serializable {
@Serial
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long code;
@Column(name = "name", nullable = false, length = 80)
private String name;
@Column(name = "price", nullable = false, length = 80)
private double price;
@Column(nullable = false, length = 80)
private long quantity;
@Column( length = 80)
private Date timestamp = new Date();

}
