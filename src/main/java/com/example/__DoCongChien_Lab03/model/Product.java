package com.example.__DoCongChien_Lab03.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRO")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_CAT", referencedColumnName = "ID_CAT")
    private Catelogy category;
    @Column(name = "NAME_PRO", nullable = false)
    private String name;

    private int nums;


    @Column(name = "PRICE", nullable = false)
    private double price;
    @Column(name = "DETAIL")
    private String detail;
    @Column(name = "IMG1")
    private String img1;
    @Column(name = "IMG2")
    private String img2;
    @Column(name = "IMG3")
    private String img3;
    @Column(name = "META")
    private String meta;
    @Column(name = "`ORDER`", nullable = false)
    private int order;
    @Column(name = "LINK")
    private String link;
    @Column(name = "HIDE", nullable = false)
    private boolean hide;
    @OneToMany(mappedBy = "product")
    private Set<CartDetail> cartDetails;
}