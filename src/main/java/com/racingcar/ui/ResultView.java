package com.racingcar.ui;

public class ResultView {
//    public void printResults(Cars cars, int times) {
//        printEmptyLine();
//        System.out.println("실행 결과");
//        for (int i = 0; i <times; i++) {
//            printEmptyLine();
//            cars.allMoveForward();
//            printCarsLocationResult(cars);
//        }
//        printWinners(cars);
//    }
//
//    private void printWinners(Cars cars) {
//        List<Car> winners = cars.getWinner();
//        for (int i = 0; i < winners.size(); i++) {
//            System.out.print(winners.get(i).getCarName());
//            if(i != winners.size() -1) {
//                System.out.print(",");
//            }
//        }
//        System.out.println(" 가 최종 우승했습니다.");
//    }
//
//    private void printCarsLocationResult(Cars cars) {
//        cars.getCarList().forEach(this::printCartLocation);
//    }
//
//    private void printCartLocation(Car car) {
//        System.out.printf("[%-5s]",car.getCarName());
//        System.out.print(" : ");
//        for (int i = 0; i < car.getLocation(); i++) {
//            System.out.print("-");
//        }
//        printEmptyLine();
//    }

    private void printEmptyLine() {
        System.out.println();
    }
}
