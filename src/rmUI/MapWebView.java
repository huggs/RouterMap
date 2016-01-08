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
public class MapWebView extends javafx.application.Application {
    
    private javafx.scene.Scene mapScene;
    
    @Override public void start(javafx.stage.Stage stage) {
        // create the scene
        mapScene = new javafx.scene.Scene(new MapBrowser(MapWindow.MAP_PAGE_ADDRESS),MapWindow.MIN_MAP_WIDTH,MapWindow.MIN_MAP_HEIGHT, javafx.scene.paint.Color.web("#666970"));
        System.out.println(mapScene.);
       
        stage.setScene(mapScene);
        stage.show();
    }
    
    
}
