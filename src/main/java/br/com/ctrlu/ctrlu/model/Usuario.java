package br.com.ctrlu.ctrlu.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Getter
@Setter
@Document(createIndex =true, indexName = "usuario", type = "usuario",shards = 1)
public class Usuario {

    private Long id;

    @MultiField(
            mainField = @Field(type = Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "innerNome", type = Keyword)
            }
    )
    private String nome;

    public Usuario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Usuario() {
    }
}
