package chapter2.dozer;

import org.dozer.Mapping;

import java.util.Date;
import java.util.List;

public class NotSameAttributeA_OBJECT {
    private long id;

    private String name;
    private Date date;

    private List<String > list;

    public List<String> getList() {
        return list;
    }

    public NotSameAttributeA_OBJECT setList(List<String> list) {
        this.list = list;
        return this;
    }
    // 省略getter/setter

    public NotSameAttributeA_OBJECT(long id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public NotSameAttributeA_OBJECT setId(long id) {
        this.id = id;
        return this;
    }
    @Mapping("value")
    public String getName() {
        return name;
    }

    public NotSameAttributeA_OBJECT setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public NotSameAttributeA_OBJECT setDate(Date date) {
        this.date = date;
        return this;
    }
}