//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Point start1 = new Point(1, 1);
        Point end1 = new Point(5, 5);
        Line line1 = new Line(start1, end1);

        Point start2 = new Point(1,2);
        Point end2 = new Point(7,2);
        Line line2 = new Line(start2,end2);

        //if (line1.isIntersecting(line2)) {
            //System.out.println(true);
            System.out.println(line1.intersectionWith(line2));
       // }




        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}