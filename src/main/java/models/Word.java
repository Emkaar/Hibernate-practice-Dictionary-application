package models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "dictionary_id", foreignKey = @ForeignKey(name = "DICTIONARY_ID_FK"))
    private Dictionary dictionary;
    private String original;
    private String translate;
    @Column(name = "learning_index")
    private int learnIndex;
}
