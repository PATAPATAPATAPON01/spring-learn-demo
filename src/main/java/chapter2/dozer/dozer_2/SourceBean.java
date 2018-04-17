package chapter2.dozer.dozer_2;

import lombok.ToString;
import org.dozer.Mapping;
@ToString
public class SourceBean {

    private Long id;

    private String name;


    @Mapping("binaryData")
    private String data;

    @Mapping("pk")
    public Long getId() {

        return this.id;

    }

    public SourceBean setId(Long id) {
        this.id = id;
        return this;
    }

    public SourceBean setName(String name) {
        this.name = name;
        return this;
    }

    public SourceBean setData(String data) {
        this.data = data;
        return this;
    }

    public String getName() {

        return this.name;

    }

}