import java.util.*;

public class merge1 
{
    void merge(int a[],int beg,int mid,int end)
    {
        int i,j,k;
        int n1=mid-beg+1;
        int n2=end-mid;
        int LeftArray[]=new int[n1];
        int RightArray[]=new int[n2];

        for(i=0;i<n1;i++)
        {
            LeftArray[i]=a[beg+i];
        }
        for(j=0;j<n2;j++)
        {
            RightArray[i]=a[mid+1+j];
        }
        i=0;
        j=0;
        k=beg;
        while(i<n1 && j<n2)
        {
            if(LeftArray[i]<=RightArray[j])
            {
                a[k]=LeftArray[i];
                i++;
            }
            else
            {
                a[k]=RightArray[j];
            }
            k++;
        }
        while(i<n1)
        {
            a[k]=LeftArray[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            a[k]=RightArray[j];
            j++;
            k++;
        }

    }

    void mergeSort(int a[],int beg,int end)
    {
        if(beg<end)
        {
            int mid=(beg+end)/2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid+1, end);
            merge(a, beg, mid, end);
        }
    }

    void printArray(int a[],int n)
    {
        int i;
        for(i=0;i<n;i++)
        System.out.print(a[i]+" ");
    }

    public static void main(String[] args) {
        int n;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the no of the scores : ");
        n=s.nextInt();
        int[] array=new int[n];
        System.out.println("enter the score ");
        for(int i=0;i<n;i++)
        {
            array[i]=s.nextInt();
        }
        merge1 m=new merge1();
        System.out.println("Before sorting array");
        m.printArray(array, n);
        m.mergeSort(array, 0, n-1);
        System.out.println("After sorting array is");
        m.printArray(array, n);


    }

}
