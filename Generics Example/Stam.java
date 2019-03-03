public class Stam <T> {
    private T obj;

    public Stam(T obj){
        this.obj=obj;
    }

    public void print(){
        System.out.println(obj);
    }

    public <S extends T> void printSub(S sub){
        System.out.println(sub);
    }
}
