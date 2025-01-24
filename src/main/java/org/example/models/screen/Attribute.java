package org.example.models.screen;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Attribute {
    @XmlAttribute(name = "A")
    private String a;
    @XmlElement(name = "V")
    private String v;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("        <Attribute A='");
        sb.append((this.a == null) ? "null" : this.a);
        sb.append("'> \n");
        sb.append("            <V>");
        sb.append((this.v == null) ? "null" : this.v);
        sb.append("</V> \n");
        sb.append("        </Attribute> \n");
        return sb.toString();
    }
}