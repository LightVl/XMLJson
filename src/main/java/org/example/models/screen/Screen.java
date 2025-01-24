package org.example.models.screen;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name = "Screen")
@XmlAccessorType(XmlAccessType.FIELD)
public class Screen {
    @XmlAttribute(name = "Stage")
    private String stage;
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Description")
    private String description;

    @XmlElementWrapper(name="Buttons")
    @XmlElement(name="Button")
    private List<Button> buttonList = new ArrayList<>();

    @XmlElementWrapper(name="Attributes")
    @XmlElement(name="Attribute")
    private List<Attribute> attributeList  = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Screen Stage='");
        sb.append((this.stage == null) ? "null" : this.stage);
        sb.append("'> \n");
        sb.append("    <Title>");
        sb.append((this.title == null) ? "null" : this.title);
        sb.append("</Title> \n");
        sb.append("    <Description>");
        sb.append((this.description == null) ? "null" : this.description);
        sb.append("</Description> \n");
        sb.append("    <Buttons> \n");
        for(Button button : buttonList) {
            sb.append(button);
        }
        sb.append("    </Buttons> \n");
        sb.append("    <Attributes> \n");
        for(Attribute attribute : attributeList) {
            sb.append(attribute);
        }
        sb.append("    </Attributes> \n");
        sb.append("</Screen");
        return sb.toString();
    }
}