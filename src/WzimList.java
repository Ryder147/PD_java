
import java.lang.reflect.Array;
import java.util.*;


public class WzimList<E> implements java.util.List<E>
{
     int size =0;
     E[] tab= (E[]) new Object[0];

     public WzimList( ){

     }

    public static void show(Object[] tab){
        for (Object i:tab) {
            System.out.println(i);

        }
    }
    public static boolean czyZawiera(Object[] tab,Object o){
        for (Object i:tab
        ) {
            if(i.equals(o)){
                return true;
            }
        }
        return false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size ==0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
         if(size !=0){
            for (E i:tab
                 ) {
                if(i.equals(o)){
                    return true;
                }
            }
            return false;
         }else{
             return false;
         }


    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public E[] toArray() {
        @SuppressWarnings("unchecked")
        final E[] e = tab;
        return e;
    }

    @Override
    public boolean add(E o) {

            if(size !=0){
            //E[] proxy= (E[]) Array.newInstance(o.getClass(), index+1);
            E[] proxy= Arrays.copyOf(tab, tab.length+1);
            proxy[tab.length] = o;
            tab = proxy;
            size += 1;
            return true;
            }else{

                E[] proxy= (E[]) Array.newInstance(o.getClass(), size +1);
                proxy[0] = o;
                tab = proxy;
                size += 1;
                return true;
            }




    }

    @Override
    public boolean remove(Object o) {
        if(size !=0){
            if(czyZawiera(tab,o)){
                E[] proxy= Arrays.copyOf(tab, tab.length-1);
                int j=0;
                for (int i = 0; i <tab.length ; i++) {

                    if(!(tab[i].equals(o))){
                        proxy[j]=tab[i];
                        j+=1;
                    }

                }
                tab=proxy;
                size -=1;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {

         E[] n= (E[]) c.toArray();
        E[] proxy=Arrays.copyOf(tab,tab.length+c.size());
        for (int i = tab.length; i <proxy.length ; i++) {
            proxy[i]=n[i-tab.length];
        }
        tab=proxy;
        size +=n.length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
         if(index<size){
        E[] n= (E[]) c.toArray();
        E[] proxy=Arrays.copyOf(tab,tab.length+n.length);
        for (int i = index; i <n.length+index; i++) {
            proxy[i]=n[i-index];
        }
        for (int i = index; i <tab.length; i++) {
            proxy[i+n.length]=tab[i];
        }
        tab=proxy;
        size+=n.length;
        return true;
         }
         return false;
    }

    @Override
    public void clear() {
        E[] proxy=Arrays.copyOf(tab,0);
        tab=proxy;
        size=0;
    }

    @Override
    public E get(int index) {
        return tab[index];
    }

    @Override
    public E set(int index, E element) {
         if(index<tab.length){
        tab[index]=element;
        return tab[index];}
         return null;
    }

    @Override
    public void add(int index, E element) {
         if(index< tab.length){
        E[] proxy=Arrays.copyOf(tab,tab.length+1);
        int j=0;
             for (int i = 0; i < proxy.length; i++) {
                 if(i!=index){
                     proxy[i]=tab[j];
                     j+=1;
                 }else{
                     proxy[i]=element;
                 }
             }
             tab=proxy;
             size+=1;
         }

    }

    @Override
    public E remove(int index) {
        if(index< tab.length){
            E usunieta=tab[index];
            E[] proxy=Arrays.copyOf(tab,tab.length-1);
            int j=0;
            for (int i = 0; i < tab.length; i++) {
                if(i!=index){
                    proxy[j]=tab[i];
                    j+=1;

                }
            }
            tab=proxy;
            size-=1;
            return usunieta;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if(tab.length>0){
            for (int i = 0; i <tab.length ; i++) {
                if(tab[i].equals(o)){
                    return i;
                }
            }
        }return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int last=-1;
        for (int i = 0; i <tab.length ; i++) {
            if(tab[i].equals(o)){
                last=i;
            }
        }
        return last;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public java.util.List subList(int fromIndex, int toIndex) {
        if(fromIndex<tab.length){
            List<E> bufor=new ArrayList<>();
            for (int i = fromIndex; i <toIndex && i<tab.length ; i++) {
                bufor.add(tab[i]);
            }
            return bufor;
        }
        return null;

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        E[] bufor= (E[]) c.toArray();
        int licznik=0;
        for (int i = 0; i < bufor.length ; i++) {
            if(czyZawiera(tab,bufor[i])){
                licznik+=1;
            }
        }
        System.out.println(licznik);
        if(licznik>0){
            E[] proxy=Arrays.copyOf(tab,tab.length-licznik);
            int k=0;
            for (int i = 0; i < tab.length; i++) {
                boolean jest=false;
                for (int j = 0; j <bufor.length ; j++) {
                    if(tab[i].equals(bufor[j])){
                        jest=true;
                    }

                }if(!jest) {
                    proxy[k] =tab[i];
                    k+=1;
                }
            }
            tab=proxy;
            return true;
        }
        return false;

    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public static void main(String[] args) {

        List<String> list=new WzimList<>();

        list.add("Elo");
        list.add("Mordo");
        list.add("Siema");
        list.add("Mordo");
        list.add("Kocyk");
        list.add("Elo");

        //show(list.toArray());
        //System.out.println(list.remove("Elo"));
        show(list.toArray());
        String[] tab= (String[]) list.toArray();
        System.out.println("---------");




        List<String> lista1=new ArrayList<>();
        lista1.add("Elo");
        lista1.add("Mordo");
/*
        list.addAll(2,lista1);
        show(list.toArray());
        System.out.println("-------");
        //list.add(3,"nokie");
        list.add(4,"Elo");
        show(list.toArray());
        System.out.println("--------");
        //list.remove(2);

 */
        show(list.toArray());
        list.removeAll(lista1);
        System.out.println("---------");
        show(list.toArray());
















    }
}
