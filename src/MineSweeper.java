import java.util.Scanner;
public  class MineSweeper {
    static String field[][],matrix[][];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of row : ");
        int row = input.nextInt();
        System.out.print("Enter number of column : ");
        int column = input.nextInt();

        int minesNumber=(int)((row*column)/4);
        int fieldSize=row*column;
        int right=fieldSize-minesNumber;
        int sum = 0;
        boolean isWin=true;

        createField(row, column);

        while (isWin)
        {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.print("\n");
            }

            System.out.print("Enter the row you want to select : ");
            int selectedRow = (input.nextInt()) - 1;
            if(selectedRow>=row){
                 do {
                     System.out.print("You over the row size!\nEnter the row you want to select : ");
                     selectedRow = (input.nextInt()) - 1;
                 }while(selectedRow>=row);
            }

            System.out.print("Enter the column you want to select : ");
            int selectedColumn = (input.nextInt()) - 1;
            if(selectedColumn>=column){
                do {
                    System.out.print("You over the column size!\nEnter the column you want to select : ");
                    selectedColumn = (input.nextInt()) - 1;
                }while(selectedColumn>=column);
            }

            if (row >= selectedRow && column >= selectedColumn && selectedRow >= 0 && selectedColumn >= 0) {
                if (matrix[selectedRow][selectedColumn] == "*") {
                    printMines(row, column);
                    System.out.println("You lost!");
                    isWin=false;
                }
                else
                {
                    if (selectedRow - 1 >= 0 && selectedColumn - 1 >= 0)
                        if (matrix[selectedRow - 1][selectedColumn - 1] == "*")
                            sum++;
                    if (selectedRow - 1 >= 0)
                        if (matrix[selectedRow - 1][selectedColumn] == "*")
                            sum++;
                    if (selectedRow - 1 >= 0 && selectedColumn + 1 < column)
                        if (matrix[selectedRow - 1][selectedColumn+1] == "*")
                            sum++;
                    if (selectedColumn - 1 >= 0)
                        if (matrix[selectedRow][selectedColumn-1] == "*")
                            sum++;
                    if (selectedColumn + 1 <column)
                        if (matrix[selectedRow][selectedColumn+1] == "*")
                            sum++;
                    if (selectedRow + 1 < row && selectedColumn - 1 >= 0)
                        if (matrix[selectedRow +1][selectedColumn-1] == "*")
                            sum++;
                    if (selectedRow + 1 < row)
                        if (matrix[selectedRow + 1][selectedColumn] == "*")
                            sum++;
                    if (selectedRow + 1 < row && selectedColumn + 1 < column)
                        if (matrix[selectedRow + 1][selectedColumn+1] == "*")
                            sum++;
                    field[selectedRow][selectedColumn] = String.valueOf(sum);
                }
            }
            right--;
            if(right==0){
                System.out.println("You Win!");
                printMines(row,column);
                break;
            }
        }
    }
    public static void createField(int row,int column)
    {
        matrix = new String[row][column];
        field=new String[row][column];
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                matrix[i][j]="-";
                field[i][j]="-";
            }
        }
        createMines(row, column);
        //printMines(row,column);
    }
    public static void printMines(int row,int column)
    {
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println("==============================");
    }
    public static void createMines(int row,int column)
    {
        int minesNumber=(int)((row*column)/4);
        for (int i=0;i<minesNumber;i++)
        {
            int randomX=(int)(Math.random()*row);
            int randomY=(int)(Math.random()*column);
            if (matrix[randomX][randomY]=="*"){
                minesNumber++;
            }
            else {
                matrix[randomX][randomY]="*";
            }
        }
    }

}