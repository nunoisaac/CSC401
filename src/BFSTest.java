import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Main method
 * Reads in matrix, creates adjacency list, finds BFS tree
 *
 * @author Isaac J. Nuno
 *
 */
public class BFSTest {
    public static void main(String[] args)
    {
        userMenu();
    }
    /**
     *User Options
     */
    public static void userMenu()
    {

        do {
            System.out.printf("%s", "Enter file path: ");
            Scanner scnr = new Scanner(System.in);
            String filePath = scnr.nextLine();
            String matrix = copyMatrix(filePath);
            LinkedList<LinkedList<Integer>> adjList = createAdjacencyList(filePath);
            printMatrix(matrix);
            printAdjList(adjList);
            printBFSTree(adjList);
            printOptions();

            String userInput;
            do {
                userInput = scnr.nextLine().toLowerCase();
                switch (userInput) {
                    case "1":
                        printMatrix(matrix);
                        printOptions();
                        break;
                    case "2":
                        printAdjList(adjList);
                        printOptions();
                        break;
                    case "3":
                        printBFSTree(adjList);
                        printOptions();
                        break;
                    case "4":  //Enter new graph, exit while loop
                        break;
                    case "e":
                        System.out.printf("%s\n", "---------------End of program---------------");
                        System.exit(-1);
                    default:
                        System.out.printf("%s\n", "Choose an option from the list: ");
                        printOptions();
                        break;
                }
            } while (!userInput.equals("4"));
        }while(true);
    }

    /**
     * Creates Adjacency list from Matrix
     *
     * @param   filePath file path to text document
     * @return  Adjacency List
     */
    public static LinkedList<LinkedList<Integer>> createAdjacencyList(String filePath)
    {
        LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();      //List to hold list of connected nodes
        String row;
        try
        {

            int y=0;

            File inputFile = new File(filePath);
            Scanner fileInput = new Scanner(inputFile);
            row=fileInput.nextLine().replace(" ","");
            for(int i=0;i<row.length();i++)                     //for N nodes
            {
                adjList.add(new LinkedList<Integer>());         //Creates LinkedList for all nodes
            }
            while(fileInput.hasNext())
            {
                for (int x=y+1; x < row.length(); x++)          //A node doesn't have an edge to itself therefore x=y+1
                {
                    if (row.charAt(x) == '1') {
                       adjList.get(y).add(x);                   //If node a is linked to b, add b to nodes that a is linked to
                       adjList.get(x).add(y);                   //If node b is linked to a, add a to nodes that b is linked to
                    }
                }
                row=fileInput.nextLine().replace(" ","");
                y++;                                            //current row

            }
            fileInput.close();

        }catch(FileNotFoundException e){System.out.printf("%s", "File not found. Check path.");}
        catch(InputMismatchException e){System.out.printf("%s", "Check file for bad data.");}
        return adjList;
    }

    /**
     * Saves Matrix read from text file as a String
     *
     * @param   filePath path to text file
     * @return  Matrix string
     */
    public static String copyMatrix(String filePath)
    {
        StringBuilder temp = new StringBuilder();
        try
        {
            File inputFile = new File(filePath);
            Scanner fileInput = new Scanner(inputFile);
            while(fileInput.hasNext())
            {
                temp.append(fileInput.nextLine()).append("\n");     //appends line read from text to temp string
            }
            fileInput.close();
        }catch(FileNotFoundException e){System.out.printf("%s", "File not found. Check path.");}
        catch(InputMismatchException e){System.out.printf("%s", "Check file for bad data.");}
        return temp.toString();

    }

    /**
     * Prints Matrix saved from text file
     * @param matrix string
     */
    public static void printMatrix(String matrix)
    {
        System.out.printf("%40s\n%s","Matrix representation of input graph","********************************************\n");
        System.out.printf("%s\n",matrix);
    }


    /**
     *Prints Adjacency List derived from Matrix
     *
     * @param adjList Adjacency List
     */
    public static void printAdjList(LinkedList<LinkedList<Integer>> adjList)
    {
        System.out.printf("%s\n","*********************************************");
        System.out.printf("%s%-20s\n\n","Number of nodes in graph: ",adjList.size());
        System.out.printf("%s\n","---------Adjacency List---------");

        int index=0;
        for (LinkedList<Integer> node : adjList) {          //For every node a
            System.out.printf("%s %s %s ","Node",index,":");    //Print node a
            for (Integer edge : node) {
                System.out.printf("%s ",edge);               //Print all nodes connected to node a
            }
            System.out.printf("%s\n","");                       //new line
            index++;                                            //Next node
        }
        System.out.printf("%s\n\n","");

    }

    /**
     * Breadth First Search using Adjacency List
     *
     * @param adjList Adjacency List
     */
    public static void printBFSTree(LinkedList<LinkedList<Integer>> adjList)
    {
        int s;                                                         //Starting node
        int[] Discovered = new int[adjList.size()];                    //List of visited nodes
        LinkedList<Integer> queue = new LinkedList<>();                //Queue to keep track of which node to visit next

        System.out.printf("\n%s\n","---------BFS Tree---------");
        System.out.printf("%s","Select the starting node: ");
        Scanner scnr = new Scanner(System.in);
        s = scnr.nextInt();                                             //Root

        while(s < 0 || s > adjList.size()-1)
        {
            System.out.printf("%s%s : ","Select node within range: 0 to ",adjList.size()-1);
            s = scnr.nextInt();
        }

        System.out.printf("\n\n%s\n","---------BFS Tree---------");
        System.out.printf("%s %s\n","Parent:","Child");

        Discovered[s]=1;                                                //Set Discovered root to true
        queue.add(s);                                                   //add root to queue

        while(!queue.isEmpty())                                         //while queue is not empty
        {
            Iterator<Integer> itr = adjList.get(s).iterator();          //Iterate for nodes connected to current node
            System.out.printf("%6s: ",s);                               //Prints parent node
            while(itr.hasNext())                                        //For each node
            {
                s=itr.next();                                           //Set s to child node
                if(Discovered[s]!=1)
                {
                    queue.add(s);                                       //Add undiscovered node to queue
                    Discovered[s]=1;                                    //Set discovered node to true
                    System.out.printf("%s ",s);                         //Prints all child of current parent node
                }
            }

            System.out.printf("%s\n","");
            if(!queue.isEmpty())
                queue.poll();                                           //Remove node
            if(!queue.isEmpty())
                s=queue.peek();                                         //Next node
        }
    }


    public static void printOptions()
    {
        System.out.print("\n\n\n**************************************************"+"\n"+
                "Please select from one of the following options: \n\n"+
                "(1) View Matrix\n"+
                "(2) View Adjacency List\n"+
                "(3) BFS Search\n"+
                "(4) New Matrix\n"+
                "(E) Exit\n");
    }
}
