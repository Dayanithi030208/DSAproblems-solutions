class MyHashList{
    private static class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
        private int capacity=10;
        private Node[] table;
        public MyHashList(){
            table=new Node[capacity];
        }
        public int hash(int key){
            return key%capacity;
        }
        public void put(int key,int value){
            Node newnode=new Node(key,value);
            int index=hash(key);
            Node head=table[index];
            for(Node temp=head;temp!=null;temp=temp.next){
                if(temp.key==key){
                    temp.value=value;
                    return;
                }
            }
        newnode.next=head;
        table[index]=newnode;
        return;
        }
        public int get(int key){
            int index=hash(key);
            Node head=table[index];
            if(head==null){
                return -1;
            }
            else{
                Node temp=head;
                while(temp!=null){
                    if(temp.key==key){
                        return temp.value;
                    }
                    temp=temp.next;
                }
                return -1;
            }
        }
        public void remove(int key){
            int index=hash(key);
            Node head=table[index];
            if(head==null) return;
            Node prev=null;
            Node temp=head;
            while(temp!=null){
                if(temp.key==key){
                    if(prev==null){
                        table[index]=temp.next;
                    }else{
                        prev.next=temp.next;
                    }
                    return;
                }
                prev=temp;
                temp=temp.next;
            }
        }
    }
public class HashOperations {
    public static void main(String[] args) {
        MyHashList has=new MyHashList();
        has.put(3,3);
        has.put(2,8);
        has.put(0,4);
        has.put(5,0);
        System.out.println(has.get(0));
        has.remove(0);
        System.out.println(has.get(2));
        System.out.println(has.get(0));
    }
}
