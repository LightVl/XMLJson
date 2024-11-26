package org.example.models.screen;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class D {
    @XmlAttribute(name = "Color")
    private String color;
    @XmlValue
    private String d;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("            <D Color='");
        sb.append((this.color == null) ? "null" : this.color);
        sb.append("'>");
        sb.append((this.d == null) ? "null" : this.d);
        sb.append("</D> \n");
        return sb.toString();
    }
}