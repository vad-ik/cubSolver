import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CubSolver1layer solver1 = new CubSolver1layer();
        CubSolver2layer solver2 = new CubSolver2layer();
        CubSolver3layer solver3 = new CubSolver3layer();
        Solver solver = new Solver();
        Cub cub = new Cub();
        //  System.out.println(cub);
        //cub.r();
        long timer = 0;
        long time;
        for (int i = 0; i < 1000; i++) {


            cubСonfuse(cub);
            time = System.nanoTime();
//        System.out.println();
//        System.out.println(cub.toString());

            solver.solve(cub);
            timer = System.nanoTime() - time;
            time = System.nanoTime();

            chesk(cub);
        }
        System.out.println();
        System.out.println(cub);
        System.out.println(timer / 1000);
        //  System.out.println(cub.solver.toString());
    }

    static void chesk(Cub cub) {
        for (int i = 0; i < 6; i++) {
            chesk(cub.sides[i]);
        }
    }

    static void chesk(Side side) {
        int col = side.cell[1];
        for (int i = 1; i < 10; i++) {
            if (side.cell[i] != col) {
                System.out.println("Allarm");
            }
        }
    }

    static void cubСonfuse(Cub cub) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {

            // System.out.println(cub.toString()+"\n\n");
            int a = random.nextInt(6);
            switch (a) {
                case 0:
                    cub.u();
                    break;
                case 1:
                    cub.d();
                    break;
                case 2:
                    cub.l();
                    break;
                case 3:
                    cub.r();
                    break;
                case 4:
                    cub.f();
                    break;
                case 5:
                    cub.b();
                    break;
            }

        }
        cub.solver = new StringBuilder();
    }

}