package sapient.hiring;

public class Bot {
    private Point currentPoint;
    private Point destination;


    private MOVE_TYPE lastMoveType;

    private enum MOVE_TYPE {
        NONE, TYPE1, TYPE2
    }

    public Bot(Point startPoint, Point destination) {
        this.currentPoint = startPoint;
        this.destination = destination;
        lastMoveType = MOVE_TYPE.NONE;
    }

    public void move() {
        if(reached() || !isValid())
            throw new RuntimeException("operation no more valid");
        if(lastMoveType.equals(MOVE_TYPE.TYPE1)){
            System.out.println("Bot is making move type 2");
            makeType2Move();
        }else if(lastMoveType.equals(MOVE_TYPE.TYPE2)){
            System.out.println("Bot is making move type 1");
            makeType1Move();
        }else {
            System.out.println("Bot is starting so make move type 1");
            makeType1Move();
        }
        System.out.println("Bot is at "+ currentPoint);
    }

    private void makeType1Move() {
        Point nextPoint = new Point(currentPoint.getXcordinate()+currentPoint.getYcordinate(), currentPoint.getYcordinate());
        currentPoint = nextPoint;
        lastMoveType = MOVE_TYPE.TYPE1;
    }

    private void makeType2Move() {
        Point nextPoint = new Point(currentPoint.getXcordinate(), currentPoint.getYcordinate()+currentPoint.getXcordinate());
        currentPoint = nextPoint;
        lastMoveType = MOVE_TYPE.TYPE2;
    }

    public boolean isValid() {
        return currentPoint.getXcordinate() <= destination.getXcordinate() && currentPoint.getYcordinate()<= destination.getYcordinate();
    }

    public boolean reached(){
        return currentPoint.equals(destination);
    }


}
