package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NaturalId
    private String login;

    private String password;
    @NaturalId
    private String email;
    @Column(name = "native_lang")
    private String nativeLang;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dictionary> dictionaries;

    public User(String login, String password, String email, String nativeLang) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.nativeLang = nativeLang;
    }
}