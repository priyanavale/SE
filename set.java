import java.util.*;
public class set {
    void search(Set<String>set1,String setname)
    {
        System.out.println("Enter he element to searched : ");
        Scanner s=new Scanner(System.in);
        String name=s.nextLine();
        if(set1.contains(name))
        {
            System.out.println("Student is found "+setname);
        }
        else
        {
            System.out.println("student is not found");
        }
    }
    void union(Set<String>set1,Set<String>set2)
    {
        Set<String>union_set=new HashSet<>(set1);
        union_set.addAll(set2);
        System.out.println("Union set = "+union_set);
    }
    void intersection(Set<String>set1,Set<String>set2)
    {
        Set<String>interSet=new HashSet<>(set1);
        interSet.retainAll(set2);
        System.out.println("Intersection set : "+interSet);
    }
    void difference(Set<String>set1,Set<String>set2)
    {
        Set<String>diffSet=new HashSet<>(set2);
        diffSet.removeAll(set2);
        System.out.println("Difference set : "+diffSet);
    }
    void subset(Set<String>set1,Set<String>set2)
    {
        if(set2.containsAll(set1))
        {
            System.out.println("SET 1 IS SUBSET OF SET1");
        }
        else
        {
            System.out.println("set1 is not subset of set 2");
        }

    }
    void delete(Set<String>set1)
    {
        Set<String>set3=new HashSet<>();
        set3.removeAll(set1);
        System.out.println("DELETED SET IS "+set3);
    }
    public static void main(String[] args) 
    {
        set S=new set();
        Scanner s= new Scanner(System.in);
        Set<String>cricket=new HashSet<String>();
        System.out.println("Enter the no. of the students who play cricket");
        int n=s.nextInt();
        System.out.println("enter the name of student : ");
        String name;
        for(int i=0;i<=n;i++)
        {
            name=s.nextLine();
            cricket.add(name);
        }

        Set<String>football=new HashSet<String>();
        System.out.println("Enter the no. of the students who play cricket");
        n=s.nextInt();
        System.out.println("enter the name of student : ");
        for(int i=0;i<=n;i++)
        {
            name=s.nextLine();
            football.add(name);
        }

        System.out.println(" Cricket = "+cricket);
        System.out.println("Football = "+football);
        S.search(cricket,"cricket");
        S.union(cricket,football);
        S.difference(cricket,football);
        S.intersection(cricket,football);
        S.subset(cricket,football);
        S.delete(football);
        S.delete(cricket);


    }

}       




        
    



