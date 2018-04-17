package chapter2.dozer.dozer_2;

import lombok.ToString;

@ToString
public class TargetBean {

    private String pk;

    private String name;

    private String binaryData;

    public void setPk(String pk) {

        this.pk = pk;

    }

    public String getPk() {
        return pk;
    }

    public String getName() {
        return name;
    }

    public String getBinaryData() {
        return binaryData;
    }

    public TargetBean setBinaryData(String binaryData) {
        this.binaryData = binaryData;
        return this;
    }

    public void setName(String name) {

        this.name = name;

    }

}