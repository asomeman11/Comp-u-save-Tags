package com.compusave.tags;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class TechFile {

    private static final String FILENAME = "res/Users.xml";

    private static String[][] users2;
    public static String[][] getTechs(){
        return users2;
    }

    TechFile(){

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element : =" + doc.getDocumentElement().getNodeName());
            System.out.println("-------");

            NodeList list = doc.getElementsByTagName("user");

            users2 = new String[list.getLength()][3];

            for (int temp = 0; temp < list.getLength(); temp++){
                Node node = list.item(temp);



                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String adminlvl = element.getElementsByTagName("adminlvl").item(0).getTextContent();
                    String password = element.getElementsByTagName("password").item(0).getTextContent();


                    users2[temp][0] = name;
                    users2[temp][1] = adminlvl;
                    users2[temp][2] = password;

                    /*
                    //System.out.println("Current Element : " + node.getNodeName());
                    System.out.println("Name : " + name);
                    System.out.println("Admin Level : " + adminlvl);
                    System.out.println("Password : " + password);
                    System.out.println("");
                     */

                    System.out.println();

                    System.out.println(temp);

                    for(int x = 0; x < 3; x++){
                        System.out.println(users2[temp][x]);
                    }

                    System.out.println(users2[0][0]);


                    //System.out.println(user.getName() + user.getAdminlvl() + users1[temp]);
                }
            }

            /**
             User user = users.get(3);
             System.out.println(User.getName());
             User.getAdminlvl();
             **/

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


    }



}
