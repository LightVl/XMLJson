package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.screen.Screen;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        exampleJaxb();
    }

    public static void exampleJaxb() throws JAXBException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("./body.xml"));
        String body = br.lines().collect(Collectors.joining());
        System.out.println(body);
        System.out.println("конец первого вывода");
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(Screen.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Screen screen = (Screen) unmarshaller.unmarshal(reader);
        System.out.println(screen);
        System.out.println("конец второго вывода");

        StringWriter writer = new StringWriter();
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        screen.setTitle("Изменили заглавие");
        screen.getButtonList().get(0).getDList().get(0).setColor("black");
        screen.getButtonList().get(0).getDList().get(0).setD("Цвет кнопки черный");
        screen.getButtonList().get(1).setT("тратата");
        screen.getAttributeList().get(0).setA("такой вот аттрибут");
        marshaller.marshal(screen, writer);
        System.out.println(writer);
        System.out.println("конец третьего вывода");

        //JSON jackson start
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        File file = new File("employee.json");
        Employee employee = objectMapper.readValue(file, Employee.class);
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getAge());
        String json = objectMapper.writeValueAsString(employee);
        System.out.println(json);
    }
}