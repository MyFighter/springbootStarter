import java.util.SortedSet;

public class SetTest {
    public static void main(String[] args) {
    }
}

class Item implements Comparable<Item>{

    private String desc;
    private int partNumber;

    public Item(String desc, int partNum){
        this.desc = desc;
        this.partNumber = partNum;
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "desc='" + desc + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }
}
