public class Solver {
    CubSolver1layer solver1 = new CubSolver1layer();
CubSolver2layer solver2 = new CubSolver2layer();
CubSolver3layer solver3 = new CubSolver3layer();
    public void solve(Cub cub)  {

        solver1.collectFirstLayer(cub);
        solver2.collectSecondLayer(cub);
        solver3.collectThirdLayer(cub);
    }
}
//cub=new Cub(paste)
//solver1.collectFirstLayer(cub)
//System.out.println(cub)
//        solver2.collectSecondLayer(cub)
//System.out.println(cub)
//        solver3.collectThirdLayer(cub)