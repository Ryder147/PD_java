package pl.sggw;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WzimSet<T> implements Set<T> {

    List<T> list=new WzimList<>();

    public WzimSet(){}

    public static void show(Object[] tab){
        for (Object i:tab) {
            System.out.println(i);

        }
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        if(!(list.contains(t))){
            list.add(t);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(list.remove(o)){
            list.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if(list.containsAll(c)){
            return true;
        }
        return false;
    }



    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] bufor= (T[]) c.toArray();
        int licznik=0;
        for (T i:bufor          ) {
            if(!(list.contains(i))){
                list.add(i);
                licznik+=1;
            }
        }
        if(licznik!=0){
        return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(list.retainAll(c)){
            list.retainAll(c);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(list.removeAll(c)){
            list.removeAll(c);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void clear() {
        list.clear();

    }

    public static void main(String[] args) {
        Set<String> set=new WzimSet<>();
        set.add("Elo");
        set.add("Arek");
        set.add("Mordo");

        show(set.toArray());
        System.out.println(set.add("Elo0")+"----\n");
        System.out.println(set.add("Elooo"));
        show(set.toArray());


        Set<String> nowy=new WzimSet<>();
        nowy.add("Elo");
        nowy.add("Elooo");
        //nowy.add("Arek");
        //System.out.println(set.addAll(nowy));
        System.out.println("asdasdasdasdasdasd");
        set.removeAll(nowy);

        show(set.toArray());

        System.out.println(set.size());
    }
}
