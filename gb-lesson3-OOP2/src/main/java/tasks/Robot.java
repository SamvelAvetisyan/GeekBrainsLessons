package tasks;

public class Robot implements Runnable, Jumping {
    private String name;
    private int maxHeight;
    private int maxLength;

    public Robot(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.getHeight()>this.maxHeight){
            System.out.println(name + " can not jump this wall with height " + wall.getHeight()
                    + ", "  + name  + " can not continue the marathon.");
            return false;
        } else {
            System.out.println(name + " can jump this wall with height " + wall.getHeight()
                    + ", "  + name  + " can continue the marathon.");
            return true;
        }

    }

    @Override
    public boolean run(Treadmill treadmill) {
        if (treadmill.getLength()>this.maxLength){
            System.out.println(name + " can not run this treadmill with length " + treadmill.getLength()
                    + ", "  + name  + " can not continue the marathon.");
            return false;
        }
        System.out.println(name + " can run this treadmill with length " + treadmill.getLength()
                + ", "  + name  + " can continue the marathon.");
        return true;
    }

    @Override
    public boolean passObstacle(Obstacle obstacle) {
        if (obstacle instanceof Wall){
            return jump((Wall) obstacle);
        } return run((Treadmill) obstacle);
    }
}
