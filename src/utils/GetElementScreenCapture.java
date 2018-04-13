/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

/**
 *
 * @author Mateus Oliveira
 */
public class GetElementScreenCapture {
    
    
        public static File getScreenCaptureOfElement(WebElement element) throws IOException {
        // get the WrapsDriver of the WebElement
        WrapsDriver wrapsDriver = (WrapsDriver) element;

        // get the entire screenshot from the driver of passed WebElement
        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        // create an instance of buffered image from captured screenshot
        BufferedImage img = ImageIO.read(screen);

        // get the width and height of the WebElement using getSize()
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        // create a rectangle using width and height
        Rectangle rect = new Rectangle(width, height);

        // get the location of WebElement in a Point.
        // this will provide X & Y co-ordinates of the WebElement
        Point p = element.getLocation();
        // create image  for element using its location and size.
        // this will give image data specific to the WebElement
        BufferedImage dest = null;

        dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);

        // write back the image data for element in File object08.684.859/0001-79   P1n@2017
        ImageIO.write(dest, "png", screen);
        BufferedImage saveImage = ImageIO.read(screen);
        ImageIO.write(saveImage, "png", new File("images/captcha.png"));
        // return the File object containing image data
        return screen;
    }
}
