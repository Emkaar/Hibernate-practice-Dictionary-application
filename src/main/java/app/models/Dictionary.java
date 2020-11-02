package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "user_id",
            foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;

    @Column(name = "learning_lang")
    private String learningLanguage;

    @OneToMany(mappedBy = "dictionary", fetch = FetchType.EAGER)
    List<Word> wordList = new ArrayList<>();


    public Dictionary(String learningLanguage){
        this.learningLanguage = learningLanguage;
    }
}
