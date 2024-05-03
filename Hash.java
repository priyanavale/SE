import java.util.Scanner;

class Hash {
    static class Hashing {
        int index;
        long mno;
    }

    Hashing[] h = new Hashing[10];
    int i;
    Scanner s = new Scanner(System.in);

    public Hash() {
        for (i = 0; i < 10; i++) {
            h[i] = new Hashing();
            h[i].index = i;
            h[i].mno = -1;
        }
    }

    void Display() {
        System.out.println("INDEX|MNO       ");
        for (int i = 0; i < 10; i++) {
            System.out.println("|" + h[i].index + "  |" + h[i].mno);

        }
    }

    void insert() {
        System.out.println("Enter the mobile no to store into a hashtable");
        long key;
        key = s.nextLong();
        int position, probchoice;
        position = (int) (key % 10);
        System.out.println("\nposition=" + position);
        if (h[position].mno == -1) {
            h[position].mno = key;
        } else {
            System.out.println("Collision is occur \nEnter the probing choice:");
            probchoice = s.nextInt();
            if (probchoice == 1) {
                int temp;
                temp = linearProbing(position);
                h[temp].mno = key;
            } else if (probchoice == 2) {
                int temp;
                temp = QuadraticProbing(key);
                h[temp].mno = key;
            } else {
                System.out.println("invalid choice");
            }

        }
    }

    int linearProbing(int position) {
        for (i = position; i < 10; i++) {
            if (h[i].mno == -1)
                return i;
            if (i == 9) {
                i = -1;
            }
        }
        return 0;

    }

    int QuadraticProbing(long key) {
        int a;
        for (int i = 0; i < 10; i++) {
            a = (int) ((key + (i * i)) % 10);
            if (h[i].mno == -1) {
                return a;
            }
        }

        return 0;
    }

    void search() {
        long key;
        int position;
        System.out.println("Enter the no to be searched");
        key = s.nextLong();
        position = (int) (key % 10);
        for (int i = 0; i < 10; i++) {
            if (h[i].mno == key) {
                System.out.println("mobile no is found");

            }
            else
            {
                System.out.println("mobile no id not found");
            }
        }
    }
    public static void main(String[] args) {
        Hash h1=new Hash();
        int ch;
        Scanner s= new Scanner(System.in);
        do{
        System.out.println("Menu \n1.Insert a value \n2.to search value\n3.Display \n4.exit");
        
        ch=s.nextInt();
        switch(ch)
        {
            case 1:
            h1.insert();
            break;

            case 2:
            h1.search();
            break;

            case 3:
            h1.Display();
            break;
        }
    }while(ch!=4);
    
}
}
