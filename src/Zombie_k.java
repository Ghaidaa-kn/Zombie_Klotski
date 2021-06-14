
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.util.Collections.list;
import static java.util.Collections.sort;


public class Zombie_k {
    static  ArrayList<Zombie_k> saved;

    static char[][] square  = {{'$','*','*','$'},{'$','*','*','$'},{'$','.','.','$'},{'$','$','$','$'},{'$','$','$','$'}};
    static int count;


    boolean is_left(int a , int b){
        if(square[a][b]=='$'){
            if(square[a][b-1]=='.'){
                return true;
            }else
            {
                return false;
            }
        }
        if(square[a][b]=='*' && square[a+1][b]=='*' && square[a][b-1]=='.' && square[a+1][b-1]=='.'
                ||square[a][b]=='*' && square[a+1][b]=='*' && square[a][b-1]=='*' && square[a+1][b-1]=='*'
                &&square[a][b-2]=='.' && square[a+1][b-2]=='.'
                ||square[a][b]=='*' && square[a-1][b]=='*' && square[a][b-1]=='.' && square[a-1][b-1]=='.'
                ||square[a][b]=='*' && square[a-1][b]=='*' && square[a][b-1]=='*' && square[a-1][b-1]=='*'
                &&square[a][b-2]=='.' && square[a-1][b-2]=='.' ){
            return true;
        }else{
            return false;
        }
    }



    boolean is_right(int a , int b){
        if(square[a][b]=='$'){
            if(square[a][b+1]=='.'){
                return true;
            }else
            {
                return false;
            }
        }
        if(square[a][b]=='*' && square[a+1][b]=='*' && square[a][b+1]=='.' && square[a+1][b+1]=='.'
                || square[a][b]=='*' && square[a+1][b]=='*' && square[a][b+1]=='*' && square[a+1][b+1]=='*'
                &&square[a][b+2]=='.' && square[a+1][b+2]=='.'
                || square[a][b]=='*' && square[a-1][b]=='*' && square[a][b+1]=='.' && square[a-1][b+1]=='.'
                || square[a][b]=='*' && square[a-1][b]=='*' && square[a][b+1]=='*' && square[a-1][b+1]=='*'
                &&square[a][b+2]=='.' && square[a-1][b+2]=='.' ){
            return true;
        }else{
            return false;
        }
    }


    boolean is_up(int a , int b){
        if(square[a][b]=='$'){
            if(square[a-1][b]=='.'){
                return true;
            }else
            {
                return false;
            }
        }
        if(square[a][b]=='*' && square[a][b+1]=='*' && square[a-1][b]=='.' && square[a-1][b+1]=='.'
                || square[a][b]=='*' && square[a][b+1]=='*' && square[a-1][b]=='*' && square[a-1][b+1]=='*'
                && square[a-2][b]=='.' && square[a-2][b+1]=='.'
                || square[a][b]=='*' && square[a][b-1]=='*' && square[a-1][b]=='.' && square[a-1][b-1]=='.'
                || square[a][b]=='*' && square[a][b-1]=='*' && square[a-1][b]=='*' && square[a-1][b-1]=='*'
                && square[a-2][b]=='.' && square[a-2][b-1]=='.' ){
            return true;
        }else{
            return false;
        }
    }


    boolean is_down(int a , int b){
        if(square[a][b]=='$'){
            if(square[a+1][b]=='.'){
                return true;
            }else
            {
                return false;
            }
        }
        if(square[a][b]=='*' && square[a][b+1]=='*' && square[a+1][b]=='.' && square[a+1][b+1]=='.'
                || square[a][b]=='*' && square[a][b+1]=='*' && square[a+1][b]=='*' && square[a+1][b+1]=='*' &&
                square[a+2][b]=='.' && square[a+2][b+1]=='.'
                || square[a][b]=='*' && square[a][b-1]=='*' && square[a+1][b]=='.' && square[a+1][b-1]=='.'
                || square[a][b]=='*' && square[a][b-1]=='*' && square[a+1][b]=='*' && square[a+1][b-1]=='*' &&
                square[a+2][b]=='.' && square[a+2][b-1]=='.'){
            return true;
        }else{
            return false;
        }
    }




