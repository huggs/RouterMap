/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmUI;

/**
 *
 * @author James.MacIsaac
 */
public class MapBrowser extends javafx.scene.layout.Region{
 
    private final javafx.scene.web.WebView mapView;
    private final javafx.scene.web.WebEngine mapViewEngine;
     
    public MapBrowser(String location) {
        mapView = new javafx.scene.web.WebView();
        mapViewEngine = mapView.getEngine();
        //apply the styles
        getStyleClass().add("mapBrowser");
        // load the web page
        mapViewEngine.load(location);
        //add the web view to the scene
        getChildren().add(mapView);
 
    }
    
    private javafx.scene.Node createSpacer() {
        javafx.scene.layout.Region spacer = new javafx.scene.layout.Region();
         javafx.scene.layout.HBox.setHgrow(spacer,  javafx.scene.layout.Priority.ALWAYS);
        return spacer;
    }
 
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(mapView,0,0,w,h,0, javafx.geometry.HPos.CENTER, javafx.geometry.VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double width) {
        return MapWindow.MIN_MAP_WIDTH;
    }
 
    @Override protected double computePrefHeight(double height) {
        return MapWindow.MIN_MAP_HEIGHT;
    }
}
