package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}
