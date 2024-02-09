package ir.resuinventory.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "user_table")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_table_SEQ")
    @SequenceGenerator(
            name = "user_table_SEQ",
            sequenceName = "user_table_SEQ",
            allocationSize = 1)
    private long userId;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    private String email;

    private boolean emailActive;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public int hashCode(String password) {
        return Arrays.hashCode(password.getBytes());
    }

    public User setUsername(String username) {
        this.username = username.toLowerCase();
        return this;
    }

    public User setPassword(String password) {
        this.password = String.valueOf(hashCode(password));
        return this;
    }

    public User setEmail(String email) {
        this.email = email.toLowerCase();
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
