package closestPair;

import java.util.*;

/** Implementation of Shamos's Algorithm. */
public class StudentCode {

    /** Find the square distance of the closest pairs in the point set.
     *  This static function is the preparation step for the recursive part of
     *  the algorithm defined in the method closestPairAux.
     *
     *  @param P    A set of points in which a closest pair is to be found
     *  @return     The closest distance between two points in set P
     *  @throws TrivialClosestPairException     Number of points is less than 2
     *  @throws UnknownSortOptionException      The sorting criteria is unknown
     */
    public static int closestPair(PointSet P)
            throws TrivialClosestPairException, UnknownSortOptionException {
        if(P.size() < 2){
            throw new TrivialClosestPairException();
        }
        Point[] X = P.sort('x');
        Point[] Y = P.sort('y');
        return closestPairAux(X,Y);
    }

    /** The recursive part of Shamos's Algorithm. The parameter X is an array of
     *  points sorted by the X axis and the parameter Y is the same array of
     *  points sorted by the Y axis. The burden of work is going on here.
     *  Good luck!
     *
     *  @param X     An array of points sorted by X, breaking ties using Y
     *  @param Y     An array of points sorted by Y, breaking ties using X
     *  @return      The closest distance between two points in set X
     *  @throws TrivialClosestPairException     Number of points is less than 2
     *  @throws UnknownSortOptionException      The sorting criteria is unknown
     */
    public static int closestPairAux(Point[] X, Point[] Y)
            throws TrivialClosestPairException, UnknownSortOptionException {
        int size = X.length;

        if(size < 2){
            throw new TrivialClosestPairException();
        } else if(size <= 3){
            PointSet P = new PointSet(X);
            return PointSet.naiveClosestPair(P);
        }

        int middleIndex = (int)Math.ceil(size/2);
        Point[] Xl = Arrays.copyOfRange(X, 0, middleIndex);
        Point[] Xr = Arrays.copyOfRange(X,middleIndex, size);
        Point[] Yl = new Point[Xl.length];
        Point[] Yr = new Point[Xr.length];
        Point decidingPoint = Xl[middleIndex - 1];
        splitY(decidingPoint, Y, Yl, Yr);

        int delta1 = closestPairAux(Xl, Yl);
        int delta2 = closestPairAux(Xr, Yr);
        int sqrDelta = Math.min(delta1, delta2);

        int lineXCoordinate = X[middleIndex].getX();
        Point[] Yv = figureOutStrip(Y, lineXCoordinate, sqrDelta);

        sqrDelta = walkStrip(Yv, sqrDelta);

        return sqrDelta;
    }

    /** Filters the array Y by eliminating all point that are further away than square delta distance
     * from the central vertical line and moves them into a new array Yv.
     *
     * @param Y     An array of points sorted by their Y coordinates
     * @param lineXCoordinate   X coordinate of the central line splitting the point set into two
     * @param sqrDelta          Squared smallest distance between two points
     * @return      An array of points in a strip of width 2 times sqrDelta distance from the line.
     */
    private static Point[] figureOutStrip(Point[] Y, int lineXCoordinate, int sqrDelta) {
        ArrayList<Point> Yv = new ArrayList<>();

            for(Point p : Y){
                int distance = (int)Math.pow((lineXCoordinate - p.getX()), 2);
                if(distance <= sqrDelta){
                    Yv.add(p);
                }
            }

        Point[] result = new Point[Yv.size()];
        Yv.toArray(result);
        return result;
    }

    /** Finds new smallest distance in the strip by finding the distance between a point and the next 5 points sorted
     * by Y coordinates. If no smallest distance is found it returns null.
     *
     * @param Yv         An array of points in the strip
     * @param delta     Current smallest squared distance between two points
     * @return          New smallest distance or null if no smallest distance is found
     * @throws  TrivialClosestPairException     Number of points is less than 2
     */
    private static int walkStrip(Point[] Yv, int delta) throws TrivialClosestPairException {
        int size = Yv.length;
        if(size < 2){
            return delta;
        }

        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < i + 5 && j < size; j++){
                int tempDistance = Yv[i].sqrDist(Yv[j]);

                if(tempDistance < delta){
                    delta = tempDistance;
                }
            }
        }
        return delta;
    }

    /** Create arrays YL and YR that contain points of Y to the left and to the
     *  right of testPoint respectively.
     *
     * @param testPoint     The deciding point (XL, YL)
     * @param Y             All points at the current level of recursion
     * @param YL            An output parameter for the YL array
     * @param YR            An output parameter for the YR array
    */
    public static void splitY(Point testPoint, Point [] Y, Point [] YL, Point [] YR) {
        int indexLeft = 0;
        int indexRight = 0;

        for(Point p : Y){
            switch(p.compareToByX(testPoint)){
                case -1:
                case 0: {
                    YL[indexLeft] = p;
                    indexLeft++;
                    break;
                }
                case 1: {
                    YR[indexRight] = p;
                    indexRight++;
                    break;
                }
            }
        }
    }
}
