package lab;
import java.util.*;
public class MissedCalls {
    public static void main(String args[]) {
        ArrayList<Contacts> contacts = new ArrayList<>();
        ArrayList<MissCall> mc = new ArrayList<MissCall>();
        contacts.add(new Contacts(1576241361,"P1"));
        contacts.add(new Contacts(1576241364,"P2"));
        contacts.add(new Contacts(1576241375,"P3"));
        contacts.add(new Contacts(1576241312,"P4"));
        contacts.add(new Contacts(1576241398,"P5"));
        System.out.println(contacts);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Select 1 - add missed calls, 2-display, 3- delete, 4-exit");
            switch(sc.nextInt())
            {
                case 1:
                    System.out.println("Enter phone number");
                    long num=sc.nextLong();
                    mc.add(new MissCall(num, new Date()));
                    if(mc.size()>10)
                        mc.remove(0);
                    break;
                case 2:
                    for(MissCall m:mc){
                        int flag=0;
                        for(Contacts c:contacts){
                            if (m.number == c.number){
                                flag=1;
                                System.out.println("Name: "+c.name+"\nNumber: "+m.number+"\nDate: "+m.date);
                            } 
                        }
                        if(flag==0){
                            System.out.println("Name: "+"private caller"+"\nNumber: "+m.number+"\nDate: "+m.date);
                        }
                    }
                    break;
                case 3:
                    System.out.println("1.delete by index, 2-delete by number");
                    switch(sc.nextInt()){
                        case 1:
                            int i=1;
                            for(MissCall m:mc)
                            {
                                System.out.println(i++ +":"+m.number);
                            }
                            System.out.println("Enter the index to be deleted");
                            int ch=sc.nextInt();
                            mc.remove(ch-1);
                            break;
                        case 2:
                            System.out.println("Enter the number to be deleted");
                            long n = sc.nextLong();
                            Iterator<MissCall> iterator = mc.iterator();
                            while(iterator.hasNext()) {
                                MissCall m = iterator.next();
                                if(n == m.number) {
                                    iterator.remove();
                                    break;
                                }
                            }
                            break;
                    }
                    break;
                default: 
                        sc.close();
                        System.exit(0);
            }
        }
    }

}

class Contacts
{
    long number;
    String name;
    public Contacts(long number, String name) {
        super();
        this.number = number;
        this.name = name;
    }
    @Override
    public String toString() {
        return (number + ":" + name);
    }

}

class MissCall
{
    long number;
    Date date;
    public MissCall(long number, Date date) {
        super();
        this.number = number;
        this.date = date;
    }
    @Override
    public String toString() {
        return "number=" + number + "\n date=" + date;
    }


}