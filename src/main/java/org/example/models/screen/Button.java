package org.example.models.screen;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Button {
    @XmlAttribute(name = "Action")
    private String action;
    @XmlAttribute(name = "Color")
    private String color;
    @XmlAttribute(name = "Condition")
    private String condition;
    @XmlElement(name = "T")
    private String t;
    @XmlElement(name = "D")
    private List<D> dList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("        <Button Action='");
        sb.append((this.action == null) ? "null" : this.action);
        sb.append("' Color='");
        sb.append((this.color == null) ? "null" : this.color);
        sb.append("' Condition='");
        sb.append((this.condition == null) ? "null" : this.condition);
        sb.append("'> \n");
        sb.append("            <T>");
        sb.append((this.t == null) ? "null" : this.t);
        sb.append("</T> \n");
        for (D d : dList) {
            sb.append(d);
        }
        sb.append("        </Button> \n");
        return sb.toString();
    }

}
