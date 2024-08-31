public class Cub {
    public enum SideNumber {
        up,
        left,
        front,
        right,
        back,
        down;
    }
    StringBuilder solver = new StringBuilder();

    Side[] sides = new Side[6];

    Cub() {
        for (int i = 0; i < sides.length; i++) {
          //  sides[i] = new Side(true);
            sides[i] = new Side(i);
        }
    }
    Cub(Cub cub) {
        for (int i = 0; i < sides.length; i++) {
            sides[i] = new Side(cub.sides[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder[] builder = new StringBuilder[9];
        for (int i = 0; i < builder.length; i++) {
            builder[i] = new StringBuilder();
        }
        for (int i = 0; i < 3; i++) {
            if (builder[i].isEmpty()) {
                builder[i].append(" ".repeat(9*3));
            }
            for (int j = 1; j < 4; j++) {

                builder[i].append(String.format("%9s"," "+(j + i * 3)+Side.Color.values()[ sides[SideNumber.up.ordinal()].cell[j + i * 3]]));
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 4; k++) {
                    builder[i].append(String.format("%9s"," "+(k + (i - 3) * 3)+Side.Color.values()[ sides[j].cell[k + (i - 3) * 3]]));
                }
            }
        }
        for (int i = 6; i < 9; i++) {
            if (builder[i].isEmpty()) {
                builder[i].append(" ".repeat(9*3));
            }
            for (int j = 1; j < 4; j++) {

                builder[i].append(String.format("%9s", " "+(j + (i - 6) * 3)+Side.Color.values()[(sides[SideNumber.down.ordinal()].cell[j + (i - 6) * 3])]));
            }
        }

        return "\n"+String.join("\n", builder)+"\n";
    }


    void r() {
        sides[SideNumber.right.ordinal()].rotation();
        int temp1 = sides[SideNumber.up.ordinal()].cell[3];
        int temp2 = sides[SideNumber.up.ordinal()].cell[6];
        int temp3 = sides[SideNumber.up.ordinal()].cell[9];

        rotate(sides[SideNumber.up.ordinal()], sides[SideNumber.front.ordinal()],3,6,9,3,6,9);
        rotate(sides[SideNumber.front.ordinal()], sides[SideNumber.down.ordinal()],3,6,9,3,6,9);
        rotate(sides[SideNumber.down.ordinal()], sides[SideNumber.back.ordinal()],3,6,9,7,4,1);


        sides[SideNumber.back.ordinal()].cell[1] = temp3;
        sides[SideNumber.back.ordinal()].cell[4] = temp2;
        sides[SideNumber.back.ordinal()].cell[7] = temp1;
        solver.append("r");
    }

    void l() {
        sides[SideNumber.left.ordinal()].rotation();
        int temp1 = sides[SideNumber.up.ordinal()].cell[1];
        int temp2 = sides[SideNumber.up.ordinal()].cell[4];
        int temp3 = sides[SideNumber.up.ordinal()].cell[7];
        rotate(sides[SideNumber.up.ordinal()], sides[SideNumber.back.ordinal()],7,4,1,3,6,9);
        rotate(sides[SideNumber.back.ordinal()], sides[SideNumber.down.ordinal()],3,6,9,7,4,1);
       rotate(sides[SideNumber.down.ordinal()], sides[SideNumber.front.ordinal()],1,4,7,1,4,7);
        sides[SideNumber.front.ordinal()].cell[1] = temp1;
        sides[SideNumber.front.ordinal()].cell[4] = temp2;
        sides[SideNumber.front.ordinal()].cell[7] = temp3;
        solver.append("l");
    }

    void u() {
        sides[SideNumber.up.ordinal()].rotation();
        int temp1 = sides[SideNumber.front.ordinal()].cell[1];
        int temp2 = sides[SideNumber.front.ordinal()].cell[2];
        int temp3 = sides[SideNumber.front.ordinal()].cell[3];
        rotate(sides[SideNumber.front.ordinal()], sides[SideNumber.right.ordinal()],1,2,3,1,2,3);
        rotate(sides[SideNumber.right.ordinal()], sides[SideNumber.back.ordinal()],1,2,3,1,2,3);
        rotate(sides[SideNumber.back.ordinal()], sides[SideNumber.left.ordinal()],1,2,3,1,2,3);
        sides[SideNumber.left.ordinal()].cell[1] = temp1;
        sides[SideNumber.left.ordinal()].cell[2] = temp2;
        sides[SideNumber.left.ordinal()].cell[3] = temp3;
        solver.append("u");

    }

    void d() {
        sides[SideNumber.down.ordinal()].rotation();
        int temp1 = sides[SideNumber.front.ordinal()].cell[7];
        int temp2 = sides[SideNumber.front.ordinal()].cell[8];
        int temp3 = sides[SideNumber.front.ordinal()].cell[9];
        rotate(sides[SideNumber.front.ordinal()], sides[SideNumber.left.ordinal()],7,8,9,7,8,9);
        rotate(sides[SideNumber.left.ordinal()], sides[SideNumber.back.ordinal()],7,8,9,7,8,9);
        rotate(sides[SideNumber.back.ordinal()], sides[SideNumber.right.ordinal()],7,8,9,7,8,9);
        sides[SideNumber.right.ordinal()].cell[7] = temp1;
        sides[SideNumber.right.ordinal()].cell[8] = temp2;
        sides[SideNumber.right.ordinal()].cell[9] = temp3;
        solver.append("d");
    }

    void f() {
        sides[SideNumber.front.ordinal()].rotation();
        int temp1 = sides[SideNumber.up.ordinal()].cell[7];
        int temp2 = sides[SideNumber.up.ordinal()].cell[8];
        int temp3 = sides[SideNumber.up.ordinal()].cell[9];
        rotate(sides[SideNumber.up.ordinal()], sides[SideNumber.left.ordinal()],7,8,9,9,6,3);
        rotate(sides[SideNumber.left.ordinal()], sides[SideNumber.down.ordinal()],3,6,9,1,2,3);
        rotate(sides[SideNumber.down.ordinal()], sides[SideNumber.right.ordinal()],1,2,3,7,4,1);
        sides[SideNumber.right.ordinal()].cell[1] = temp1;
        sides[SideNumber.right.ordinal()].cell[4] = temp2;
        sides[SideNumber.right.ordinal()].cell[7] = temp3;
        solver.append("f");
    }

    void b() {
        sides[SideNumber.back.ordinal()].rotation();
        int temp1 = sides[SideNumber.up.ordinal()].cell[1];
        int temp2 = sides[SideNumber.up.ordinal()].cell[2];
        int temp3 = sides[SideNumber.up.ordinal()].cell[3];
        rotate(sides[SideNumber.up.ordinal()], sides[SideNumber.right.ordinal()],1,2,3,3,6,9);
        rotate(sides[SideNumber.right.ordinal()], sides[SideNumber.down.ordinal()],3,6,9,9,8,7);
        rotate(sides[SideNumber.down.ordinal()], sides[SideNumber.left.ordinal()],7,8,9,1,4,7);
        sides[SideNumber.left.ordinal()].cell[7] = temp1;
        sides[SideNumber.left.ordinal()].cell[4] = temp2;
        sides[SideNumber.left.ordinal()].cell[1] = temp3;
        solver.append("b");
    }
    void rI(){
        r();
        r();
        r();
    }

    void lI(){
        l();
        l();
        l();
    }

    void uI(){
        u();
        u();
        u();
    }
    void dI(){
        d();
        d();
        d();
    }
    void fI(){
        f();
        f();
        f();
    }
    void bI(){
        b();
        b();
        b();
    }


    void rotate(Side s1, Side s2,int i1, int i2,int i3, int j1, int j2, int j3) {
        s1.cell[i1] = s2.cell[j1];
        s1.cell[i2] = s2.cell[j2];
        s1.cell[i3] = s2.cell[j3];
    }

}
