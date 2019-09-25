package Java.UI.Model;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Entity {
    protected double positionX;
    protected double positionY;
    private int id;
    private int blockX;
    private int blockY;
    private double width;
    private double height;
    private Image image;

    public Entity(int id) {
        this.id = id;
        positionX = 0;
        positionY = 0;
    }

    // Position
    public double getPositionX() { return positionX; }
    public double getPositionY() { return positionY; }
    public  void  setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // Scale
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    // Position in the array
    public int  getBlockX() { return blockX; }
    public int  getBlockY() { return blockY; }
    public void setBlockPos(int blockX, int blockY) {
        this.blockX = blockX;
        this.blockY = blockY;
    }

    public int getId() {
        return id;
    }

    // Image
    public void setImage(Image i) {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename) {
        Image i = new Image(filename);
        setImage(i);
    }

    public Image getImage() {
        return image;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage( image, positionX, positionY );
    }

    private Rectangle2D getBoundary() {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Entity s) {
        return s.getBoundary().intersects( this.getBoundary() );
    }
}
