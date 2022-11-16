package J1Day1BubleSort;
public class J1Day1BubleSort {
    public static void main(String[] args) {
        int[] m={5,10,9,15,22,0,-5,36};
        for(int i=0;i<m.length;i++) System.out.print(m[i]+" ");
        System.out.println();
        BubleSort(m);
        for(int i=0;i<m.length;i++) System.out.print(m[i]+" ");
    }
        public static void BubleSort(int d[]) {
        for (int i=0;i<d.length-1;i++)
            for (int j=0;j<d.length-1-i;j++)
                if (d[j]>d[j+1]){
                    int tmp=d[j];
                    d[j]=d[j+1];
                    d[j+1]=tmp;
                }       
    }
    
}