    void move_left(int a , int b){
        char temp;
        if(is_left(a,b)){

            if(square[a][b]=='*' && square[a+1][b]=='*' && square[a][b-1]=='.' && square[a+1][b-1]=='.'){
                temp =square[a][b+1] ;  square[a][b+1]=square[a][b-1]; square[a][b-1]=temp;
                temp=square[a+1][b+1]; square[a+1][b+1]=square[a+1][b-1]; square[a+1][b-1]=temp;
            }else if(square[a][b]=='*' && square[a+1][b]=='*' && square[a][b-1]=='*' && square[a+1][b-1]=='*'
                    &&square[a][b-2]=='.' && square[a+1][b-2]=='.'){
                temp=square[a][b] ;square[a][b] =square[a][b-2]; square[a][b-2]=temp;
                temp=square[a+1][b]; square[a+1][b]=square[a+1][b-2]; square[a+1][b-2]=temp;
            }else if(square[a][b]=='*' && square[a-1][b]=='*' && square[a][b-1]=='.' && square[a-1][b-1]=='.'){
                temp=square[a][b+1]; square[a][b+1]=square[a][b-1]; square[a][b-1]=temp;
                temp= square[a-1][b+1]; square[a-1][b+1]=square[a-1][b-1]; square[a-1][b-1]=temp;
            }else if(square[a][b]=='*' && square[a-1][b]=='*' && square[a][b-1]=='*' && square[a-1][b-1]=='*'
                    &&square[a][b-2]=='.' && square[a-1][b-2]=='.'){
                temp=square[a][b]; square[a][b]=square[a][b-2]; square[a][b-2]=temp;
                temp=square[a-1][b]; square[a-1][b]=square[a-1][b-2]; square[a-1][b-2]=temp;

            }else if(square[a][b]=='$' && square[a][b-1]=='.'){
                temp = square[a][b];  square[a][b]=square[a][b-1] ; square[a][b-1]=temp;

            }
        }
    }


    void move_right(int a , int b){

        char temp;
        Zombie_k obj = new Zombie_k();

        if(is_right(a,b)){

            if(square[a][b]=='$' && square[a][b+1]=='.'){
                temp = square[a][b] ; square[a][b] = square[a][b+1] ; square[a][b+1] = temp;
                obj.square = square;
            }else if(square[a][b]=='*' && square[a+1][b]=='*' && square[a][b+1]=='.' && square[a+1][b+1]=='.'){
                temp=square[a][b-1]; square[a][b-1]=square[a][b+1]; square[a][b+1]=temp;
                temp=square[a+1][b-1]; square[a+1][b-1]=square[a+1][b+1]; square[a+1][b+1]=temp;
            }else if(square[a][b]=='*' && square[a+1][b]=='*' && square[a][b+1]=='*' && square[a+1][b+1]=='*'
                    &&square[a][b+2]=='.' && square[a+1][b+2]=='.'){
                temp=square[a][b]; square[a][b]=square[a][b+2]; square[a][b+2]=temp;
                temp=square[a+1][b]; square[a+1][b]=square[a+1][b+2]; square[a+1][b+2]=temp;
            }else if(square[a][b]=='*' && square[a-1][b]=='*' && square[a][b+1]=='.' && square[a-1][b+1]=='.'){
                temp=square[a][b-1]; square[a][b-1]=square[a][b+1]; square[a][b+1]=temp;
                temp=square[a-1][b-1]; square[a-1][b-1]=square[a-1][b+1]; square[a-1][b+1]=temp;
            }else if(square[a][b]=='*' && square[a-1][b]=='*' && square[a][b+1]=='*' && square[a-1][b+1]=='*'
                    &&square[a][b+2]=='.' && square[a-1][b+2]=='.'){
                temp=square[a][b]; square[a][b]=square[a][b+2]; square[a][b+2]=temp;
                temp=square[a-1][b]; square[a-1][b]=square[a][b+2]; square[a][b+2]=temp;
            }

        }
    }


    void move_up(int a , int b){
        char temp;

        if(is_up(a,b)){
            if(square[a][b]=='$' && square[a-1][b]=='.'){
                temp=square[a][b]; square[a][b]=square[a-1][b]; square[a-1][b]=temp;
            }else if(square[a][b]=='*' && square[a][b+1]=='*' && square[a-1][b]=='.' && square[a-1][b+1]=='.'){
                temp=square[a+1][b] ; square[a+1][b]=square[a-1][b]; square[a-1][b]=temp;
                temp=square[a+1][b+1]; square[a+1][b+1]=square[a-1][b+1]; square[a-1][b+1]=temp;
            }else if(square[a][b]=='*' && square[a][b+1]=='*' && square[a-1][b]=='*' && square[a-1][b+1]=='*'
                    && square[a-2][b]=='.' && square[a-2][b+1]=='.'){
                temp=square[a][b]; square[a][b]=square[a-2][b]; square[a-2][b]=temp;
                temp=square[a][b+1]; square[a][b+1]=square[a-2][b+1]; square[a-2][b+1]=temp;
            }else if(square[a][b]=='*' && square[a][b-1]=='*' && square[a-1][b]=='.' && square[a-1][b-1]=='.'){
                temp=square[a+1][b]; square[a+1][b]=square[a-1][b]; square[a-1][b]=temp;
                temp=square[a+1][b-1]; square[a+1][b-1]=square[a-1][b-1]; square[a-1][b-1]=temp;
            }else if(square[a][b]=='*' && square[a][b-1]=='*' && square[a-1][b]=='*' && square[a-1][b-1]=='*'
                    && square[a-2][b]=='.' && square[a-2][b-1]=='.'){
                temp=square[a][b]; square[a][b]=square[a-2][b]; square[a-2][b]=temp;
                temp=square[a][b-1]; square[a][b-1]=square[a-2][b-1]; square[a-2][b-1]=temp;
            }

        }
    }


