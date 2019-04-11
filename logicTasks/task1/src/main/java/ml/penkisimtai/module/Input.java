package ml.penkisimtai.module;

import javax.persistence.*;

@Entity
@Table(name = "input")
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Long getId() {
        return id;
    }

    public Input(String input) {
        this.input = input;
    }

    public Input() {
    }

    public void setId(Long id) {
        this.id = id;
    }
}
