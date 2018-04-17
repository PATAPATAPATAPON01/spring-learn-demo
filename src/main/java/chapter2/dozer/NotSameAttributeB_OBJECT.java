package chapter2.dozer;

import com.google.common.base.MoreObjects;

public class NotSameAttributeB_OBJECT {
    private String id;
    private String value;
    private String date;

    private String[] list;

    public String[] getList() {
        return list;
    }

    public NotSameAttributeB_OBJECT setList(String[] list) {
        this.list = list;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("value", value)
                .add("date", date)
                .omitNullValues()
                .toString();
    }

    public String getId() {
        return id;
    }

    public NotSameAttributeB_OBJECT setId(String id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public NotSameAttributeB_OBJECT setValue(String value) {
        this.value = value;
        return this;
    }

    public String getDate() {
        return date;
    }

    public NotSameAttributeB_OBJECT setDate(String date) {
        this.date = date;
        return this;
    }
// 省略getter/setter
}