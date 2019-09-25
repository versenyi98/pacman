package Java.UI.Model;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Pacman extends Entity {
    private double velocityX;
    private double velocityY;
    private SnapshotParameters params;
    private int rotation;

    public Pacman(int id) {
        super(id);
        velocityX = 0;
        velocityY = 0;
        params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        rotation = 0;
    }

    public void update() {
        positionX += velocityX;
        positionY += velocityY;
    }

    public Image rotateImg() {
        ImageView iv = new ImageView(getImage());
        iv.setRotate(rotation);
        return iv.snapshot(params, null);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage( rotateImg(), positionX, positionY );
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public double getVelocityX() { return velocityX; }
    public double getVelocityY() { return velocityY; }
    public  void  setVelocity(double velocityX, double velocityY) {
        this.velocityX = velocityX;
        this.velocityY= velocityY;
    }
}
