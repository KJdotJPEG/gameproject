package com.company.assets.tilemap;

import com.company.graphics.Sprite;
import com.company.Vector2f;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Tilemanager {

    public static ArrayList<tilemap> tm;

    public Tilemanager() {
        tm = new ArrayList<tilemap>();

    }

    public Tilemanager(String path) {
        tm = new ArrayList<tilemap>();
        addTileMap(path, 64, 64);
    }

    private void addTileMap(String path, int blockwidth, int blockheight) {
    String imagePathTSX;
    String imagePath;

    int width = 0;
    int height = 0;
    int tilewidth;
    int tileheight;
    int tilecount;
    int tilecolumns;
    int layers = 0;
    Sprite sprite;

    String[] data = new String[10];

    try{
        DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderfactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }

        Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("tileset");
        Node node = list.item(0);
        Element eElement = (Element) node;

        imagePathTSX = eElement.getAttribute("source");
        imagePath = imagePathTSX.substring(0,imagePathTSX.length() - 4);
        list = doc.getElementsByTagName("map");
        node = list.item(0);
        eElement = (Element) node;

        tilewidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
        tileheight = Integer.parseInt(eElement.getAttribute("tileheight"));

        sprite = new Sprite("tile/" + imagePath + ".png", tilewidth, tileheight);

        tilecolumns = sprite.getSpriteSheetWidth() / tilewidth;
        tilecount = tilecolumns * (sprite.getSpriteSheetHeight() / tileheight);

        imagePath = eElement.getAttribute("name");
        tilewidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
        tileheight = Integer.parseInt(eElement.getAttribute("tileheight"));
        tilecount = Integer.parseInt(eElement.getAttribute("tilecount"));
        tilecolumns = Integer.parseInt(eElement.getAttribute("columns"));
        sprite = new Sprite("tile/" + imagePath + ".png", tilewidth, tileheight);

        list = doc.getElementsByTagName("layer");
        layers = list.getLength();

        for (int i = 0; i < layers; i++){
            node = list.item(i);
            eElement = (Element) node;
            if (i <= 0) {
                width = Integer.parseInt(eElement.getAttribute("width"));
                height = Integer.parseInt(eElement.getAttribute("height"));
            }

            data[i] = eElement.getElementsByTagName("data") .item(0).getTextContent();

            if (i >= 1){
                tm.add(new TileMapNorm(data[i], sprite, width, height, blockwidth, blockheight, tilecolumns));
            } else {
                tm.add(new TileMapObj(data[i], sprite, width, height, blockwidth, blockheight, tilecolumns));
            }
        }
    } catch(Exception e) {
        System.out.println("did not read tilemap");
    }
}
    public void render(Graphics2D g) {
        for(int i = 0; i < tm.size() ; i++) {
            tm.get(i).render(g);

        }
    }
}

