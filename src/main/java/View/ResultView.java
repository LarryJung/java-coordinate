package View;

import Controller.Calculator;
import Model.Board;
import Model.Figure;
import Model.Point;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printBoard(Calculator controller) {
        Figure figure = controller.getFigure();
        for (int y = 23; y >= 0; y--) {
            print(drawYaxis(y));
            print(drawLine(y, figure));
            System.out.println();
        }
        drawXaxis();
    }

    private static void print(String string) {
        System.out.print(string);
    }

    static String drawYaxis(int y) {
        if ((y + 1) % 2 == 0) return String.format("%6d", y + 1) + "|";
        return "      |";
    }

    static String drawPoint(int x, int y, Figure figure) {
        if (figure.isAtCoordinate(x, y)) return Point.of(x, y).toString();
        return "  ";
    }

    // yet not perfect logic
    static String drawLine(int y, Figure figure) {
        return IntStream.range(0, 24).mapToObj(i -> drawPoint(i, y, figure)).collect(Collectors.joining(""));
    }

    static String drawXaxisLine() {
        return IntStream.range(0, 24).mapToObj(i -> "--").collect(Collectors.joining(""));
    }

    static String drawXaxisNumber() {
        return IntStream.range(0, 13).mapToObj(i -> String.format("%4d", 2 * i)).collect(Collectors.joining(""));
    }

    private static void drawXaxis() {
        print("      " + drawXaxisLine());
        System.out.println();
        print("    " + drawXaxisNumber());
    }

//    public static void printCalculationResult(Calculator calculator) {
//        System.out.println();
//        System.out.println();
//        print("두 점 사이의 거리는 " + calculator.getFigureArea());
//    }
}