    void move_down(int a , int b){

        char temp;
        if(is_down(a,b)){
            if(square[a][b]=='$' && square[a+1][b]=='.'){
                temp = square[a][b]; square[a][b] =square[a+1][b]; square[a+1][b]= temp;
            }else if(square[a][b]=='*' && square[a][b+1]=='*' && square[a+1][b]=='.' && square[a+1][b+1]=='.'){
                temp=square[a-1][b]; square[a-1][b]=square[a+1][b]; square[a+1][b]=temp;
                temp=square[a-1][b+1]; square[a-1][b+1]=square[a+1][b+1]; square[a+1][b+1]=temp;
            }else if(square[a][b]=='*' && square[a][b+1]=='*' && square[a+1][b]=='*' && square[a+1][b+1]=='*' &&
                    square[a+2][b]=='.' && square[a+2][b+1]=='.'){
                temp=square[a][b]; square[a][b]=square[a+2][b]; square[a+2][b]=temp;
                temp= square[a][b+1] ; square[a][b+1] =square[a+2][b+1]; square[a+2][b+1]=temp;
            }else if(square[a][b]=='*' && square[a][b-1]=='*' && square[a+1][b]=='.' && square[a+1][b-1]=='.'){
                temp= square[a-1][b]; square[a-1][b]=square[a+1][b]; square[a+1][b]=temp;
                temp=square[a-1][b-1]; square[a-1][b-1]=square[a+1][b-1]; square[a+1][b-1]=temp;
            }else if(square[a][b]=='*' && square[a][b-1]=='*' && square[a+1][b]=='*' && square[a+1][b-1]=='*' &&
                    square[a+2][b]=='.' && square[a+2][b-1]=='.'){
                temp=square[a][b]; square[a][b]=square[a+2][b]; square[a+2][b]=temp;
                temp=square[a][b-1]; square[a][b-1]=square[a+2][b-1]; square[a+2][b-1]=temp;
            }
        }
    }


    boolean is_goal(char[][]arr){
        if(arr[4][1] == '*' && arr[4][2] == '*')
            return true;
        return false;
    }



    public static void print_arr(char[][]arr){
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<4 ; j++){
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }



    boolean is_possible(int a, int b){
        if(a<5 && a>=0 && b<4 && b>=0)
        {
            return true;
        }else
            return false;
    }

    boolean is_dir(int a){
        if(a==-1 || a==1 || a==-2 || a==2)
        {
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {

        Zombie_k obj = new Zombie_k();
        saved = new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(obj.square[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }

        while(!obj.is_goal(obj.square))
        {

            System.out.print("please enter the block you want to move:\n");
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            int y = in.nextInt();

            while(!obj.is_possible(x,y)){

                System.out.println("ERROR ReEnter plz");
                x = in.nextInt();

                y = in.nextInt();

            }

            System.out.println(" Left => Press -1 // Right => Press 1 // Up => Press -2 // Down => Press 2");
            int dir = in.nextInt();

            switch(dir){
                case -1 :
                    if(obj.is_possible(x,y-1) && obj.is_left(x,y)){
                        obj.move_left(x,y);
                        count++;
                    }else{
                        System.out.println("Can't Move");
                    }
                    break;
                case 1 :
                    if(obj.is_possible(x,y+1) && obj.is_right(x,y)){
                        obj.move_right(x,y);
                        count++;
                    }else{
                        System.out.println("Can't Move");
                    }
                    break;
                case -2 :
                    if( obj.is_possible(x-1,y) && obj.is_up(x,y)){
                        obj.move_up(x,y);
                        count++;
                    }else{
                        System.out.println("Can't Move");
                    }
                    break;
                case 2 :
                    if(
                            obj.is_possible(x+1,y) && obj.is_down(x,y)){
                        obj.move_down(x,y);
                        count++;
                    }else{

                        System.out.println("Can't Move");
                    }
                default :
                    System.out.println("Incorrecr Direction ---- Play Again ");
                    break;
            }

            obj.print_arr(obj.square);
            System.out.println("STEP : " + count);

        }
        System.out.println("*** YOU WIN ***");
    }

}
